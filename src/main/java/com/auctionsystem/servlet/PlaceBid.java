package com.auctionsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.auctionsystem.connection.DbCon;
import cn.auctionsystem.dao.AuctionsDao;
import cn.auctionsystem.dao.Product_bidsDao;
import com.auctionsystem.model.Auctions;
import cn.auctionsystem.model.User;
import com.auctionsystem.model.Product_bids;


@WebServlet("/place-bid")
public class PlaceBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlaceBid() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int aid = Integer.parseInt(request.getParameter("auctionId"));
		
		System.out.println("auction ID is"+aid);
	
		
		try {
		
		AuctionsDao adao = new AuctionsDao(DbCon.getConnection());
		Auctions auctions = adao.getSpecificAuction(aid);

		if( auctions.getBidType() == 1) {
//			response.sendRedirect("ManualAuction.jsp");
			response.sendRedirect("ManualAuction.jsp?aid=" + auctions.getId());

		}
		else {
			response.sendRedirect("AutomaticAuction.jsp?aid=" + auctions.getId());
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {

		    // Get parameters from the request
			
				User user = (User) request.getSession().getAttribute("auth");
				int uid = user.getUid();

			System.out.println("uid is: "+ uid);
			System.out.println("pid is: "+Integer.parseInt(request.getParameter("pid")));
			System.out.println("aid is: "+Integer.parseInt(request.getParameter("aid")));
			
		
			
//		    int uid = Integer.parseInt(request.getParameter("uid"));
		    int pid = Integer.parseInt(request.getParameter("pid"));
		    int aid = Integer.parseInt(request.getParameter("aid"));
		    float current_price = Float.parseFloat(request.getParameter("current_bid"));

		    // Create a new ProductBid object
		    Product_bids productBid = new Product_bids(uid, pid, current_price, aid);

		    // Insert the ProductBid object into the database using the DAO
		    Product_bidsDao productBidDAO = new Product_bidsDao(DbCon.getConnection());
		    productBidDAO.InsertBid(productBid);
		    
		    boolean shouldBeNotified = true;
		    
		    if(shouldBeNotified) {
		    	
		    	productBidDAO.notifyUsers(productBid);
		    }
		    
		    productBidDAO.notifyUsers(productBid);

		    // Redirect to a success page
//		    response.sendRedirect("success.jsp");
//		    
//		    response.setContentType("text/html");
//		    PrintWriter out = response.getWriter();
		    
		    

		    response.sendRedirect("buyerhome.jsp");
		    
			}catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
			
	
		

	}

}
