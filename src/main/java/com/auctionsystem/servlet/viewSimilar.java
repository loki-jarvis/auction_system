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


@WebServlet("/view-similar")
public class viewSimilar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public viewSimilar() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
		int categoryId = Integer.parseInt(request.getParameter("cid"));
		AuctionsDao adao = new AuctionsDao(DbCon.getConnection());
		List<Auctions> similarAuctions = adao.getSimilarAuctions(categoryId);
        request.setAttribute("auctions", similarAuctions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewSimilar.jsp");
        dispatcher.forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return;
		
	}

}
