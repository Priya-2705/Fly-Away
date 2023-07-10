package mypackage.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.dao.FlightDao;
import mypackage.dao.UserDao;
import mypackage.daoimpl.FlightDaoImpl;
import mypackage.daoimpl.UserDaoImpl;
import mypackage.entities.Flight;
import mypackage.entities.User;

@WebServlet("/userdetailscontroller")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao = new UserDaoImpl();
	private FlightDao flightDao = new FlightDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uEmail = request.getParameter("uEmail");
		String uFirstName = request.getParameter("uFirstName");
		String uLastName = request.getParameter("uLastName");
		String uPhoneNumber = request.getParameter("uPhoneNumber");
		String uAddress = request.getParameter("uAddress");
		
		User user = (User) request.getSession().getAttribute("user");
		
		user.setuEmail(uEmail);
		user.setuFirstName(uFirstName);
		user.setuLastName(uLastName);
		user.setuPhoneNumber(uPhoneNumber);
		user.setuAddress(uAddress);
		
		try {
            userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
		
		calculateTicketPrice(request);
		
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		
		Flight flight = flightDao.getFlightById(flightId);
		HttpSession session = request.getSession();
		
		session.setAttribute("flightId", flightId);
		session.setAttribute("flight", flight);
		
		response.sendRedirect("flightdetails.jsp");
	}

	private void calculateTicketPrice(HttpServletRequest request) {
		int numberOfPersons = (int) request.getSession().getAttribute("numberOfPersons");
		double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
		
		double totalPrice = numberOfPersons * ticketPrice;
		HttpSession session = request.getSession();
		session.setAttribute("totalPrice", totalPrice);
	}

}
