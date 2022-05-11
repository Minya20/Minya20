<?php  

$con=mysqli_connect("studyseller.cpyzys3vy4u7.ap-northeast-2.rds.amazonaws.com","myadmin","minyeong", "studyseller");  
if (!$con)  
{  
   echo "MySQL 접속 에러 : ";
   echo mysqli_connect_error();
   exit();  
}  

mysqli_set_charset($con,"utf8"); 


$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

$sql="select * from user";

$result=mysqli_query($con,$sql);
$response["suceess"] = false;
//$response2["pw"] = false; 
//$data = array();   

   
   while($row=mysqli_fetch_array($result)){
	$response["suceess"] = true;
	$response[] = $row["user_id"];
	$response[] = $row["user_pw"];
	$response[] = $row["user_nickname"];
	$response[] = $row["user_email"];
       //array_push($data, 
        //   array('id'=>$row[0],
         //  'pw'=>$row[1],
           //'nickname'=>$row[3]
       //));
	}

   
//header('Content-Type: application/json; charset=utf8');
//$json = json_encode(array($data), JSON_PRETTY_PRINT
//+JSON_UNESCAPED_UNICODE);
echo json_encode($response);





mysqli_close($con);  
  
?>