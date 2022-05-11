<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');

   $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

$user_id=isset($_POST['user_id']) ? $_POST['user_id'] : '';
$user_pw = isset($_POST['user_pw']) ? $_POST['user_pw'] : '';
$user_email = isset($_POST['user_email']) ? $_POST['user_email'] : '';
$user_nickname = isset($_POST['user_nickname']) ? $_POST['user_nickname'] : '';
$user_gender = isset($_POST['user_gender']) ? $_POST['user_gender'] : '';
$user_mainGroup = isset($_POST['user_mainGroup']) ? $_POST['user_mainGroup'] : '';
$user_infocheck=isset($_POST['user_infocheck']) ? $_POST['user_infocheck'] : '';

        	if($user_id != ""){
            
                // SQL문을 실행하여 데이터를 MySQL 서버의 user 테이블에서 중복확인 
                $sql="select * from user where user_id='$user_id'";
    	        $stmt = $con->prepare($sql);
    	        $stmt->execute();
                if($stmt->rowCount() == 0)
                {
        	        $successMSG = "사용 가능한 아이디 입니다.";
                }
                else
                {
	                while($row=$stmt->fetch(PDO::FETCH_ASSOC))
	                {
                        echo "'";
        	            echo $user_id;
        	            echo "'은(는) 이미 사용중인 아이디 입니다.";
		                break;
	                }

                }
	        }
	        if ($user_email !="")
	        {
	            $sql="select * from user where user_email='$user_email'";
    	        $stmt = $con->prepare($sql);
    	        $stmt->execute();
    	        if($stmt->rowCount() == 0)
                {
        	        $successMSG = "사용 가능한 이메일 입니다.";
                }
                else
                {
	                while($row=$stmt->fetch(PDO::FETCH_ASSOC))
	                {
                        echo "'";
        	            echo $user_email;
        	            echo "'은(는) 이미 사용중인 이메일입니다.";
		                break;
	                }

                }
	        }
	        if(empty($user_pw)){
            $errMSG = "패스워드를 입력하세요.";

            }
            else if(empty($user_nickname)){
	        $errMSG = "닉네임을 입력하세요.";
            }
            else if(empty($user_gender)){
	        $errMSG = "성별을 입력하세요.";
            }
            else if(empty($user_mainGroup)){
	        $errMSG = "그룹숫자를 입력하세요.";
            }
            else if(empty($user_infocheck)){
	        $errMSG = "정보 공개 여부를 선택하세요";
            }
            if(!isset($errMSG)) // 모든 정보가 입력이 되었다면
            {
                try
                {
                    // SQL문을 실행하여 데이터를 MySQL 서버의 person 테이블에 저장합니다.
                    $stmt = $con->prepare('INSERT INTO user(user_id, user_pw, user_email, user_nickname, user_gender, user_mainGroup, user_infocheck) VALUES(:user_id, :user_pw, :user_email, :user_nickname, :user_gender, :user_mainGroup, :user_infocheck)');
                    $stmt->bindParam(':user_id', $user_id);
                    $stmt->bindParam(':user_pw', $user_pw);
	                $stmt->bindParam(':user_email', $user_email);
	                $stmt->bindParam(':user_nickname', $user_nickname);
	                $stmt->bindParam(':user_gender', $user_gender);
	                $stmt->bindParam(':user_mainGroup', $user_mainGroup);
	                $stmt->bindParam(':user_infocheck', $user_infocheck);
                if($stmt->execute())
                {
                    $successMSG = "사용자를 추가했습니다.";
                }
                else
                {
                    $errMSG = "사용자 추가 에러";
                }

                }
                catch(PDOException $e)
                {
                die("Database error: " . $e->getMessage());
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
	            email: <input type = "text" name = "user_email" />
	            nickname: <input type = "text" name = "user_nickname" />
	            gender: <input type = "text" name = "user_gender" placeholder="0은 남자 1은 여자" />
	            mainGroup: <input type = "text" name = "user_mainGroup" />
	            infocheck: <input type = "text" name = "user_infocheck" placeholder="0은 공개 1은 비공개" />
                <input type = "submit" name = "submit" />
                <br/> id 랑 이메일에 정보를 입력하면 <br/>중복 확인을 할 수 있습니다.
            </form>
       
       </body>
    </html>

<?php 
    }
?>