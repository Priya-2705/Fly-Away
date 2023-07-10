<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2 {
	padding-left: 10px;
	padding-top: 20px;
	text-align: center; 
}
</style>
<meta charset="ISO-8859-1">
<title>Place cannot be deleted</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<h2>Cannot delete the place as there are associated flights!! <br><br>
	<a href="placeslist.jsp">Click here</a> to return to Places List page.</h2>
</body>
</html>
