
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Carpool</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="carpool1.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="css/bootstrapex3.css" rel="stylesheet">
  
  <style>
       @import url(http://fonts.googleapis.com/css?family=Roboto);


.loginmodal-container {
  padding: 30px;
  max-width: 350px;
  width: 100% !important;
  background-color: #F7F7F7 ;
  margin: 0 auto;
  border-radius: 2px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  overflow: hidden;
  font-family: roboto;
}

.loginmodal-container h1 {
  text-align: center;
  font-size: 1.8em;
  font-family: roboto;
}

.loginmodal-container input[type=submit] {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;
}

.loginmodal-container input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 100%;
  margin-bottom: 10px;
  -webkit-appearance: none;
  background: #fff;
  border: 1px solid #d9d9d9 ;
  border-top: 1px solid #c0c0c0 ;
  /* border-radius: 2px; */
  padding: 0 8px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
}

.loginmodal-container input[type=text]:hover, input[type=password]:hover {
  border: 1px solid #b9b9b9 ;
  border-top: 1px solid #a0a0a0 ;
  -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
}

.loginmodal {
  text-align: center;
  font-size: 14px;
  font-family: 'Arial', sans-serif;
  font-weight: 700;
  height: 36px;
  padding: 0 8px;
}

.loginmodal-submit {

 border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1);
  background-color: #4d90fe ;
  padding: 17px 0px;
  font-family: roboto;
  font-size: 14px;
  
}

.loginmodal-submit:hover {

 border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #357ae8 ;

}

.loginmodal-container a {
  text-decoration: none;
  color: #666;
  font-weight: 400;
  text-align: center;
  display: inline-block;
  opacity: 0.6;
  transition: opacity ease 0.5s;
}
.fade{
	opacity:0.7;
}
  
  
  </style>
  
  
</head>


<body class="color container-fluid">
	<div style="background-color: black">
		<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
 <a class="navbar-brand" href="index.html"><img src="images/logo.png"></a>

    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

      <ul class="nav navbar-nav navbar-right" id="list">
        <li><a href="#about">HOME</a></li>
        <li><a href="#pricing">ABOUT US</a></li>
        <li><a href="#services">CONTACT US</a></li>
	<!--	<li class="dropdown" id="menuLogin"><a href="#" data-toggle="dropdown" id="navLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                            <div class="dropdown-menu">
                                <form method="post" action="index.html">
                                Returning User
                                    <input name="username" id="username" type="text" placeholder="Username"> <br><br>
                                    <input name="password" id="password" type="password" placeholder="Password"><br><br>
                                    <input type="submit" name="login_btn" value="Login">
                                    <br>
								</form>
								<form method="post" action="signup.php">
                                    <hr>
                                    New User
                                    <br>
                                    <input type="submit" name="signup_btn" value="Signup">
                                </form>
                            </div>
                        </li>  -->
		<li><a data-toggle="modal" data-target="#login-modal" style="cursor:pointer">LOGIN</a></li>

      </ul>
    </div>
  </div>
</nav>
</div>


<!-- login button modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Login to Your Account</h1><br>
                 <form method="post" action="success.php">
                                <h3>Returning User</h3><br>
                                    <input name="username" id="username" type="text" placeholder="Username"> <br>
                                    <input name="password" id="password" type="password" placeholder="Password"><br>
                                    <input type="submit" name="Submit" class="login loginmodal-submit" value="Submit">
                                    
								</form>
								<form method="post" action="signup.php">
                                   <h3> New User</h3>
                                    <br>
                                    <input type="submit" name="Submit" class="login loginmodal-submit" value="Signup">
                                </form>
                    
                 
                </div>
            </div>
          </div>


<div class="well">
	<h1>Sign up</h1>


<form method="post" action="success2.php">
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username" class="textInput"></td>
		</tr>
		<br>
		<br>
		<br>
		<br>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" class="textInput"></td>
		</tr>
		<br>
		<br>
		<br>
		<br>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" class="textInput"></td>
		</tr>
		<br>
		<br>
		<br>
		<br>
		<tr>
			<td>Confirm Password:</td>
			<td><input type="password" name="password2" class="textInput"></td>
		</tr>
		<br>
		<br>
		<br>
		<br>
		<tr>
			<td></td>
			<td><input type="submit" name="signup_btn" value="Signup"></td>
		</tr>
		<br>
	</table>
</form>
</div>





</body>
</html>
