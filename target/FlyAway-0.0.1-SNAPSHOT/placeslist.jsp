<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Place" %>
<%@ page import="mypackage.dao.PlaceDao" %>
<%@ page import="mypackage.daoimpl.PlaceDaoImpl" %>
<head>
<style>
  table {
    border-collapse: collapse;
    width: 40%;	
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
<title>Places List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		PlaceDao placeDao = new PlaceDaoImpl();
		List<Place> places = placeDao.getAll(); 
		request.setAttribute("places", places); 
	%>
	<div class="head1">
		<h1> Places List </h1>	
	</div>
		<table>
			<tr>
				<th> Place ID </th>
				<th> Place Name </th>
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Place place : places) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= place.getPlaceName() %></td>
				<td>
					<form action="placeslist.jsp" method="POST">
						<input type="hidden" name="placeId" value="<%= place.getPlaceId() %>">
						<button type="submit" name="action" value="delete">Delete</button>
					</form>
				</td>
			</tr>
			<% sequence++; %>
	<%
		}
	%>	
			<tr>
				<td colspan="3">
					<form action="addplace.jsp" method="GET">
						<input type="submit" value="Add Place"></input>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int placeId = Integer.parseInt(request.getParameter("placeId"));
			try {
		        placeDao.delete(placeId);
		        response.sendRedirect("placeslist.jsp");
		    } catch (Exception e) {
		        response.sendRedirect("cannotdeleteplace.jsp");
		    }
		}
	%>	
</body>
</html>