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

label {
	width: 80px;
	font-weight: 600;
	color: #2095bf;
	margin-right: 5px;
}

input[text="submit"] {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Password Change</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="box">
		<form action="adminpasswordcontroller" method="post" style="width: 400px; margin: 0px auto;">
			<fieldset>
                <br><label>Do you want to change your password?</label><br><br>
                <input type="submit" name="action" value="Yes">
                <input type="submit" name="action" value="No">
                <br><br>
            </fieldset>
		</form>
	</div>
</body>
</html>