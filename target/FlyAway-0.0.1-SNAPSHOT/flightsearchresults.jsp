<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Flight"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<head>
<style>
table {
	border-collapse: collapse;
	width: 70%;
	margin: auto;
}

th, td {
	border: 2px #2095bf solid;
	text-align: center;
}

th {
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
<title>Flight Search Results</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="heading">
		<h2>Flight Search Results</h2>
	</div>

	<table>
		<tr>
			<th>Airline</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Departure Date & Time</th>
			<th>Ticket Price</th>
			<th>Available Seats</th>
			<th>Actions</th>
		</tr>
		<%
		List<Flight> flights = (List<Flight>) request.getAttribute("flights");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		if (flights != null && !flights.isEmpty()) {
			for (Flight flight : flights) {
		%>
		<tr>
			<td><%=flight.getAirline().getAirlineName()%></td>
			<td><%=flight.getSourcePlace().getPlaceName()%></td>
			<td><%=flight.getDestinationPlace().getPlaceName()%></td>
			<td><%=flight.getDepartureDateTime().format(formatter)%></td>
			<td><%=flight.getTicketPrice()%></td>
			<td><%=flight.getAvailableSeats()%></td>
			<td>
				<form action="userdetails.jsp" method="POST">
					<input type="hidden" name="flightId" value="<%=flight.getFlightId()%>"> 
					<input type="hidden" name="ticketPrice" value="<%=flight.getTicketPrice()%>">
					<button type="submit" name="action" value="book">Book</button>
				</form>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="7">No flights found for the selected criteria.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
