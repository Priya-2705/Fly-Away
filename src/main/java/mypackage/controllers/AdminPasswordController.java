package mypackage.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.dao.AdminDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.entities.Admin;

@WebServlet("/adminpasswordcontroller")
public class AdminPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminDao adminDao = new AdminDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String action = request.getParameter("action");
    	
    	if (action != null) {
            if (action.equals("Yes")) {
            	response.sendRedirect("newpassword.jsp");
            } else if (action.equals("No")) {
            	response.sendRedirect("adminhome.jsp");
            } else if (action.equals("Submit")) {
                
            	String newpassword = request.getParameter("newpassword");
            	
            	Admin admin = (Admin) request.getSession().getAttribute("admin");
            	admin.setaPassword(newpassword);
            	adminDao.update(admin);
            	
            	response.sendRedirect("passwordchanged.jsp");
            }
        }
    }
}
