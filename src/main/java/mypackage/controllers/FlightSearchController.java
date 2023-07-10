package mypackage.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.Flight;
import mypackage.serviceimpl.FlightServiceImpl;
import mypackage.services.FlightService;

@WebServlet("/flightsearchcontroller")
public class FlightSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private FlightService flightService = new FlightServiceImpl();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDate dateOfTravel = LocalDate.parse(request.getParameter("dateOfTravel"));
		int sourceId = Integer.parseInt(request.getParameter("sourceId"));
		int destinationId = Integer.parseInt(request.getParameter("destinationId"));
		int numberOfPersons = Integer.parseInt(request.getParameter("numberOfPersons"));
		
		HttpSession session = request.getSession();
		session.setAttribute("numberOfPersons", numberOfPersons);
		
        List<Flight> flights = flightService.getFlightsBySearchCriteria(dateOfTravel, sourceId, destinationId, numberOfPersons);
       
        request.setAttribute("flights", flights);

        request.getRequestDispatcher("flightsearchresults.jsp").forward(request, response);
    }
}