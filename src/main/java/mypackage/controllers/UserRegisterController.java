package mypackage.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.models.UserModel;
import mypackage.serviceimpl.UserServiceImpl;
import mypackage.services.UserService;

@WebServlet("/userregistercontroller")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uUsername = request.getParameter("uUsername");
		String uPassword = request.getParameter("uPassword");
		
		UserModel userModel = new UserModel();
		userModel.setuUsername(uUsername);
		userModel.setuPassword(uPassword);
		userService.register(userModel);
		
		response.sendRedirect("userregistrationsuccessful.jsp");
	}
}
