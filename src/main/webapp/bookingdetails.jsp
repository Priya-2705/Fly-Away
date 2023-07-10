<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Booking"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<head>
<style>
.details {
	border: 2px #2095bf solid;
	text-align: center;
	border-collapse: collapse;
	width: 30%;
	margin: auto;
}

label {
	color: #2095bf;
	font-weight: bold;
}

.heading {
	color: #2095bf;
	padding-top: 10px;
	padding-bottom: 10px;
	text-align: center;
}
</style>

<meta charset="UTF-8">
<title>Booking Details</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="heading">
		<h2>Booking Details</h2>
	</div>
	<div class="details">
		<% 
            Booking booking = (Booking) request.getSession().getAttribute("booking");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String formattedDateTime = booking.getBookingDateTime().format(formatter);
		
            if (booking != null) {
        %>
		<div>
			<br><label>Flight ID : </label> <span><%= booking.getFlight().getFlightId() %></span><br><br>
		</div>
		<div>
			<label>Booking Date & Time : </label> <span><%= formattedDateTime %></span><br><br>
		</div>
		<div>
			<label>Total Tickets : </label> <span><%= booking.getTotalTickets() %></span><br><br>
		</div>
		<div>
			<label>Total Price : </label> <span><%= booking.getTotalPrice() %></span><br><br>
		</div>
		<div>
			<label>Payment Status : </label> <span><%= booking.getPaymentStatus() %></span><br><br>
		</div>
		
		<% 
            } else {
        %>
		<div>No booking details available for this user.</div>
		<% 
            }
        %>
	</div>

</body>
</html>
