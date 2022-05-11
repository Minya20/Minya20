<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');

   $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

$user_id=isset($_POST['user_id']) ? $_POST['user_id'] : '';
$user_pw = isset($_POST['user_pw']) ? $_POST['user_pw'] : '';

            if(empty($user_id) || empty($user_pw))
            {
                $errMSG = "아이디랑 비밀번호를 입력하세요.";
            }
            if(!isset($errMSG)) // 모든 정보가 입력이 되었다면
            {
                // SQL문을 실행하여 데이터를 MySQL 서버의 user 테이블에서 중복확인
                $sql="select * from user where user_id='$user_id' || user_pw='$user_pw'";
    	        $stmt = $con->prepare($sql);
    	        $stmt->execute();
                if($stmt->rowCount() == 1)
                {
        	        /*$sql="select * from user where user_id='$user_pw'";
    	            $stmt = $con->prepare($sql);
    	            $stmt->execute();*/
    	            $successMSG = "환영합니다.";
                }
                else if($stmt ->rowCount() == 0)
                {
                    $successMSG = "아이디 혹은 비밀번호가 틀렸습니다.";
	        break;
                }
            }


?>


<?php 
    if (isset($errMSG)) echo $errMSG;
    if (isset($successMSG)) echo $successMSG;

	$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
   
    if( !$android )
    {
?>
    <html>
       <body>

            <form action="<?php $_PHP_SELF ?>" method="POST">
	            id: <input type = "text" name = "user_id" />
                	password: <input type = "text" name = "user_pw" />
                <input type = "submit" name = "submit" />
                <br/> id 랑 이메일에 정보를 입력하면 <br/>중복 확인을 할 수 있습니다.
            </form>
       
       </body>
    </html>

<?php 
    }
?>