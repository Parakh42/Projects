<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Customer Registration Form</title>
<style>
	body{
	background-image: url("/images/images1.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;

}
.well{
	opacity: 0.6;
}

</style>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Let's Carpool</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${contextPath}">Go Back</a></li>
    </ul>
  </div>
</nav>
<div class=well>

	<h2>Register a New Customer</h2>

	<form:form action="${contextPath}/user/registerCustomer" commandName="customer"
		method="post">

		<table>
			<div class=form-group>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" class="form-control" size="30"  />
					<font color="red"><form:errors path="firstName" /></font></td>
			</tr>
			</div>
			<div class=form-group>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" class="form-control" size="30"  />
					<font color="red"><form:errors path="lastName" /></font></td>
			</tr>
			</div>
			<div class=form-group>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" class="form-control" size="30"  />
					<font color="red"><form:errors path="userName" /></font></td>
			</tr>
			</div>
			<div class=form-group>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" class="form-control" size="30"
						 /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			</div>
			<div class=form-group>
			<tr>
				<td>Email Id:</td>
				<td><form:input path="email" class="form-control" size="30"
						type="email"  /> <font color="red"><form:errors
							path="email" /></font></td>
			</tr>
			</div>
			<div class=form-group>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phoneNumber" class="form-control" size="30"
						  /> <font color="red"><form:errors
							path="phoneNumber" /></font></td>
			</tr>
			</div>
			<div class=form-group>
			<tr>
				<td>Status:</td>
				<td><form:input path="status" class="form-control" value="customer" readonly="true"/></td>
			</tr>
			</div>
			<tr>
				<td colspan="2"><input type="submit" class="btn btn-success" value="Register Customer" /></td>
			</tr>
		</table>

	</form:form>
	</div>
<br>
<br>
<br>
<br>
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