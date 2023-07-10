package mypackage.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.Admin;
import mypackage.models.AdminLoginModel;
import mypackage.serviceimpl.AdminServiceImpl;
import mypackage.services.AdminService;

@WebServlet("/adminlogincontroller")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService = new AdminServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aUsername = request.getParameter("aUsername");
		String aPassword = request.getParameter("aPassword");
		
		AdminLoginModel adminLoginModel = new AdminLoginModel(aUsername, aPassword);
		adminLoginModel.setaUsername(aUsername);
		adminLoginModel.setaPassword(aPassword);
		
		Admin admin = adminService.getAdmin(adminLoginModel);
		if(admin != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("adminchangepassword.jsp");
		}
		else
			response.sendRedirect("admininvalidcred.jsp");
	}
}
