<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
form {
	padding-top: 50px;
}
fieldset {
	text-align: center;
	border: 2px #2095bf solid;
	overflow: auto;
}
legend {
	text-align: center;
	color: #2095bf;
	font-size: 20px;
	font-weight: 700;
}
label {
	display: inline-block;
	width: 130px;
	text-align: right;
	font-weight: 600;
	color: #2095bf;
	margin-right: 5px;
}
span {
	display: inline-block;
	width: 163px;
	text-align: left;
	font-weight: 600;
	margin-right: 5px;
}
</style>
<meta charset="UTF-8">
<title>User Details for Flight Booking</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<form action="userdetailscontroller" method="post" style = "width: 400px; margin:  0px auto;">
		<fieldset>
			<legend>User Details Form</legend><br>
		    <input type="hidden" name="flightId" value="<%= request.getParameter("flightId") %>">
		    <input type="hidden" name="ticketPrice" value="<%= request.getParameter("ticketPrice") %>">
			<label>UserName : </label><span><%= session.getAttribute("uUsername") %></span><br><br>
			<label>Email : </label><input type="text" name="uEmail" required><br><br>
			<label>First Name : </label><input type="text" name="uFirstName" required><br><br>
			<label>Last Name : </label><input type="text" name="uLastName" required><br><br>
			<label>Phone Number : </label><input type="text" name="uPhoneNumber" required><br><br>
			<label>Address : </label><input type="text" name="uAddress" required><br><br>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>