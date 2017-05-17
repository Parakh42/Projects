<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body{
	background-image: url("/images/images1.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	color: white;
}
.form-control{
	width: 300px;
}
.well{
	opacity: 0.7;
}
</style>

<title>Let's Carpool</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">Let's Carpool</a>
    	</div>
    	<ul class="nav navbar-nav navbar-right">
      		<li><a href="user/register.htm">New User</a></li>
      		<li><a href="user/registerCustomer.htm">New Customer</a></li>
      		<li><a href="#">Login</a></li>
    	</ul>
  </div>
</nav>
<!--  	<a href="user/register.htm">Register as a User</a><br/>
	<a href="user/registerCustomer.htm">Register as a Customer</a><br/>

	<h2>Login Here</h2>
	<form action="user/login" method="post">
	
		<table>
		<tr>
		    <td>User Name:</td>
		    <td><input name="username" size="30"  /></td>
		</tr>
		
		<tr>
		    <td>Password:</td>
		    <td><input type="password" name="password" size="30" /></td>
		</tr>
		
		<tr>
		    <td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
				
		</table>
	</form>-->
	<div class="container">
	<center>
	<h2>Login Here</h2>
	<form action="user/login" method="post">
	
		<div class="form-group">
      	<label for="username">Username:</label>
      	<input type="text" class="form-control" name="username" placeholder="Enter username">
      	</div>
      	<div class="form-group">
      		<label for="pwd">Password:</label>
      		<input type="password" class="form-control" name="password" placeholder="Enter password">
    	</div>
    	<div class="checkbox">
     		 <label><input type="checkbox"> Remember me</label>
    	</div>
    	<button type="submit" class="btn btn-success" value="Login">Login</button>
    	</form>
	</center>
	</div>



<br>
<br>
<br>
<br>
<div class="well">
<footer>
<center>
<nav>
<a href="#"><font color="black">Home</font></a> &nbsp;&nbsp;
<a href="#"><font color="black">About Us</font></a> &nbsp;&nbsp;
<a href="#"><font color="black">User Register</font></a> &nbsp;&nbsp;
<a href="#"><font color="black">Customer Register</font></a> &nbsp;&nbsp;
<a href="#"><font color="black">Contact Us</font></a> &nbsp;&nbsp;
<br>
<br>
<a href="mailto:mahajan.pa@husky.neu.edu"><font color="black">mahajan.pa@husky.neu.edu</font></a>
<br>
<br>
<font color="black">COPYRIGHT &copy 2017-18 ALL RIGHT RESERVED Parakh Mahajan</font>
<br>
<br>
<a href="#"><font color="black">Terms & Conditions</font></a>
</nav>
</center>
</footer>	
</div>	
</body>
</html>