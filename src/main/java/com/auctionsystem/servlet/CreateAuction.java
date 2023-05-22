package com.auctionsystem.servlet;

import java.io.IOException;
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

@WebServlet("/create-auction")
public class CreateAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
    public CreateAuction() {
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("");
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    int pid = Integer.parseInt(request.getParameter("pid"));
	    int uid = Integer.parseInt(request.getParameter("uid"));
	    float minimumPrice = Float.parseFloat(request.getParameter("minimumPrice"));
	    
	    String dateTimeStr = request.getParameter("closingTime");
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	    LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, formatter);
	    
	    Timestamp closingTime = Timestamp.valueOf(localDateTime);
	    
	    int bidType = Integer.parseInt(request.getParameter("bidType"));
	    float upperLimit = Float.parseFloat(request.getParameter("upperLimit"));
	    float bidIncrement = Float.parseFloat(request.getParameter("bidIncrement"));
	    int category = Integer.parseInt(request.getParameter("category"));

	    Auctions auction = new Auctions(0, pid, uid, minimumPrice, closingTime, bidType, upperLimit, bidIncrement, category);

	    try {
	        AuctionsDao auctionsDao = new AuctionsDao(DbCon.getConnection());
	        auctionsDao.addAuction(auction);

	        response.sendRedirect("success.jsp");
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("error.jsp");
	    }
	}


}
