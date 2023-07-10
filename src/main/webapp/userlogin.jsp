<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.welcome {
	text-align: center;
	padding-bottom: 20px;
	color: #2095bf;
}
fieldset {
	text-align: center;
	border: 2px #2095bf solid;
}
legend {
	text-align: center;
	color: #2095bf;
	font-size: 20px;
	font-weight: 700;
}
.option {
	font-size: 12px;
	padding-top: 8px;
	color: #2095bf;
}
label {
	color: #2095bf;
}
</style>

<meta charset="UTF-8">
<title>User Login Page</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	
	<div class="welcome">
		<h1>Fly Away</h1>
	</div>
	<form action="userlogincontroller " method="post" style = "width: 400px; margin:  0px auto;">
		<fieldset>
			<legend>User Login</legend><br>
			<label>Username : </label><input type="text" name="uUsername" required><br><br>
			<label>Password : </label><input type="password" name="uPassword" required><br><br>
			<input type="submit" value="Submit">
			
			<div class="option">
				Not a registered user?<a href="userregister.jsp">Click here</a>
			</div>
		</fieldset>
	</form>
	
</body>
</html>


    
