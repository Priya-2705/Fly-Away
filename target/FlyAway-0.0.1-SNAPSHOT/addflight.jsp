<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Airline"%>
<%@ page import="mypackage.dao.AirlineDao"%>
<%@ page import="mypackage.daoimpl.AirlineDaoImpl"%>
<%@page import="mypackage.serviceimpl.AirlineServiceImpl"%>
<%@ page import="mypackage.entities.Place"%>
<%@ page import="mypackage.dao.PlaceDao"%>
<%@ page import="mypackage.daoimpl.PlaceDaoImpl"%>
<%@page import="mypackage.serviceimpl.PlaceServiceImpl"%>
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

label {
	display: inline-block;
	width: 200px;
	text-align: right;
	font-weight: 600;
	color: #2095bf;
	margin-right: 5px;
}

input[type="text"], input[type="number"], select {
	width: 167px;
}

select option[disabled], input[type="datetime-local"] {
	text-align: center;
	padding: 0;
}
</style>
<meta charset="UTF-8">
<title>Add a Flight</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<% 
		AirlineDao airlineDao = new AirlineDaoImpl();
		List<Airline> airlines = airlineDao.getAll(); 
		request.setAttribute("airlines", airlines);  
		
		PlaceDao placeDao = new PlaceDaoImpl();
		List<Place> places = placeDao.getAll(); 
		request.setAttribute("places", places);
	%>
	<form action="flightcontroller" method="post" style="width: 500px; margin: 0px auto;">
		<fieldset>
			<legend>Add Flight Form</legend>
			<br>
			<p>
				<label> Select Airline : </label> <select name="airlineId" required>
					<option disabled selected value>-- select airline --</option>
					<% for (Airline airline : airlines) { %>
					<option value="<%= airline.getAirlineId() %>"><%= airline.getAirlineName() %></option>
					<% } %>
				</select>
			</p>
			<p>
			<p>
				<label> Select Source : </label> <select name="sourceId" required>
					<option disabled selected value>-- select source --</option>
					<% for (Place place : places) { %>
					<option value="<%= place.getPlaceId() %>"><%= place.getPlaceName() %></option>
					<% } %>
				</select>
			</p>
			<p>
				<label> Select Destination : </label> <select name="destinationId" required>
					<option disabled selected value>-- select destination --</option>
					<% for (Place place : places) { %>
					<option value="<%= place.getPlaceId() %>"><%= place.getPlaceName() %></option>
					<% } %>
				</select>
			</p>
			<p>
				<label>Departure Date and Time :</label> <input type="datetime-local" name="departureDateTime" min="<%=java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME)%>" required>
			</p>
			<p>
				<label>Ticket Price : </label> <input type="number" name="ticketPrice" step="0.01" required>
			</p>
			<p>
				<label>Available Seats : </label> <input type="number" name="availableSeats" min="50" max="150" required>
			</p>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>