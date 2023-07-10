package mypackage.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.models.AdminModel;
import mypackage.serviceimpl.AdminServiceImpl;
import mypackage.services.AdminService;

@WebServlet("/adminregistercontroller")
public class AdminRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService = new AdminServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aUsername = request.getParameter("aUsername");
		String aPassword = request.getParameter("aPassword");
		
		AdminModel adminModel = new AdminModel(aUsername, aPassword);
		adminService.register(adminModel);
		
		response.sendRedirect("adminregistrationsuccessful.jsp");
	}
}
