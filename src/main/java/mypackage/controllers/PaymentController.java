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

import mypackage.dao.BookingDao;
import mypackage.dao.FlightDao;
import mypackage.daoimpl.BookingDaoImpl;
import mypackage.daoimpl.FlightDaoImpl;
import mypackage.entities.Booking;
import mypackage.entities.Flight;
import mypackage.entities.User;

@WebServlet("/paymentcontroller")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookingId = request.getParameter("bookingId");
		String cardNumber = request.getParameter("cardNumber");
		String cardHolderName = request.getParameter("cardHolderName");
		int expirationMonth = Integer.parseInt(request.getParameter("expirationMonth"));
		int expirationYear = Integer.parseInt(request.getParameter("expirationYear"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));

		boolean paymentSuccess = processPayment(cardNumber, cardHolderName, expirationMonth, expirationYear, cvv);

		if (paymentSuccess) {
			int userId = (int) request.getSession().getAttribute("userId");
			int flightId = (int) request.getSession().getAttribute("flightId");
			int totalTickets = (int) request.getSession().getAttribute("numberOfPersons");
			double totalPrice = (double) request.getSession().getAttribute("totalPrice");
			String paymentStatus = "Paid"; // Assuming payment was successful

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime bookingDateTime = LocalDateTime.now();
            String formattedDateTime = bookingDateTime.format(formatter);
            LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, formatter);

            try {
                Booking booking = new Booking();
                booking.setUser(new User(userId));
                booking.setFlight(new Flight(flightId));
                booking.setBookingDateTime(parsedDateTime);
                booking.setTotalTickets(totalTickets);
                booking.setTotalPrice(totalPrice);
                booking.setPaymentStatus(paymentStatus);
                
				BookingDao bookingDao = new BookingDaoImpl();
				bookingDao.add(booking);
				
				HttpSession session = request.getSession();
				session.setAttribute("booking", booking);
				
				FlightDao flightDao = new FlightDaoImpl();
				Flight flight = flightDao.getFlightById(flightId);
				int availableSeats = flight.getAvailableSeats() - totalTickets;
				flight.setAvailableSeats(availableSeats);
				flightDao.update(flight);
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.sendRedirect("bookingdetails.jsp?bookingId=" + bookingId);
		} else {
			response.sendRedirect("paymentfailed.jsp");
		}
	}

	private boolean processPayment(String cardNumber, String cardHolderName, int expirationMonth, int expirationYear,
			int cvv) {

		return true;
	}
}
