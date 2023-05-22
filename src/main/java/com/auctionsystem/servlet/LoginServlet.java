package com.auctionsystem.servlet;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.User;

import cn.auctionsystem.connection.DbCon;
import cn.auctionsystem.dao.Userdao;
import cn.auctionsystem.model.User;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.sendRedirect("newLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			
			try {
				Userdao udao = new Userdao(DbCon.getConnection());
				User user = udao.userLogin(email, password);
				
				if(user != null) {
					out.print("user login successful");
					request.getSession().setAttribute("auth", user);
					
					if(user.getRole()==0) {
						response.sendRedirect("adminhome.jsp");	
					}
					
					else if ( user.getRole() == 1) {
						response.sendRedirect("rephome.jsp");
					}
					else if ( user.getRole() == 2) {
						response.sendRedirect("createAuction.jsp");
					}
					else if ( user.getRole() == 3) {
						response.sendRedirect("buyerhome.jsp?sortBy=0&search=");
					}
					
				}
				else {
					out.print("user login failed");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			out.print(email+password);
		}
		
		
	}

}
