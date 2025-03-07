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
.option {
	font-size: 12px;
	padding-top: 8px;
	color: #2095bf;
}
</style>
<meta charset="UTF-8">
<title>Admin Verification</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<form action="adminverificationcontroller" method="post" style = "width: 400px; margin: 0px auto;">
		<fieldset>
			<legend>Admin Verification</legend><br>
			<label>Please enter a unique 6-digit alphanumeric verification code to confirm your eligibility for registering as an admin</label><br><br>
			<label>Enter Code : </label><input type="password" name="code" required><br><br>
			
			<input type="submit" value="Submit">
			
			<div class="option">
				Not an admin?<a href="index.jsp">Click here</a>
			</div>
		</fieldset>
	</form>
</body>
</html>