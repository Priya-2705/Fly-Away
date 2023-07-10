<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Flight" %>
<%@ page import="mypackage.dao.FlightDao" %>
<%@ page import="mypackage.daoimpl.FlightDaoImpl" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
  .head1 {
  	color: #2095bf;
  	padding-top: 10px;
  	padding-bottom: 10px;
  	text-align: center;
  }
</style>

<meta charset="UTF-8">
<title>Flights List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		FlightDao flightDao = new FlightDaoImpl();
		List<Flight> flights = flightDao.getAll(); 
		request.setAttribute("flights", flights); 
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	%>
	<div class="head1">
		<h1> Flights List </h1>	
	</div>
		<table>
			<tr>
				<th> Flight ID </th>
				<th> Airline Name </th>
				<th> Source </th>
				<th> Destination </th>
				<th> Departure Date & Time </th>
				<th> Ticket Price </th>
				<th> Available Seats </th>
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Flight flight : flights) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= flight.getAirline().getAirlineName() %></td>
				<td><%= flight.getSourcePlace().getPlaceName() %></td>
				<td><%= flight.getDestinationPlace().getPlaceName() %></td>
				<td><%= flight.getDepartureDateTime().format(formatter) %></td>
				<td><%= flight.getTicketPrice() %></td>
				<td><%= flight.getAvailableSeats() %></td>
				<td>
					<form action="flightslist.jsp" method="POST">
						<input type="hidden" name="flightId" value="<%= flight.getFlightId() %>">
						<button type="submit" name="action" value="delete">Delete</button>
					</form>
				</td>
			</tr>
			<% sequence++; %>
	<%
		}
	%>	
			<tr>
				<td colspan="8">
					<form action="addflight.jsp" method="GET">
						<input type="submit" value="Add Flight"></input>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int flightId = Integer.parseInt(request.getParameter("flightId"));
			flightDao.delete(flightId);
			response.sendRedirect("flightslist.jsp");
		}
	%>	
</body>
</html>