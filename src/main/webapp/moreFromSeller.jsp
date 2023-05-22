<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "cn.auctionsystem.dao.AuctionsDao" %>
<%@page import = "com.auctionsystem.model.Auctions" %>

<%@page import="java.util.List" %>
<%@page import = "cn.auctionsystem.connection.DbCon" %>

<%

AuctionsDao ad = new AuctionsDao(DbCon.getConnection());
int uid = Integer.parseInt(request.getParameter("uid"));
List<Auctions> auctions = ad.getSellerAuctions(uid);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

<div class="container mt-4">
    <h1>Seller Auction History</h1>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Auction ID</th>
          <th scope="col">Product ID</th>
          <th scope="col">Product Category</th>
        </tr>
      </thead>
      <tbody>
       <%
		if( !auctions.isEmpty()){
			for(Auctions a:auctions){%>
          <tr>
            <td><%= a.getId() %></td> 
            <td><%= a.getPid() %></td>
            <td><%= a.getCategory() %></td> 
          </tr>
        <% } } %>
      </tbody>
    </table>
  </div>

</body>
</html>