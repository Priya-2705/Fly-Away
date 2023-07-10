<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Flight"%>
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
<title>Flight Details</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="heading">
		<h2>Flight Details</h2>
	</div>
	<div class="details">
		<% 
            Flight flight = (Flight) session.getAttribute("flight");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            if (flight != null) {
        %>
		<div>
			<br><label>Airline : </label> <span><%= flight.getAirline().getAirlineName() %></span><br><br>
		</div>
		<div>
			<label>Source : </label> <span><%= flight.getSourcePlace().getPlaceName() %></span><br><br>
		</div>
		<div>
			<label>Destination : </label> <span><%= flight.getDestinationPlace().getPlaceName() %></span><br><br>
		</div>
		<div>
			<label>Departure Date & Time : </label> <span><%= flight.getDepartureDateTime().format(formatter) %></span><br><br>
		</div>
		<div>
			<label>Ticket Price : </label> <span><%= flight.getTicketPrice() %></span><br><br>
		</div>
		<div>
			<label>No. of Persons : </label> <span><%= session.getAttribute("numberOfPersons") %></span><br><br>
		</div>
		<div>
			<label>Total Price : </label> <span><%= session.getAttribute("totalPrice") %></span><br><br>
		</div>
		<form action="smoothpay.jsp">
			<input type="submit" value="Pay Now"><br><br>
		</form>
		<% 
            } else {
        %>
		<div>No flight details available.</div>
		<% 
            }
        %>
	</div>

</body>
</html>
