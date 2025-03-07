<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.time.LocalDate" %>
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
label, input[type="number"] {
	display: inline-block;
	width: 160px;
	text-align: right;
	font-weight: 600;
	color: #2095bf;
	margin-right: 5px;
}
select {
	display: inline-block;
	width: 160px;
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>SmoothPay Payment Gateway</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<form action="paymentcontroller" method="post" style="width: 450px; margin: 0px auto;">
        <fieldset>
            <legend>SmoothPay - Payment Details</legend>
            <br><input type="hidden" name="bookingId" value="<%= request.getParameter("bookingId") %>">
            <label>Card Number : </label><input type="text" name="cardNumber" required><br><br>
            <label>Card Holder Name : </label><input type="text" name="cardHolderName" required><br><br>
            <label>Expiration Month : </label>
				<select name="expirationMonth" required>
    				<option disabled selected value>-- select month --</option>
   					<% for (int month = 1; month <= 12; month++) { %>
        			<option value="<%= month %>"><%= month %></option>
    				<% } %>
				</select><br><br>
            <label>Expiration Year : </label><input type="number" name="expirationYear" min="<%= LocalDate.now().getYear() %>" maxlength="4" required><br><br>
            <label>CVV : </label><input type="number" name="cvv" maxlength="3" required><br><br>
            
            <input type="submit" value="Submit"><br><br>
        </fieldset>
    </form>
</body>
</html>