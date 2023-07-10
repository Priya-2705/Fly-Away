<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Airline" %>
<%@ page import="mypackage.dao.AirlineDao" %>
<%@ page import="mypackage.daoimpl.AirlineDaoImpl" %>
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
<title>Airlines List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		AirlineDao airlineDao = new AirlineDaoImpl();
		List<Airline> airlines = airlineDao.getAll(); 
		request.setAttribute("airlines", airlines); 
	%>
	<div class="head1">
		<h1> Airlines List </h1>	
	</div>
		<table>
			<tr>
				<th> Airline ID </th>
				<th> Airline Name </th>
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Airline airline : airlines) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= airline.getAirlineName() %></td>
				<td>
					<form action="airlineslist.jsp" method="POST">
						<input type="hidden" name="airlineId" value="<%= airline.getAirlineId() %>">
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
					<form action="addairline.jsp" method="GET">
						<input type="submit" value="Add Airline"></input>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int airlineId = Integer.parseInt(request.getParameter("airlineId"));
			airlineDao.delete(airlineId);
			response.sendRedirect("airlineslist.jsp");
		}
	%>	
</body>
</html>