<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');
        

    $stmt = $con->prepare("select * from record WHERE answer_answer_no LIKE '%18k%'");
    $stmt->execute();

    $response["good"] = false;  

    if ($stmt->rowCount() > 0)
    {
         

        while($row=$stmt->fetch(PDO::FETCH_ASSOC))
        {
           //extract($row);
	$response["good"] = true;
	$response[] = $row["rc_score"];
	$response[] = $row["rc_year"];
	//$response[] = $row["user_user_id"];

        }
        echo json_encode($response);
    }

?>