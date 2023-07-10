package mypackage.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.Admin;
import mypackage.models.AirlineModel;
import mypackage.serviceimpl.AirlineServiceImpl;
import mypackage.services.AirlineService;

@WebServlet("/airlinecontroller")
public class AirlineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AirlineService airlineService = new AirlineServiceImpl();
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String airlineName = request.getParameter("airlineName");
    	
    	AirlineModel airlineModel = new AirlineModel(airlineName);
    	HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		airlineService.addAirline(admin, airlineModel);
		
		response.sendRedirect("airlineslist.jsp");
	}
}
