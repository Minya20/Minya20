<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

   


    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

        // 안드로이드 코드의 postParameters 변수에 적어준 이름을 가지고 값을 전달 받습니다.

        $bk_no=$_POST['bk_no'];
        $bk_year=$_POST['bk_year'];
        $bk_subject=$_POST['bk_subject'];
        $bk_number1=$_POST['bk_number1'];
        $bk_number2=$_POST['bk_number2'];
        $bk_number3=$_POST['bk_number3'];
        $bk_number4=$_POST['bk_number4'];
        $bk_number5=$_POST['bk_number5'];
        $bk_number6=$_POST['bk_number6'];
        $bk_number7=$_POST['bk_number7'];
        $bk_number8=$_POST['bk_number8'];
        $bk_number9=$_POST['bk_number9'];
        $bk_number10=$_POST['bk_number10'];
        $bk_number11=$_POST['bk_number11'];
        $bk_number12=$_POST['bk_number12'];
        $bk_number13=$_POST['bk_number13'];
        $bk_number14=$_POST['bk_number14'];
        $bk_number15=$_POST['bk_number15'];
        $bk_number16=$_POST['bk_number16'];
        $bk_number17=$_POST['bk_number17'];
        $bk_number18=$_POST['bk_number18'];
        $bk_number19=$_POST['bk_number19'];
        $bk_number20=$_POST['bk_number20'];
        $bk_number21=$_POST['bk_number21'];
        $bk_number22=$_POST['bk_number22'];
        $bk_number23=$_POST['bk_number23'];
        $bk_number24=$_POST['bk_number24'];
        $bk_number25=$_POST['bk_number25'];
        $bk_number26=$_POST['bk_number26'];
        $bk_number27=$_POST['bk_number27'];
        $bk_number28=$_POST['bk_number28'];
        $bk_number29=$_POST['bk_number29'];
        $bk_number30=$_POST['bk_number30'];
        $bk_number31=$_POST['bk_number31'];
        $bk_number32=$_POST['bk_number32'];
        $bk_number33=$_POST['bk_number33'];
        $bk_number34=$_POST['bk_number34'];
        $bk_number35=$_POST['bk_number35'];
        $bk_number36=$_POST['bk_number36'];
        $bk_number37=$_POST['bk_number37'];
        $bk_number38=$_POST['bk_number38'];
        $bk_number39=$_POST['bk_number39'];
        $bk_number40=$_POST['bk_number40'];
        $bk_number41=$_POST['bk_number41'];
        $bk_number42=$_POST['bk_number42'];
        $bk_number43=$_POST['bk_number43'];
        $bk_number44=$_POST['bk_number44'];
        $bk_number45=$_POST['bk_number45'];
        $user_user_id=$_POST['user_user_id'];
        $answer_answer_no=$_POST['answer_answer_no'];

