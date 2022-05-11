<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbconuser.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");



    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

	$input_bookmark1=$_POST['input_bookmark1'];
	$input_bookmark2=$_POST['input_bookmark2'];
	$input_bookmark3=$_POST['input_bookmark3'];
	$input_bookmark4=$_POST['input_bookmark4'];
	$input_bookmark5=$_POST['input_bookmark5'];
	$input_bookmark6=$_POST['input_bookmark6'];
	$input_bookmark7=$_POST['input_bookmark7'];
	$input_bookmark8=$_POST['input_bookmark8'];
	$input_bookmark9=$_POST['input_bookmark9'];
	$input_bookmark10=$_POST['input_bookmark10'];
	$input_bookmark11=$_POST['input_bookmark11'];
	$input_bookmark12=$_POST['input_bookmark12'];
	$input_bookmark13=$_POST['input_bookmark13'];
	$input_bookmark14=$_POST['input_bookmark14'];
	$input_bookmark15=$_POST['input_bookmark15'];
	$input_bookmark16=$_POST['input_bookmark16'];
	$input_bookmark17=$_POST['input_bookmark17'];
	$input_bookmark18=$_POST['input_bookmark18'];
	$input_bookmark19=$_POST['input_bookmark19'];
	$input_bookmark20=$_POST['input_bookmark20'];
	$input_bookmark21=$_POST['input_bookmark21'];
	$input_bookmark22=$_POST['input_bookmark22'];
	$input_bookmark23=$_POST['input_bookmark23'];
	$input_bookmark24=$_POST['input_bookmark24'];
	$input_bookmark25=$_POST['input_bookmark25'];
	$input_bookmark26=$_POST['input_bookmark26'];
	$input_bookmark27=$_POST['input_bookmark27'];
	$input_bookmark28=$_POST['input_bookmark28'];
	$input_bookmark29=$_POST['input_bookmark29'];
	$input_bookmark30=$_POST['input_bookmark30'];
	$input_bookmark31=$_POST['input_bookmark31'];
	$input_bookmark32=$_POST['input_bookmark32'];
	$input_bookmark33=$_POST['input_bookmark33'];
	$input_bookmark34=$_POST['input_bookmark34'];
	$input_bookmark35=$_POST['input_bookmark35'];
	$input_bookmark36=$_POST['input_bookmark36'];
	$input_bookmark37=$_POST['input_bookmark37'];
	$input_bookmark38=$_POST['input_bookmark38'];
	$input_bookmark39=$_POST['input_bookmark39'];
	$input_bookmark40=$_POST['input_bookmark40'];
	$input_bookmark41=$_POST['input_bookmark41'];
	$input_bookmark42=$_POST['input_bookmark42'];
	$input_bookmark43=$_POST['input_bookmark43'];
	$input_bookmark44=$_POST['input_bookmark44'];
	$input_bookmark45=$_POST['input_bookmark45'];

	$input_number1=$_POST['input_number1'];
	$input_number2=$_POST['input_number2'];
	$input_number3=$_POST['input_number3'];
	$input_number4=$_POST['input_number4'];
	$input_number5=$_POST['input_number5'];
	$input_number6=$_POST['input_number6'];
	$input_number7=$_POST['input_number7'];
	$input_number8=$_POST['input_number8'];
	$input_number9=$_POST['input_number9'];
	$input_number10=$_POST['input_number10'];
	$input_number11=$_POST['input_number11'];
	$input_number12=$_POST['input_number12'];
	$input_number13=$_POST['input_number13'];
	$input_number14=$_POST['input_number14'];
	$input_number15=$_POST['input_number15'];
	$input_number16=$_POST['input_number16'];
	$input_number17=$_POST['input_number17'];
	$input_number18=$_POST['input_number18'];
	$input_number19=$_POST['input_number19'];
	$input_number20=$_POST['input_number20'];
	$input_number21=$_POST['input_number21'];
	$input_number22=$_POST['input_number22'];
	$input_number23=$_POST['input_number23'];
	$input_number24=$_POST['input_number24'];
	$input_number25=$_POST['input_number25'];
	$input_number26=$_POST['input_number26'];
	$input_number27=$_POST['input_number27'];
	$input_number28=$_POST['input_number28'];
	$input_number29=$_POST['input_number29'];
	$input_number30=$_POST['input_number30'];
	$input_number31=$_POST['input_number31'];
	$input_number32=$_POST['input_number32'];
	$input_number33=$_POST['input_number33'];
	$input_number34=$_POST['input_number34'];
	$input_number35=$_POST['input_number35'];
	$input_number36=$_POST['input_number36'];
	$input_number37=$_POST['input_number37'];
	$input_number38=$_POST['input_number38'];
	$input_number39=$_POST['input_number39'];
	$input_number40=$_POST['input_number40'];
	$input_number41=$_POST['input_number41'];
	$input_number42=$_POST['input_number42'];
	$input_number43=$_POST['input_number43'];
	$input_number44=$_POST['input_number44'];
	$input_number45=$_POST['input_number45'];
	
		if(!isset($errMSG)) // 모든 정보가 입력이 되었다면 
			{
				try{
					if ($input_bookmark1 ==  "true") {
						$input_bookmark1 = "on";
					}elseif($input_bookmark1 == "false") {
						$input_bookmark1 = "off";
					}

					if ($input_bookmark2 ==  "true") {
						$input_bookmark2 = "on";
					}elseif($input_bookmark2 == "false") {
						$input_bookmark2 = "off";
					}

					if ($input_bookmark3 ==  "true") {
						$input_bookmark3 = "on";
					}elseif($input_bookmark3 == "false"){
						$input_bookmark3 = "off";
					}

					if ($input_bookmark4 ==  "true") {
						$input_bookmark4 = "on";
					}elseif($input_bookmark4 == "false"){
						$input_bookmark4 = "off";
					}

					if ($input_bookmark5 == "true") {
						$input_bookmark5 = "on";
					}elseif($input_bookmark5 == "false"){
						$input_bookmark5 = "off";
					}

					if ($input_bookmark6 ==  "true") {
						$input_bookmark6 = "on";
					}elseif($input_bookmark6 == "false"){
						$input_bookmark6 = "off";
					}

					if ($input_bookmark7 ==  "true") {
						$input_bookmark7 = "on";
					}elseif($input_bookmark7 == "false"){
						$input_bookmark7 = "off";
					}

					if ($input_bookmark8 ==  "true") {
						$input_bookmark8 = "on";
					}elseif($input_bookmark8 == "false"){
						$input_bookmark8 = "off";
					}

					if ($input_bookmark9 ==  "true") {
						$input_bookmark9 = "on";
					}elseif($input_bookmark9 == "false"){
						$input_bookmark9 = "off";
					}

					if ($input_bookmark10 ==  "true") {
						$input_bookmark10 = "on";
					}elseif($input_bookmark10 == "false"){
						$input_bookmark10 = "off";
					}

					if ($input_bookmark11 ==  "true") {
						$input_bookmark11 = "on";
					}elseif($input_bookmark11 == "false") {
						$input_bookmark11 = "off";
					}

					if ($input_bookmark12 ==  "true") {
						$input_bookmark12 = "on";
					}elseif($input_bookmark12 == "false") {
						$input_bookmark12 = "off";
					}

					if ($input_bookmark13 ==  "true") {
						$input_bookmark13 = "on";
					}elseif($input_bookmark13 == "false"){
						$input_bookmark13 = "off";
					}

					if ($input_bookmark14 ==  "true") {
						$input_bookmark14 = "on";
					}elseif($input_bookmark14 == "false"){
						$input_bookmark14 = "off";
					}

					if ($input_bookmark15 == "true") {
						$input_bookmark15 = "on";
					}elseif($input_bookmark15 == "false"){
						$input_bookmark15 = "off";
					}

					if ($input_bookmark16 ==  "true") {
						$input_bookmark16 = "on";
					}elseif($input_bookmark16 == "false"){
						$input_bookmark16 = "off";
					}

					if ($input_bookmark17 ==  "true") {
						$input_bookmark17 = "on";
					}elseif($input_bookmark17 == "false"){
						$input_bookmark17 = "off";
					}

					if ($input_bookmark18 ==  "true") {
						$input_bookmark18 = "on";
					}elseif($input_bookmark18 == "false"){
						$input_bookmark18 = "off";
					}

					if ($input_bookmark19 ==  "true") {
						$input_bookmark19 = "on";
					}elseif($input_bookmark19 == "false"){
						$input_bookmark19 = "off";
					}

					if ($input_bookmark20 ==  "true") {
						$input_bookmark20 = "on";
					}elseif($input_bookmark20 == "false"){
						$input_bookmark20 = "off";
					}

					if ($input_bookmark21 ==  "true") {
						$input_bookmark21 = "on";
					}elseif($input_bookmark21 == "false") {
						$input_bookmark21 = "off";
					}

					if ($input_bookmark22 ==  "true") {
						$input_bookmark22 = "on";
					}elseif($input_bookmark22 == "false") {
						$input_bookmark22 = "off";
					}

					if ($input_bookmark23 ==  "true") {
						$input_bookmark23 = "on";
					}elseif($input_bookmark23 == "false"){
						$input_bookmark23 = "off";
					}

					if ($input_bookmark24 ==  "true") {
						$input_bookmark24 = "on";
					}elseif($input_bookmark24 == "false"){
						$input_bookmark24 = "off";
					}

					if ($input_bookmark25 == "true") {
						$input_bookmark25 = "on";
					}elseif($input_bookmark25 == "false"){
						$input_bookmark25 = "off";
					}

					if ($input_bookmark26 ==  "true") {
						$input_bookmark26 = "on";
					}elseif($input_bookmark26 == "false"){
						$input_bookmark26 = "off";
					}

					if ($input_bookmark27 ==  "true") {
						$input_bookmark27 = "on";
					}elseif($input_bookmark27 == "false"){
						$input_bookmark27 = "off";
					}

					if ($input_bookmark28 ==  "true") {
						$input_bookmark28 = "on";
					}elseif($input_bookmark28 == "false"){
						$input_bookmark28 = "off";
					}

					if ($input_bookmark29 ==  "true") {
						$input_bookmark29 = "on";
					}elseif($input_bookmark29 == "false"){
						$input_bookmark29 = "off";
					}

					if ($input_bookmark30 ==  "true") {
						$input_bookmark30 = "on";
					}elseif($input_bookmark30 == "false"){
						$input_bookmark30 = "off";
					}

					if ($input_bookmark31 ==  "true") {
						$input_bookmark31 = "on";
					}elseif($input_bookmark31 == "false") {
						$input_bookmark31 = "off";
					}

					if ($input_bookmark32 ==  "true") {
						$input_bookmark32 = "on";
					}elseif($input_bookmark32 == "false") {
						$input_bookmark32 = "off";
					}

					if ($input_bookmark33 ==  "true") {
						$input_bookmark33 = "on";
					}elseif($input_bookmark33 == "false"){
						$input_bookmark33 = "off";
					}

					if ($input_bookmark34 ==  "true") {
						$input_bookmark34 = "on";
					}elseif($input_bookmark34 == "false"){
						$input_bookmark34 = "off";
					}

					if ($input_bookmark35 == "true") {
						$input_bookmark35 = "on";
					}elseif($input_bookmark35 == "false"){
						$input_bookmark35 = "off";
					}

					if ($input_bookmark36 ==  "true") {
						$input_bookmark36 = "on";
					}elseif($input_bookmark36 == "false"){
						$input_bookmark36 = "off";
					}

					if ($input_bookmark37 ==  "true") {
						$input_bookmark37 = "on";
					}elseif($input_bookmark37 == "false"){
						$input_bookmark37 = "off";
					}

					if ($input_bookmark38 ==  "true") {
						$input_bookmark38 = "on";
					}elseif($input_bookmark38 == "false"){
						$input_bookmark38 = "off";
					}

					if ($input_bookmark39 ==  "true") {
						$input_bookmark39 = "on";
					}elseif($input_bookmark39 == "false"){
						$input_bookmark39 = "off";
					}

					if ($input_bookmark40 ==  "true") {
						$input_bookmark40 = "on";
					}elseif($input_bookmark40 == "false"){
						$input_bookmark40 = "off";
					}

					if ($input_bookmark41 ==  "true") {
						$input_bookmark41 = "on";
					}elseif($input_bookmark41 == "false") {
						$input_bookmark41 = "off";
					}

					if ($input_bookmark42 ==  "true") {
						$input_bookmark42 = "on";
					}elseif($input_bookmark42 == "false") {
						$input_bookmark42 = "off";
					}

					if ($input_bookmark43 ==  "true") {
						$input_bookmark43 = "on";
					}elseif($input_bookmark43 == "false"){
						$input_bookmark43 = "off";
					}

					if ($input_bookmark44 ==  "true") {
						$input_bookmark44 = "on";
					}elseif($input_bookmark44 == "false"){
						$input_bookmark44 = "off";
					}

					if ($input_bookmark45 == "true") {
						$input_bookmark45 = "on";
					}elseif($input_bookmark45 == "false"){
						$input_bookmark45 = "off";
					}


					
					if($input_bookmark1 == "on") {
						$con->exec("UPDATE input SET input_bookmark1 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark1 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark1 == "off"){
						$con->exec("UPDATE input SET input_bookmark1 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark1 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark2 == "on") {
						$con->exec("UPDATE input SET input_bookmark2 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark2 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark2 == "off"){
						$con->exec("UPDATE input SET input_bookmark2 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark2 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark3 == "on") {
						$con->exec("UPDATE input SET input_bookmark3 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark3 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark3 == "off"){
						$con->exec("UPDATE input SET input_bookmark3 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark3 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark4 == "on") {
						$con->exec("UPDATE input SET input_bookmark4 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark4 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark4 == "off"){
						$con->exec("UPDATE input SET input_bookmark4 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark4 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark5 == "on") {
						$con->exec("UPDATE input SET input_bookmark5 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark5 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark5 == "off"){
						$con->exec("UPDATE input SET input_bookmark5 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark5 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark6 == "on") {
						$con->exec("UPDATE input SET input_bookmark6 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark6 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark6 == "off"){
						$con->exec("UPDATE input SET input_bookmark6 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark6 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark7 == "on") {
						$con->exec("UPDATE input SET input_bookmark7 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark7 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark7 == "off"){
						$con->exec("UPDATE input SET input_bookmark7 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark7 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark8 == "on") {
						$con->exec("UPDATE input SET input_bookmark8 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark8 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark8 == "off"){
						$con->exec("UPDATE input SET input_bookmark8 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark8 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark9 == "on") {
						$con->exec("UPDATE input SET input_bookmark9 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark9 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark9 == "off"){
						$con->exec("UPDATE input SET input_bookmark9 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark9 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark10 == "on") {
						$con->exec("UPDATE input SET input_bookmark10 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark10 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark10 == "off"){
						$con->exec("UPDATE input SET input_bookmark10 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark10 = 0 WHERE res_no = '18k3'");
					}
										
					if($input_bookmark11 == "on") {
						$con->exec("UPDATE input SET input_bookmark11 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark11 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark11 == "off"){
						$con->exec("UPDATE input SET input_bookmark11 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark11 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark12 == "on") {
						$con->exec("UPDATE input SET input_bookmark12 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark12 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark12 == "off"){
						$con->exec("UPDATE input SET input_bookmark12 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark12 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark13 == "on") {
						$con->exec("UPDATE input SET input_bookmark13 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark13 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark13 == "off"){
						$con->exec("UPDATE input SET input_bookmark13 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark13 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark14 == "on") {
						$con->exec("UPDATE input SET input_bookmark14 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark14 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark14 == "off"){
						$con->exec("UPDATE input SET input_bookmark14 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark14 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark15 == "on") {
						$con->exec("UPDATE input SET input_bookmark15 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark15 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark15 == "off"){
						$con->exec("UPDATE input SET input_bookmark15 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark15 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark16 == "on") {
						$con->exec("UPDATE input SET input_bookmark16 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark16 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark16 == "off"){
						$con->exec("UPDATE input SET input_bookmark16 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark16 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark17 == "on") {
						$con->exec("UPDATE input SET input_bookmark17 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark17 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark17 == "off"){
						$con->exec("UPDATE input SET input_bookmark17 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark17 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark18 == "on") {
						$con->exec("UPDATE input SET input_bookmark18 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark18 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark18 == "off"){
						$con->exec("UPDATE input SET input_bookmark18 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark18 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark19 == "on") {
						$con->exec("UPDATE input SET input_bookmark19 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark19 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark19 == "off"){
						$con->exec("UPDATE input SET input_bookmark19 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark19 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark20 == "on") {
						$con->exec("UPDATE input SET input_bookmark20 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark20 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark20 == "off"){
						$con->exec("UPDATE input SET input_bookmark20 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark20 = 0 WHERE res_no = '18k3'");
					}
										
					if($input_bookmark21 == "on") {
						$con->exec("UPDATE input SET input_bookmark21 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark21 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark21 == "off"){
						$con->exec("UPDATE input SET input_bookmark21 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark21 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark22 == "on") {
						$con->exec("UPDATE input SET input_bookmark22 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark22 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark22 == "off"){
						$con->exec("UPDATE input SET input_bookmark22 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark22 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark23 == "on") {
						$con->exec("UPDATE input SET input_bookmark23 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark23 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark23 == "off"){
						$con->exec("UPDATE input SET input_bookmark23 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark23 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark24 == "on") {
						$con->exec("UPDATE input SET input_bookmark24 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark24 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark24 == "off"){
						$con->exec("UPDATE input SET input_bookmark24 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark24 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark25 == "on") {
						$con->exec("UPDATE input SET input_bookmark25 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark25 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark25 == "off"){
						$con->exec("UPDATE input SET input_bookmark25 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark25 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark26 == "on") {
						$con->exec("UPDATE input SET input_bookmark26 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark126 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark26 == "off"){
						$con->exec("UPDATE input SET input_bookmark26 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark26 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark27 == "on") {
						$con->exec("UPDATE input SET input_bookmark27 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark27 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark27 == "off"){
						$con->exec("UPDATE input SET input_bookmark27 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark27 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark28 == "on") {
						$con->exec("UPDATE input SET input_bookmark28 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark28 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark28 == "off"){
						$con->exec("UPDATE input SET input_bookmark28 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark28 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark29 == "on") {
						$con->exec("UPDATE input SET input_bookmark29 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark29 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark29 == "off"){
						$con->exec("UPDATE input SET input_bookmark29 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark29 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark30 == "on") {
						$con->exec("UPDATE input SET input_bookmark30 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark30 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark30 == "off"){
						$con->exec("UPDATE input SET input_bookmark30 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark30 = 0 WHERE res_no = '18k3'");
					}
										
					if($input_bookmark31 == "on") {
						$con->exec("UPDATE input SET input_bookmark31 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark31 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark31 == "off"){
						$con->exec("UPDATE input SET input_bookmark31 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark31 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark32 == "on") {
						$con->exec("UPDATE input SET input_bookmark32 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark32 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark32 == "off"){
						$con->exec("UPDATE input SET input_bookmark32 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark32 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark33 == "on") {
						$con->exec("UPDATE input SET input_bookmark33 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark33 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark33 == "off"){
						$con->exec("UPDATE input SET input_bookmark33 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark33 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark34 == "on") {
						$con->exec("UPDATE input SET input_bookmark34 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark34 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark34 == "off"){
						$con->exec("UPDATE input SET input_bookmark34 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark34 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark35 == "on") {
						$con->exec("UPDATE input SET input_bookmark35 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark35 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark35 == "off"){
						$con->exec("UPDATE input SET input_bookmark35 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark35 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark36 == "on") {
						$con->exec("UPDATE input SET input_bookmark36 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark36 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark36 == "off"){
						$con->exec("UPDATE input SET input_bookmark36 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark36 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark37 == "on") {
						$con->exec("UPDATE input SET input_bookmark37 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark37 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark37 == "off"){
						$con->exec("UPDATE input SET input_bookmark37 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark37 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark38 == "on") {
						$con->exec("UPDATE input SET input_bookmark38 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark38 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark38 == "off"){
						$con->exec("UPDATE input SET input_bookmark38 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark38 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark39 == "on") {
						$con->exec("UPDATE input SET input_bookmark39 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark39 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark39 == "off"){
						$con->exec("UPDATE input SET input_bookmark39 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark39 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark40 == "on") {
						$con->exec("UPDATE input SET input_bookmark40 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark40 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark40 == "off"){
						$con->exec("UPDATE input SET input_bookmark40 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark40 = 0 WHERE res_no = '18k3'");
					}
										
					if($input_bookmark41 == "on") {
						$con->exec("UPDATE input SET input_bookmark41 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark41 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark41 == "off"){
						$con->exec("UPDATE input SET input_bookmark41 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark41 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark42 == "on") {
						$con->exec("UPDATE input SET input_bookmark42 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark42 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark42 == "off"){
						$con->exec("UPDATE input SET input_bookmark42 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark42 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark43 == "on") {
						$con->exec("UPDATE input SET input_bookmark43 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark43 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark43 == "off"){
						$con->exec("UPDATE input SET input_bookmark43 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark43 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark44 == "on") {
						$con->exec("UPDATE input SET input_bookmark44 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark44 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark44 == "off"){
						$con->exec("UPDATE input SET input_bookmark44 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark44 = 0 WHERE res_no = '18k3'");
					}
					
					if($input_bookmark45 == "on") {
						$con->exec("UPDATE input SET input_bookmark45 = 1 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark45 = 1 WHERE res_no = '18k3'");
					}elseif($input_bookmark45 == "off"){
						$con->exec("UPDATE input SET input_bookmark45 = 0 WHERE input_no = 1");
						$con->exec("UPDATE result SET res_boomark45 = 0 WHERE res_no = '18k3'");
					}

					switch($input_number1) {
						case "1" : $con ->exec("UPDATE input SET input_number1 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number1 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number1 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number1 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number1 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number1 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number2) {
						case "1" : $con ->exec("UPDATE input SET input_number2 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number2 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number2 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number2 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number2 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number2 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number3) {
						case "1" : $con ->exec("UPDATE input SET input_number3 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number3 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number3 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number3 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number3 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number3 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number4) {
						case "1" : $con ->exec("UPDATE input SET input_number4 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number4 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number4 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number4 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number4 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number4 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number5) {
						case "1" : $con ->exec("UPDATE input SET input_number5 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number5 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number5 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number5 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number5 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number5 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number6) {
						case "1" : $con ->exec("UPDATE input SET input_number6 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number6 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number6 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number6 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number6 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number6 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number7) {
						case "1" : $con ->exec("UPDATE input SET input_number7 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number7 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number7 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number7 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number7 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number7 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number8) {
						case "1" : $con ->exec("UPDATE input SET input_number8 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number8 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number8 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number8 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number8 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number8 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number9) {
						case "1" : $con ->exec("UPDATE input SET input_number9 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number9 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number9 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number9 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number9 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number9 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number10) {
						case "1" : $con ->exec("UPDATE input SET input_number10 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number10 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number10 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number10 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number10 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number10 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number11) {
						case "1" : $con ->exec("UPDATE input SET input_number11 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number11 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number11 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number11 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number11 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number11 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number12) {
						case "1" : $con ->exec("UPDATE input SET input_number12 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number12 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number12 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number12 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number12 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number12 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number13) {
						case "1" : $con ->exec("UPDATE input SET input_number13 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number13 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number13 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number13 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number13 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number13 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number14) {
						case "1" : $con ->exec("UPDATE input SET input_number14 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number14 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number14 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number14 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number14 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number14 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number15) {
						case "1" : $con ->exec("UPDATE input SET input_number15 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number15 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number15 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number15 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number15 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number15 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number16) {
						case "1" : $con ->exec("UPDATE input SET input_number16 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number16 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number16 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number16 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number16 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number16 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number17) {
						case "1" : $con ->exec("UPDATE input SET input_number17 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number17 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number17 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number17 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number17 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number17 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number18) {
						case "1" : $con ->exec("UPDATE input SET input_number18 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number18 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number18 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number18 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number18 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number18 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number19) {
						case "1" : $con ->exec("UPDATE input SET input_number19 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number19 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number19 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number19 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number19 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number19 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number20) {
						case "1" : $con ->exec("UPDATE input SET input_number20 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number20 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number20 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number20 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number20 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number20 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number21) {
						case "1" : $con ->exec("UPDATE input SET input_number21 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number21 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number21 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number21 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number21 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number21 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number22) {
						case "1" : $con ->exec("UPDATE input SET input_number22 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number22 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number22 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number22 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number22 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number22 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number23) {
						case "1" : $con ->exec("UPDATE input SET input_number23 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number23 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number23 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number23 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number23 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number23 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number24) {
						case "1" : $con ->exec("UPDATE input SET input_number24 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number24 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number24 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number24 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number24 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number24 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number25) {
						case "1" : $con ->exec("UPDATE input SET input_number25 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number25 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number25 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number25 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number25 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number25 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number26) {
						case "1" : $con ->exec("UPDATE input SET input_number26 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number26 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number26 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number26 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number26 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number26 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number27) {
						case "1" : $con ->exec("UPDATE input SET input_number27 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number27 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number27 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number27 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number27 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number27 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number28) {
						case "1" : $con ->exec("UPDATE input SET input_number28 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number28 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number28 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number28 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number28 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number28 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number29) {
						case "1" : $con ->exec("UPDATE input SET input_number29 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number29 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number29 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number29 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number29 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number29 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number30) {
						case "1" : $con ->exec("UPDATE input SET input_number30 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number30 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number30 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number30 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number30 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number30 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number31) {
						case "1" : $con ->exec("UPDATE input SET input_number31 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number31 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number31 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number31 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number31 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number31 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number32) {
						case "1" : $con ->exec("UPDATE input SET input_number32 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number32 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number32 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number32 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number32 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number32 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number33) {
						case "1" : $con ->exec("UPDATE input SET input_number33 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number33 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number33 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number33 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number33 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number33 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number34) {
						case "1" : $con ->exec("UPDATE input SET input_number34 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number34 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number34 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number34 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number34 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number34 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number35) {
						case "1" : $con ->exec("UPDATE input SET input_number35 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number35 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number35 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number35 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number35 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number35 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number36) {
						case "1" : $con ->exec("UPDATE input SET input_number36 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number36 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number36 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number36 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number36 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number36 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number37) {
						case "1" : $con ->exec("UPDATE input SET input_number37 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number37 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number37 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number37 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number37 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number37 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number38) {
						case "1" : $con ->exec("UPDATE input SET input_number38 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number38 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number38 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number38 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number38 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number38 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number39) {
						case "1" : $con ->exec("UPDATE input SET input_number39 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number39 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number39 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number39 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number39 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number39 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number40) {
						case "1" : $con ->exec("UPDATE input SET input_number40 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number40 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number40 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number40 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number40 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number40 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number41) {
						case "1" : $con ->exec("UPDATE input SET input_number41 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number41 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number41 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number41 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number41 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number41 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number42) {
						case "1" : $con ->exec("UPDATE input SET input_number42 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number42 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number42 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number42 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number42 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number42 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number43) {
						case "1" : $con ->exec("UPDATE input SET input_number43 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number43 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number43 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number43 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number43 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number43 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number44) {
						case "1" : $con ->exec("UPDATE input SET input_number44 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number44 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number4	4 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number44 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number44 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number44 = NULL WHERE input_no = 1"); break;
					}
					switch($input_number45) {
						case "1" : $con ->exec("UPDATE input SET input_number45 = 1 WHERE input_no = 1"); break;
						case "2" : $con ->exec("UPDATE input SET input_number45 = 2 WHERE input_no = 1"); break;
						case "3" : $con ->exec("UPDATE input SET input_number45 = 3 WHERE input_no = 1"); break;
						case "4" : $con ->exec("UPDATE input SET input_number45 = 4 WHERE input_no = 1"); break;
						case "5" : $con ->exec("UPDATE input SET input_number45 = 5 WHERE input_no = 1"); break;
						default : $con ->exec("UPDATE input SET input_number45 = NULL WHERE input_no = 1"); break;
					}


						$stmt->bindParam(':input_bookmark1', $input_bookmark1);
						$stmt->bindParam(':input_bookmark2', $input_bookmark2);
						$stmt->bindParam(':input_bookmark3', $input_bookmark3);
						$stmt->bindParam(':input_bookmark4', $input_bookmark4);
						$stmt->bindParam(':input_bookmark5', $input_bookmark5);
						$stmt->bindParam(':input_bookmark6', $input_bookmark6);
						$stmt->bindParam(':input_bookmark7', $input_bookmark7);
						$stmt->bindParam(':input_bookmark8', $input_bookmark8);
						$stmt->bindParam(':input_bookmark9', $input_bookmark9);
						$stmt->bindParam(':input_bookmark10', $input_bookmark10);
						$stmt->bindParam(':input_bookmark11', $input_bookmark11);
						$stmt->bindParam(':input_bookmark12', $input_bookmark12);
						$stmt->bindParam(':input_bookmark13', $input_bookmark13);
						$stmt->bindParam(':input_bookmark14', $input_bookmark14);
						$stmt->bindParam(':input_bookmark15', $input_bookmark15);
						$stmt->bindParam(':input_bookmark16', $input_bookmark16);
						$stmt->bindParam(':input_bookmark17', $input_bookmark17);
						$stmt->bindParam(':input_bookmark18', $input_bookmark18);
						$stmt->bindParam(':input_bookmark19', $input_bookmark19);
						$stmt->bindParam(':input_bookmark20', $input_bookmark20);
						$stmt->bindParam(':input_bookmark21', $input_bookmark21);
						$stmt->bindParam(':input_bookmark22', $input_bookmark22);
						$stmt->bindParam(':input_bookmark23', $input_bookmark23);
						$stmt->bindParam(':input_bookmark24', $input_bookmark24);
						$stmt->bindParam(':input_bookmark25', $input_bookmark25);
						$stmt->bindParam(':input_bookmark26', $input_bookmark26);
						$stmt->bindParam(':input_bookmark27', $input_bookmark27);
						$stmt->bindParam(':input_bookmark28', $input_bookmark28);
						$stmt->bindParam(':input_bookmark29', $input_bookmark29);
						$stmt->bindParam(':input_bookmark30', $input_bookmark30);
						$stmt->bindParam(':input_bookmark31', $input_bookmark31);
						$stmt->bindParam(':input_bookmark32', $input_bookmark32);
						$stmt->bindParam(':input_bookmark33', $input_bookmark33);
						$stmt->bindParam(':input_bookmark34', $input_bookmark34);
						$stmt->bindParam(':input_bookmark35', $input_bookmark35);
						$stmt->bindParam(':input_bookmark36', $input_bookmark36);
						$stmt->bindParam(':input_bookmark37', $input_bookmark37);
						$stmt->bindParam(':input_bookmark38', $input_bookmark38);
						$stmt->bindParam(':input_bookmark39', $input_bookmark39);
						$stmt->bindParam(':input_bookmark40', $input_bookmark40);
						$stmt->bindParam(':input_bookmark41', $input_bookmark41);
						$stmt->bindParam(':input_bookmark42', $input_bookmark42);
						$stmt->bindParam(':input_bookmark43', $input_bookmark43);
						$stmt->bindParam(':input_bookmark44', $input_bookmark44);
						$stmt->bindParam(':input_bookmark45', $input_bookmark45);

						$stmt ->bindParam(':input_number1', $input_number1);
						$stmt ->bindParam(':input_number2', $input_number2);
						$stmt ->bindParam(':input_number3', $input_number3);
						$stmt ->bindParam(':input_number4', $input_number4);
						$stmt ->bindParam(':input_number5', $input_number5);
						$stmt ->bindParam(':input_number6', $input_number6);
						$stmt ->bindParam(':input_number7', $input_number7);
						$stmt ->bindParam(':input_number8', $input_number8);
						$stmt ->bindParam(':input_number9', $input_number9);
						$stmt ->bindParam(':input_number10', $input_number10);
						$stmt ->bindParam(':input_number11', $input_number11);
						$stmt ->bindParam(':input_number12', $input_number12);
						$stmt ->bindParam(':input_number13', $input_number13);
						$stmt ->bindParam(':input_number14', $input_number14);
						$stmt ->bindParam(':input_number15', $input_number15);
						$stmt ->bindParam(':input_number16', $input_number16);
						$stmt ->bindParam(':input_number17', $input_number17);
						$stmt ->bindParam(':input_number18', $input_number18);
						$stmt ->bindParam(':input_number19', $input_number19);
						$stmt ->bindParam(':input_number20', $input_number20);
						$stmt ->bindParam(':input_number21', $input_number21);
						$stmt ->bindParam(':input_number22', $input_number22);
						$stmt ->bindParam(':input_number23', $input_number23);
						$stmt ->bindParam(':input_number24', $input_number24);
						$stmt ->bindParam(':input_number25', $input_number25);
						$stmt ->bindParam(':input_number26', $input_number26);
						$stmt ->bindParam(':input_number27', $input_number27);
						$stmt ->bindParam(':input_number28', $input_number28);
						$stmt ->bindParam(':input_number29', $input_number29);
						$stmt ->bindParam(':input_number30', $input_number30);
						$stmt ->bindParam(':input_number31', $input_number31);
						$stmt ->bindParam(':input_number32', $input_number32);
						$stmt ->bindParam(':input_number33', $input_number33);
						$stmt ->bindParam(':input_number34', $input_number34);
						$stmt ->bindParam(':input_number35', $input_number35);
						$stmt ->bindParam(':input_number36', $input_number36);
						$stmt ->bindParam(':input_number37', $input_number37);
						$stmt ->bindParam(':input_number38', $input_number38);
						$stmt ->bindParam(':input_number39', $input_number39);
						$stmt ->bindParam(':input_number40', $input_number40);
						$stmt ->bindParam(':input_number41', $input_number41);
						$stmt ->bindParam(':input_number42', $input_number42);
						$stmt ->bindParam(':input_number43', $input_number43);
						$stmt ->bindParam(':input_number44', $input_number44);
						$stmt ->bindParam(':input_number45', $input_number45);

                if($stmt->execute())
                {
                    $successMSG = "변경 완료.";
                }
                else
                {
                    $errMSG = "변경 에러";
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
                <input type = "checkbox" name = "input_bookmark1" id="input_bookmark1" />문제1
                <input type = "checkbox" name = "input_bookmark2" id="input_bookmark2" />문제2
                <input type = "checkbox" name = "input_bookmark3" id="input_bookmark3" />문제3
                <input type = "checkbox" name = "input_bookmark4" id="input_bookmark4" />문제4
                <input type = "checkbox" name = "input_bookmark5" id="input_bookmark5" />문제5<br>
                <input type = "checkbox" name = "input_bookmark6" id="input_bookmark6" />문제6
                <input type = "checkbox" name = "input_bookmark7" id="input_bookmark7" />문제7
                <input type = "checkbox" name = "input_bookmark8" id="input_bookmark8" />문제8
                <input type = "checkbox" name = "input_bookmark9" id="input_bookmark9" />문제9
                <input type = "checkbox" name = "input_bookmark10" id="input_bookmark10" />문제10<br>
				<input type = "checkbox" name = "input_bookmark11" id="input_bookmark11" />문제11
                <input type = "checkbox" name = "input_bookmark12" id="input_bookmark12" />문제12
                <input type = "checkbox" name = "input_bookmark13" id="input_bookmark13" />문제13
                <input type = "checkbox" name = "input_bookmark14" id="input_bookmark14" />문제14
                <input type = "checkbox" name = "input_bookmark15" id="input_bookmark15" />문제15<br>
                <input type = "checkbox" name = "input_bookmark16" id="input_bookmark16" />문제16
                <input type = "checkbox" name = "input_bookmark17" id="input_bookmark17" />문제17
                <input type = "checkbox" name = "input_bookmark18" id="input_bookmark18" />문제18
                <input type = "checkbox" name = "input_bookmark19" id="input_bookmark19" />문제19
                <input type = "checkbox" name = "input_bookmark20" id="input_bookmark20" />문제20<br>
				<input type = "checkbox" name = "input_bookmark21" id="input_bookmark21" />문제21
                <input type = "checkbox" name = "input_bookmark22" id="input_bookmark22" v/>문제22
                <input type = "checkbox" name = "input_bookmark23" id="input_bookmark23" />문제23
                <input type = "checkbox" name = "input_bookmark24" id="input_bookmark24" />문제24
                <input type = "checkbox" name = "input_bookmark25" id="input_bookmark25" />문제25<br>
                <input type = "checkbox" name = "input_bookmark26" id="input_bookmark26" />문제26
                <input type = "checkbox" name = "input_bookmark27" id="input_bookmark27" />문제27
                <input type = "checkbox" name = "input_bookmark28" id="input_bookmark28" />문제28
                <input type = "checkbox" name = "input_bookmark29" id="input_bookmark29" />문제29
                <input type = "checkbox" name = "input_bookmark30" id="input_bookmark30" />문제30<br>
				<input type = "checkbox" name = "input_bookmark31" id="input_bookmark31" />문제31
                <input type = "checkbox" name = "input_bookmark32" id="input_bookmark32" />문제32
                <input type = "checkbox" name = "input_bookmark33" id="input_bookmark33" />문제33
                <input type = "checkbox" name = "input_bookmark34" id="input_bookmark34" />문제34
                <input type = "checkbox" name = "input_bookmark35" id="input_bookmark35" />문제35<br>
                <input type = "checkbox" name = "input_bookmark36" id="input_bookmark36" />문제36
                <input type = "checkbox" name = "input_bookmark37" id="input_bookmark37" />문제37
                <input type = "checkbox" name = "input_bookmark38" id="input_bookmark38" />문제38
                <input type = "checkbox" name = "input_bookmark39" id="input_bookmark39" />문제39
                <input type = "checkbox" name = "input_bookmark40" id="input_bookmark40" />문제40<br>
				<input type = "checkbox" name = "input_bookmark41" id="input_bookmark41" />문제41
                <input type = "checkbox" name = "input_bookmark42" id="input_bookmark42" />문제42
                <input type = "checkbox" name = "input_bookmark43" id="input_bookmark43" />문제43
                <input type = "checkbox" name = "input_bookmark44" id="input_bookmark44" />문제44
                <input type = "checkbox" name = "input_bookmark45" id="input_bookmark45" />문제45<br>
                <input type = "submit" name = "submit" value="확인" />

            </form>
       
       </body>
    </html>

<?php 
    }
?>





