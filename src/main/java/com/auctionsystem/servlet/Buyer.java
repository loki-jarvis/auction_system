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

@WebServlet("/place-bid?productId=xxxxxx")
public class Buyer extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.sendRedirect("createAuction.jsp");
		
//		Product p = 
		
//		if p.type == 0:
//			return 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// INsert into the Bid Table

		
		
	}

}
