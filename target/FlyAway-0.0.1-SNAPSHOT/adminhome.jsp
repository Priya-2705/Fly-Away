    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="adminhome-styles.css">
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="heading">
		<h2>Welcome to Fly Away</h2>
	</div>
	<div class="tiles">
		<div class="column-2 option-1">
			<h2 class="option-text"><a href="placeslist.jsp">Places<br>List</a></h2>
		</div>
		<div class="column-2 option-2">
			<h2 class="option-text"><a href="airlineslist.jsp">Airlines<br>List</a></h2>
		</div>
		<div class="column-2 option-3">
			<h2 class="option-text"><a href="flightslist.jsp">Flights<br>List</a></h2>
		</div>
	</div>
</body>
</html>