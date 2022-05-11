<?php 

$conn = mysqli_connect("studyseller.cpyzys3vy4u7.ap-northeast-2.rds.amazonaws.com", 
	                   "myadmin",
                               "minyeong" ,
                               "studyseller");
 
 $sql = "SELECT wt_no,wt_allNumber,wt_rightNumber,wt_wrongNumber FROM wrongNote";
   $result = mysqli_query($conn, $sql);
   if (mysqli_num_rows($result) > 0) {
   while($row = mysqli_fetch_assoc($result)) {
   echo "번호: " . $row["wt_no"].  
          "<br>모든 문항: " . $row["wt_allNumber"]. 
          "<br>맞은 문제: " . $row["wt_rightNumber"]. 
          "<br>틀린 문제: " . $row["wt_wrongNumber"]. 
          "<br>맞은 문제: " . $row["wt_rightNumber"]. 
          "<br>";
   }
   }else{
   echo "테이블에 데이터가 없습니다.";
   }	
mysqli_close($conn);
?>