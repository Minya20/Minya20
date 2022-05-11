 <?php  
error_reporting(E_ALL); 
ini_set('display_errors',1); 

include('dbcon.php');



//POST 값을 읽어온다.
$country=isset($_POST['country']) ? $_POST['country'] : '';
$name = isset($_POST['name']) ? $_POST['name'] : '';
$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");


if ($country != "" ){ 

    $sql="select * from person where country='$country'";
    $stmt = $con->prepare($sql);
    $stmt->execute();
 
    if ($stmt->rowCount() == 0){

        /*echo "'";
        echo $country;
        echo "'은 찾을 수 없습니다.";
	*/
	$stmt = $con->prepare('INSERT INTO person(name, country) VALUES(:name, :country)');
                $stmt->bindParam(':name', $name);
                $stmt->bindParam(':country', $country);
	$stmt->execute();
	echo "사용자를 추가 했습니다.";
	

    }
	else{

   		$data = array(); 

        while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
	
	echo "'";
        	echo $country;
        	echo "'은 이미 있는 국가 입니다.";
	
        	/*extract($row);

            array_push($data, 
                array('id'=>$row["id"],
                'name'=>$row["name"],
                'country'=>$row["country"]
            ));*/
        }
    }
}
else {
    echo "검색할 나라를 입력하세요 ";
}

?>



<?php

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

if (!$android){
?>

<html>
   <body>
   
      <form action="<?php $_PHP_SELF ?>" method="POST">
         나라: <input type = "text" name = "country" />
         이름: <input type = "text" name = "name" />
         <input type = "submit" />
      </form>
   
   </body>
</html>
<?php
}

   
?>