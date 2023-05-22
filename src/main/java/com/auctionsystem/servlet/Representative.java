package com.auctionsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.auctionsystem.connection.DbCon;
import cn.auctionsystem.dao.Userdao;
import cn.auctionsystem.dao.Product_bidsDao;
import com.auctionsystem.model.Auctions;
import cn.auctionsystem.model.User;
import com.auctionsystem.model.Product_bids;



@WebServlet("/addrepresentative")
public class Representative extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("addRepresentative.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {

		    // Get parameters from the request
			
			
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				Userdao ud = new Userdao(DbCon.getConnection());
				
				ud.addRepresentative(name, email, password);
				
				
				
		    
			}catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
			
			response.sendRedirect("adminhome.jsp");
		

	}

}
