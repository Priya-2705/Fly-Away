    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Place"%>
<%@ page import="mypackage.dao.PlaceDao"%>
<%@ page import="mypackage.daoimpl.PlaceDaoImpl"%>
<%@page import="mypackage.serviceimpl.PlaceServiceImpl"%>
<head>
<link rel="stylesheet" href="userhome-styles.css">
<meta charset="UTF-8">
<title>User Home</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<% 
		PlaceDao placeDao = new PlaceDaoImpl();
		List<Place> places = placeDao.getAll(); 
		request.setAttribute("places", places);
	%>

	<div class="heading">
		<h2>Welcome to Fly Away</h2>
	</div>
	<form action="flightsearchcontroller" method="post" style="width: 450px; margin: 0px auto;">
		<fieldset>
			<legend>Flight Search</legend>
			<br>
			<p>
				<label>Date of Travel :</label> <input type="date" name="dateOfTravel" min="<%=java.time.LocalDate.now()%>" required>
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
				<label>No. of persons : </label> <input type="number" name="numberOfPersons" required>
			</p>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>