/*        
        if(empty($user_id)){
            $errMSG = "아이디를 입력하세요.";
        }
        else if(empty($user_pw)){
            $errMSG = "패스워드를 입력하세요.";
        }
        else if(empty($user_email)){
	$errMSG = "이메일을 입력하세요.";
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
*/

        if(!isset($errMSG)) // 모든 정보가 입력이 되었다면 
        {
            try{
                // SQL문을 실행하여 데이터를 MySQL 서버의 person 테이블에 저장합니다. 
                $stmt = $con->prepare('INSERT INTO bookmark(bk_no,bk_year,bk_subject,
					bk_number1,bk_number2,bk_number3,bk_number4,bk_number5,
					bk_number6,bk_number7,bk_number8,bk_number9,bk_number10,
                    				bk_number11,bk_number12,bk_number13,bk_number14,bk_number15,
                   				bk_number16,bk_number17,bk_number18,bk_number19,bk_number20,
              				bk_number21,bk_number22,bk_number23,bk_number24,bk_number25,
           				            bk_number26,bk_number27,bk_number28,bk_number29,bk_number30,
                  				bk_number31,bk_number32,bk_number33,bk_number34,bk_number35,
                  				bk_number36,bk_number37,bk_number38,bk_number39,bk_number40,
                   				bk_number41,bk_number42,bk_number43,bk_number44,bk_number45,
					user_user_id,answer_answer_no)  
				VALUES(:bk_no,:bk_year,:bk_subject,
					:bk_number1,:bk_number2,:bk_number3,:bk_number4,:bk_number5,
					:bk_number6,:bk_number7,:bk_number8,:bk_number9,:bk_number10,
                    				:bk_number11,:bk_number12,:bk_number13,:bk_number14,:bk_number15,
                   				:bk_number16,:bk_number17,:bk_number18,:bk_number19,:bk_number20,
              				:bk_number21,:bk_number22,:bk_number23,:bk_number24,:bk_number25,
           				            :bk_number26,:bk_number27,:bk_number28,:bk_number29,:bk_number30,
                  				:bk_number31,:bk_number32,:bk_number33,:bk_number34,:bk_number35,
                  				:bk_number36,:bk_number37,:bk_number38,:bk_number39,:bk_number40,
                   				:bk_number41,:bk_number42,:bk_number43,:bk_number44,:bk_number45,
					:user_user_id,:answer_answer_no)');
                $stmt->bindParam(':bk_no', $bk_no);
                $stmt->bindParam(':bk_year', $bk_year);
	    $stmt->bindParam(':bk_subject', $bk_subject);
                $stmt->bindParam(':bk_number1', $bk_number1);
                $stmt->bindParam(':bk_number2', $bk_number2);
                $stmt->bindParam(':bk_number3', $bk_number3);
                $stmt->bindParam(':bk_number4', $bk_number4);
                $stmt->bindParam(':bk_number5', $bk_number5);
                $stmt->bindParam(':bk_number6', $bk_number6);
                $stmt->bindParam(':bk_number7', $bk_number7);
                $stmt->bindParam(':bk_number8', $bk_number8);
                $stmt->bindParam(':bk_number9', $bk_number9);
                $stmt->bindParam(':bk_number10', $bk_number10);
                $stmt->bindParam(':bk_number11', $bk_number11);
                $stmt->bindParam(':bk_number12', $bk_number12);
                $stmt->bindParam(':bk_number13', $bk_number13);
                $stmt->bindParam(':bk_number14', $bk_number14);
                $stmt->bindParam(':bk_number15', $bk_number15);
                $stmt->bindParam(':bk_number16', $bk_number16);
                $stmt->bindParam(':bk_number17', $bk_number17);
                $stmt->bindParam(':bk_number18', $bk_number18);
                $stmt->bindParam(':bk_number19', $bk_number19);
                $stmt->bindParam(':bk_number20', $bk_number20);
                $stmt->bindParam(':bk_number21', $bk_number21);
                $stmt->bindParam(':bk_number22', $bk_number22);
                $stmt->bindParam(':bk_number23', $bk_number23);
                $stmt->bindParam(':bk_number24', $bk_number24);
                $stmt->bindParam(':bk_number25', $bk_number25);
                $stmt->bindParam(':bk_number26', $bk_number26);
                $stmt->bindParam(':bk_number27', $bk_number27);
                $stmt->bindParam(':bk_number28', $bk_number28);
                $stmt->bindParam(':bk_number29', $bk_number29);
                $stmt->bindParam(':bk_number30', $bk_number30);
                $stmt->bindParam(':bk_number31', $bk_number31);
                $stmt->bindParam(':bk_number32', $bk_number32);
                $stmt->bindParam(':bk_number33', $bk_number33);
                $stmt->bindParam(':bk_number34', $bk_number34);
                $stmt->bindParam(':bk_number35', $bk_number35);
                $stmt->bindParam(':bk_number36', $bk_number36);
                $stmt->bindParam(':bk_number37', $bk_number37);
                $stmt->bindParam(':bk_number38', $bk_number38);
                $stmt->bindParam(':bk_number39', $bk_number39);
                $stmt->bindParam(':bk_number40', $bk_number40);
                $stmt->bindParam(':bk_number41', $bk_number41);
                $stmt->bindParam(':bk_number42', $bk_number42);
                $stmt->bindParam(':bk_number43', $bk_number43);
                $stmt->bindParam(':bk_number44', $bk_number44);
                $stmt->bindParam(':bk_number45', $bk_number45);
                $stmt->bindParam(':user_user_id', $user_user_id);
                $stmt->bindParam(':answer_answer_no', $answer_answer_no);



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
	            sibal: <input type = "text" name = "bk_no" />
                	sibal: <input type = "text" name = "bk_year" />
	            sibal: <input type = "text" name = "bk_subject" />
	            sibal: <input type = "text" name = "bk_number1" />
	            sibal: <input type = "text" name = "bk_number2" />
	            sibal: <input type = "text" name = "bk_number3" />
	            sibal: <input type = "text" name = "bk_number4" />
	            sibal: <input type = "text" name = "bk_number5" />
	            sibal: <input type = "text" name = "bk_number6" />
	            sibal: <input type = "text" name = "bk_number7" />
	            sibal: <input type = "text" name = "bk_number8" />
	            sibal: <input type = "text" name = "bk_number9" />
	            sibal: <input type = "text" name = "bk_number10" />
	            sibal: <input type = "text" name = "bk_number11" />
	            sibal: <input type = "text" name = "bk_number12" />
	            sibal: <input type = "text" name = "bk_number13" />
	            sibal: <input type = "text" name = "bk_number14" />
	            sibal: <input type = "text" name = "bk_number15" />
	            sibal: <input type = "text" name = "bk_number16" />
	            sibal: <input type = "text" name = "bk_number17" />
	            sibal: <input type = "text" name = "bk_number18" />
	            sibal: <input type = "text" name = "bk_number19" />
	            sibal: <input type = "text" name = "bk_number20" />
	            sibal: <input type = "text" name = "bk_number21" />
	            sibal: <input type = "text" name = "bk_number22" />
	            sibal: <input type = "text" name = "bk_number23" />
	            sibal: <input type = "text" name = "bk_number24" />
	            sibal: <input type = "text" name = "bk_number25" />
	            sibal: <input type = "text" name = "bk_number26" />
	            sibal: <input type = "text" name = "bk_number27" />
	            sibal: <input type = "text" name = "bk_number28" />
	            sibal: <input type = "text" name = "bk_number29" />
	            sibal: <input type = "text" name = "bk_number30" />
	            sibal: <input type = "text" name = "bk_number31" />
	            sibal: <input type = "text" name = "bk_number32" />
	            sibal: <input type = "text" name = "bk_number33" />
	            sibal: <input type = "text" name = "bk_number34" />
	            sibal: <input type = "text" name = "bk_number35" />
	            sibal: <input type = "text" name = "bk_number36" />
	            sibal: <input type = "text" name = "bk_number37" />
	            sibal: <input type = "text" name = "bk_number38" />
	            sibal: <input type = "text" name = "bk_number39" />
	            sibal: <input type = "text" name = "bk_number40" />
	            sibal: <input type = "text" name = "bk_number41" />
	            sibal: <input type = "text" name = "bk_number42" />
	            sibal: <input type = "text" name = "bk_number43" />
	            sibal: <input type = "text" name = "bk_number44" />
	            sibal: <input type = "text" name = "bk_number45" />
	            sibal: <input type = "text" name = "user_user_id" />
	            sibal: <input type = "text" name = "answer_answer_no" />

                <input type = "submit" name = "submit" />
            </form>
       
       </body>
    </html>

<?php 
    }
?>