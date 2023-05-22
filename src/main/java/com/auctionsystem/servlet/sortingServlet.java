package com.auctionsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctionsystem.model.Auctions;

import cn.auctionsystem.connection.DbCon;
import cn.auctionsystem.dao.AuctionsDao;

@WebServlet("/sort-items")
public class sortingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public sortingServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		System.out.println("Sort preference Changed");

		try {
			Integer sortBy = Integer.parseInt(request.getParameter("sortBy"));
			
			String se = request.getParameter("search");
			Integer searchVal = Integer.parseInt(se);
//			if(se != null) {
//				searchVal = Integer.parseInt(se);
//			}
			AuctionsDao adao = new AuctionsDao(DbCon.getConnection());
			List<Auctions> sortedAuctions = adao.getSortedAuctions(sortBy); // Get the sorted auctions from the database
			request.setAttribute("auctions", sortedAuctions);
			
//			System.out.println("After Changing: ");
			for (Auctions auction : sortedAuctions) {
//			    System.out.println("Auction ID: " + auction.getId());
			}
			String url = "buyerhome.jsp?sortBy="+sortBy+"&search=" + searchVal;
			System.out.println(url);
			response.sendRedirect(url);
		} catch (Exception e) {
			e.getStackTrace();
		}
	
		return;
	
	}
	
	

}
