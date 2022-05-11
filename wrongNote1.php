<?php 

$conn = mysqli_connect("studyseller.cpyzys3vy4u7.ap-northeast-2.rds.amazonaws.com", 
	                   "myadmin",
                               "minyeong" ,
                               "studyseller");
if (!$conn)
{
	echo "MySQL 접속 에러 : ";
	echo mysqli_connect_error();
	exit();
}
mysqli_set_charset($conn,"utf-8");
 
 $sql = "SELECT wt_no,wt_allNumber,wt_rightNumber,wt_wrongNumber FROM wrongNote";
   
   $result = mysqli_query($conn, $sql);
   $data = array();
   if ($result) {

   while($row = mysqli_fetch_array($result)) {
	array_push($data,
		array('wt_no' => $row[0],
		       'wt_allNumber' => $row[1],
		       'wt_rightNumber' => $row[2],
		       'wt_wrongNumber' => $row[3]
		));
	}
   header('Content-Type: application/json; charset=utf8');
   $json = json_encode(array("webnautes"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
   echo $json;
   }
   else{
   echo "error";
   echo mysqli_error($conn);
 }	
mysqli_close($conn);
?>