<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>List Posted Cars</title>
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
    	<li><a href="${contextPath}/user/login">Home</a><br/></li>
      <li><a href="${contextPath}/user/logout">Logout</li>
    </ul>
  </div>
</nav>
<div class="well">
	<form action="${contextPath}/postCar/requestMessage" method="get">
	<table border="1" cellpadding="2" cellspacing="2" class="table table-hover">
		<thead>
		<tr>
			<td><b>Posted By</b></td>
			<td><b>INFORMATION</b></td>
			<td><b>DEPARTURE</b></td>
			<td><b>DESTINATION</b></td>
			<td><b>CAR PHOTO</b></td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="post" items="${postCar}">
			<tr>
				<td>${post.user.firstName}</td>
				<td>${post.info}</td>
				<td>${post.arrivalFrom}</td>
				<td>${post.destinationTo}</td>
				<td> <img height="150" width="150" src="${post.fileName}" /></td>
				<td colspan="2"><button type="submit" name="request" value="${post.postId}">Request</button></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
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
</body>
</html>