package mypackage.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.Admin;
import mypackage.models.PlaceModel;
import mypackage.serviceimpl.PlaceServiceImpl;
import mypackage.services.PlaceService;

@WebServlet("/placecontroller")
public class PlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PlaceService placeService = new PlaceServiceImpl();
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String placeName = request.getParameter("placeName");
    	
    	PlaceModel placeModel = new PlaceModel(placeName);
    	HttpSession session = request.getSession();
    	Admin admin = (Admin) session.getAttribute("admin");
    	placeService.addPlace(admin, placeModel);
    	
    	response.sendRedirect("placeslist.jsp");
	}
}
