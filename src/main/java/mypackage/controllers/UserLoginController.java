package mypackage.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.User;
import mypackage.models.UserLoginModel;
import mypackage.serviceimpl.UserServiceImpl;
import mypackage.services.UserService;

@WebServlet("/userlogincontroller")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uUsername = request.getParameter("uUsername");
		String uPassword = request.getParameter("uPassword");
		
		request.getSession().setAttribute("uUsername", uUsername);
		UserLoginModel userLoginModel = new UserLoginModel();
		userLoginModel.setuUsername(uUsername);
		userLoginModel.setuPassword(uPassword);
		
		User user = userService.getUser(userLoginModel);
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("userId", user.getUserId());
			response.sendRedirect("userhome.jsp");
		}
		else
			response.sendRedirect("userinvalidcred.jsp");		
	}
}
