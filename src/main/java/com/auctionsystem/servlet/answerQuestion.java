package com.auctionsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.auctionsystem.connection.DbCon;

import cn.auctionsystem.dao.QuestionsDao;
import com.auctionsystem.model.Question;


@WebServlet("/answer-question")
public class answerQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public answerQuestion() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String answer = request.getParameter("answer");
	    int questionId = Integer.parseInt(request.getParameter("questionId"));
	    
	    
	    try {
	    	
	    	
	    QuestionsDao qdao = new QuestionsDao(DbCon.getConnection());
	    qdao.saveAnswer(answer, questionId);
	    
	    
	    response.sendRedirect("rephome.jsp");
		
	    
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
	}

}
