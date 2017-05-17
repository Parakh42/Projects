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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Post Car Details</title>
<style>
body{
	background-image: url("/images/images1.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;

}
.well{
	opacity: 0.7;
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
    	<li><a href="${contextPath}/user/">Home</a><br/></li>
      <li><a href="${contextPath}/user/logout">Logout</a></li>
    </ul>
  </div>
</nav>
	
<!--  	<a href="${contextPath}/user/logout" >Logout</a><br>
	<a href="${contextPath}/user/">Home</a><br/>-->

<center>
	<div class="well">
	<h2>Post New Car Details</h2>
	
		<form:form action="${contextPath}/postCar/add" method="post" commandName="postCar" enctype="multipart/form-data">

		<table>
		
		<div class="form-group">
			<tr>
				<td>Posted By</td>
				<td>${sessionScope.user.userName}</td>
				<td><form:hidden path="postedBy" class="form-control"
						value="${sessionScope.user.personId}" /></td>
			</tr>
			<br>
		</div>
		<div class="form-group">
			<tr>
				<td>Information:</td>
				<td><form:input class="form-control" path="info" size="30"/>
				<font color="red"><form:errors path="info" /></font></td>
			</tr>
		</div>
		<div class="form-group">	
			<tr>
				<td>Departure:</td>
				<td><form:input  class="form-control" path="arrivalFrom" size="30"  />
				<font color="red"><form:errors path="arrivalFrom" /></font></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td>Destination:</td>
				<td><form:input class="form-control" path="destinationTo" size="30" />
				<font color="red"><form:errors path="destinationTo" /></font></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td>Create Album:</td>
				<td><form:input type="text" class="form-control" path="fileName" />
				<font color="red"><form:errors path="fileName" /></font></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td>Select photo:</td> 
				<td><form:input type="file" class="form-control" path="photo"/>
				<font color="red"><form:errors path="photo" /></font></td>
			</tr>
		</div>
			<tr>
				<td colspan="2"><input type="submit" class="btn btn-success" value="Post Car" /></td>
			</tr>
		</table>

	</form:form>
	</div>
	</center>


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