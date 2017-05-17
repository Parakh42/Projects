<?php
	session_start();
	
	// connect to the database
	$db = mysqli_connect("localhost", "root", "", "login");
	
	
			
			$username = mysqli_real_escape_string($db, $_POST['username']);
			$email = mysqli_real_escape_string($db, $_POST['email']);
			$password = mysqli_real_escape_string($db, $_POST['password']);
			$password2 = mysqli_real_escape_string($db, $_POST['password2']);

			if($password == $password2){
				//create user	
				$password = md5 ($password);  // hash password before storing for security purpose
				$sql = "INSERT INTO users (username, email, password) VALUES('$username','$email','$password')";
				mysqli_query($db, $sql);
				$_SESSION['message'] = "You are successfully logged in";
				header("location: index.html");  //Redirect to home page
			}	
			else{
				header("location: error.html");
				//$message = "username/password incorrect";
				//echo "<script type='text/javascript'>alert('$message');</script>";
			}	
				

?>