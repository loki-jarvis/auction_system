package com.auctionsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.auctionsystem.connection.DbCon;
import cn.auctionsystem.dao.AuctionsDao;
import com.auctionsystem.model.Auctions;
import cn.auctionsystem.dao.QuestionsDao;

@WebServlet("/FAQ")
public class FAQ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
    public FAQ() {
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("FAQ.jsp");
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("user_id"));
		String question = request.getParameter("question");
		
		try {
			QuestionsDao qd = new QuestionsDao(DbCon.getConnection());
			
			qd.addQuestion(uid, question);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("FAQ.jsp");
		
		
		
		

	}


}
