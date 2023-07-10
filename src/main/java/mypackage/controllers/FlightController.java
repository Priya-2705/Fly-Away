package mypackage.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.Admin;
import mypackage.models.FlightModel;
import mypackage.serviceimpl.FlightServiceImpl;
import mypackage.services.FlightService;


@WebServlet("/flightcontroller")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private FlightService flightService = new FlightServiceImpl();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int airlineId = Integer.parseInt(request.getParameter("airlineId"));
		int sourceId = Integer.parseInt(request.getParameter("sourceId"));
		int destinationId = Integer.parseInt(request.getParameter("destinationId"));
		String departureDateTimeString = request.getParameter("departureDateTime");
		double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
		int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
		
		LocalDateTime departureDateTime = LocalDateTime.parse(departureDateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		FlightModel flightModel = new FlightModel(airlineId, sourceId, destinationId, departureDateTime, ticketPrice, availableSeats);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		flightService.addFlight(admin, flightModel);
		
		response.sendRedirect("flightslist.jsp");
	}
}