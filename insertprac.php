<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbprac.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");


    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

        // 안드로이드 코드의 postParameters 변수에 적어준 이름을 가지고 값을 전달 받습니다.

        $id=$_POST['id'];
        $pw=$_POST['pw'];
        $email=$_POST['email'];
        $nickname=$_POST['nickname'];
        $gender=$_POST['gender'];
        $mainGroup=$_POST['mainGroup'];
        $infocheck=$_POST['infocheck'];
        
        if(empty($id)){
            $errMSG = "아이디를 입력하세요.";
        }
        else if(empty($pw)){
            $errMSG = "패스워드를 입력하세요.";
        }
        else if(empty($email)){
	$errMSG = "이메일을 입력하세요.";
        }
        else if(empty($nickname)){
	$errMSG = "닉네임을 입력하세요.";
        }
        else if(empty($gender)){
	$errMSG = "성별을 입력하세요.";
        }
        else if(empty($mainGroup)){
	$errMSG = "그룹숫자를 입력하세요.";
        }
        else if(empty($infocheck)){
	$errMSG = "정보 공개 여부를 선택하세요";
        }

        if(!isset($errMSG)) // 모든 정보가 입력이 되었다면 
        {
            try{
                // SQL문을 실행하여 데이터를 MySQL 서버의 person 테이블에 저장합니다. 
                $stmt = $con->prepare('INSERT INTO dbconprac(id, pw, email, nickname, gender, mainGroup, infocheck) VALUES(:id, :pw, :email, :nickname, :gender, :mainGroup, :infocheck)');
                $stmt->bindParam(':id', $id);
                $stmt->bindParam(':pw', $pw);
	    $stmt->bindParam(':email', $email);
	    $stmt->bindParam(':nickname', $nickname);
	    $stmt->bindParam(':gender', $gender);
	    $stmt->bindParam(':mainGroup', $mainGroup);
	    $stmt->bindParam(':infocheck', $infocheck);
                if($stmt->execute())
                {
                    $successMSG = "사용자를 추가했습니다.";
                }
                else
                {
                    $errMSG = "사용자 추가 에러";
                }

            } catch(PDOException $e) {
                die("Database error: " . $e->getMessage()); 
            }
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
                id: <input type = "text" name = "id" />
                password: <input type = "text" name = "pw" />
	    email: <input type = "text" name = "email" />
	    nickname: <input type = "text" name = "nickname" />
	    gender: <input type = "text" name = "gender" placeholder="1은 남자 2은 여자" />
	    mainGroup: <input type = "text" name = "mainGroup" />
	    infocheck: <input type = "text" name = "infocheck" placeholder="1은 공개 2은 비공개" />
                <input type = "submit" name = "submit" />
            </form>
       
       </body>
    </html>

<?php 
    }
?>