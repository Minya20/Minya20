<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');
        

    $stmt = $con->prepare("select * from record WHERE answer_answer_no LIKE '%18k%'");
    $stmt->execute();

    if ($stmt->rowCount() > 0)
    {
        $data = array(); 

        while($row=$stmt->fetch(PDO::FETCH_ASSOC))
        {
            extract($row);
    
            array_push($data, 
                array('rc_year'=>$rc_year,
                	'answer_answer_no'=>$answer_answer_no,
                	'rc_score'=>$rc_score,
		'user_user_id'=>$user_user_id,
		'rc_rank'=>$rc_rank
            ));
        }

        header('Content-Type: application/json; charset=utf8');
        $json = json_encode(array("webnautes"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
        echo $json;
    }

?>