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

}
.well{
	opacity: 0.7;
}

</style>
<title>Request List</title>
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
<div class="well">
<form action="${contextPath}/postCar/mail" method="post">
<table border="1" cellpadding="2" cellspacing="2" class="table table-hover">
		<thead>
		<tr>
			<td><b>Post Id</b></td>
			<td><b>Customer</b>
			<td><b>Message</b></td>	
		</tr>
		</thead>
		<tbody>
		<c:forEach var="messageList" items="${messageList}">
			<tr>
				<td>${messageList.postCar.postId}</td>
				<td>${messageList.customer.firstName}</td>
				<td>${messageList.message}</td>
				<td><input type="radio" name="${messageList.requestId}" value="confirmation" checked="checked">Confirmation</td>
           		<td><input type="radio" name="${messageList.requestId}" value="reject">Reject</td>
           		<td colspan="2"><button type="submit" name="send" value="${messageList.customer.personId}">Send</button></td>
           		<input type="hidden"  name="messageId" value="${messageList.requestId}"/>
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