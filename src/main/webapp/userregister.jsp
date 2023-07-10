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
	color: #2095bf;
}
</style>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<form action="userregistercontroller" method="post" style = "width: 400px; margin:  0px auto;">
		<fieldset>
			<legend>User Registration Form</legend><br>
			<label>Username : </label><input type="text" name="uUsername" required><br><br>
			<label>Password : </label><input type="password" name="uPassword" required><br><br>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>