<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Account Type</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
}

.accounttype {
	border: 2px solid #2095bf;
	border-radius: 10px;
	display: inline-block;
	width: 300px;
	height: 300px;
	margin-top: 80px;
}

.accounttype h1 {
	margin: 10px 0;
	padding: 0;
	color: #2095bf;
}

.options {
	display: flex;
	justify-content: center;
	margin-top: 30px;
}

.option {
	margin: 20px;
	cursor: pointer;
}

.option img {
	width: 80px;
	height: 80px;
	border-radius: 50%;
	box-shadow: 0 4px 8px #2095bf;
	transition: transform 0.3s ease-in-out;
}

.option img:hover {
	transform: scale(1.1);
}

.option span {
	font-size: 18px;
	margin-top: 10px;
	margin-left: 15px;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="accounttype">
		<h1>Choose Account Type</h1>
		<div class="options">
			<div class="option">
				<a href="userlogin.jsp"> <img src="user.png"> <span>User</span>
				</a>
			</div>
			<div class="option">
				<a href="adminlogin.jsp"> <img src="admin.png"> <span>Admin</span>
				</a>
			</div>
		</div>
	</div>
</body>
</html>