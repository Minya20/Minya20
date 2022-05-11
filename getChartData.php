<?php

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');
    
    $stmt = $con -> prepare("select * from record  WHERE answer_answer_no LIKE '18k%'");
    $stmt -> execute();

    if ($stmt -> rowCount() > 0) {
    
    $data = array();

        while($row=$stmt->fetch(PDO::FETCH_ASSOC))  {
	
	extract($row);
	
	array_push($data,
	    array('년도와 과목' => $answer_answer_no,
	    '점수' => $rc_score,
	    '푼 날짜' => $rc_year
	));
        }
        header('Content-Type:application/json; charset=utf8');
        $json = json_encode(array("webnautes"=>$data),JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
        echo  $json;
    }

?>