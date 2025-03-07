    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="javax.servlet.http.HttpSession.*" %>
<head>
<style>
h2 {
	padding-left: 10px;
	padding-top: 20px;
	text-align: center; 
}
</style>
<meta charset="UTF-8">
<title>Logged out</title>
</head>
<body>

    <%@ include file="header.jsp"%>

    <h2>You have logged out successfully. <br><br>
    <a href="index.jsp">Click here</a> to login again.</h2>
    
    <%
        HttpSession sess = request.getSession(false);
        if (sess != null) {
            session.invalidate();
        }
    %>
    
</body>
</html>