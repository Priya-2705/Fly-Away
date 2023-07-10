package mypackage.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminverificationcontroller")
public class AdminVerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		if(code.equals("C3H9S4"))
		{
			response.sendRedirect("adminregister.jsp");
		}
		else
			response.sendRedirect("invalidcode.jsp");
	}

}
