<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@page import="cn.auctionsystem.dao.Product_bidsDao"%>
<%@page import="com.auctionsystem.model.Product_bids"%>    


<%@page import="java.util.List"%>
<%@page import="cn.auctionsystem.connection.DbCon"%>
    
    
<% 

Product_bidsDao pd = new Product_bidsDao(DbCon.getConnection());
int aid = Integer.parseInt(request.getParameter("aid"));
List<Product_bids> bids = pd.getPreviousBids(aid);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

<div class="container mt-4">
    <h1>Bid History</h1>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">User ID</th>
          <th scope="col">Bidding Price</th>
        </tr>
      </thead>
      <tbody>
       <%
				if (!bids.isEmpty()) {
					for (Product_bids b : bids) {
				%>
          <tr>
            <td><%= b.getUid() %></td>
            <td><%= b.getCurrent_price() %></td> 
          </tr>
        <% } } %>
      </tbody>
    </table>
  </div>



</body>
</html>