<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');
        

    $stmt = $con->prepare('select * from user');
    $stmt->execute();

    if ($stmt->rowCount() > 0)
    {
        $data = array(); 

        while($row=$stmt->fetch(PDO::FETCH_ASSOC))
        {
            extract($row);
    
            array_push($data, 
                array('id'=>$user_id,
                'pw'=>$user_pw,
                'user_nickname'=>$user_nickname
            ));
        }

        header('Content-Type: application/json; charset=utf8');
        $json = json_encode(array("jsons"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
        echo $json;
    }

?>