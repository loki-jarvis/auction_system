<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import = "cn.auctionsystem.dao.ProductDao" %>
<%@page import = "cn.auctionsystem.dao.AuctionsDao" %>
<%@page import = "cn.auctionsystem.connection.DbCon" %>
<%@page import = "com.auctionsystem.model.Product" %>
<%@page import = "com.auctionsystem.model.Auctions" %>


<% 

ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();

String paramValue = request.getParameter("sortBy");
int intValue = Integer.parseInt(paramValue);

AuctionsDao ad = new AuctionsDao(DbCon.getConnection());

String searchParam = request.getParameter("search");

List<Auctions> auctions;

if(searchParam != ""){
	
	int searchVal = Integer.parseInt(searchParam);
	auctions = ad.getSpecificSortedAuctions(intValue, searchVal);

}
else{
	auctions = ad.getSortedAuctions(intValue);
}
User user = (User) session.getAttribute("auth"); 

%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<%@include file="includes/navbar.jsp"%>
<body>
	



	<div class="container">
		<div class="card-header my-3">All Auctions
		
		<div class="row justify-content">
		<form class="form-inline" action = "prevAuctions.jsp?uid="<%= user.getUid()%>" method = "get">
      <input type="hidden" name="uid" value="<%= user.getUid() %>">
        <button type="submit" class="btn btn-primary mx-2">
          My Auctions
        </button>
        </form>
        </div>
        <div class="row justify-content-end">
  <div class="col-auto">
    <form class="form-inline" method="post" action = "sort-items">
    <div class="form-group mr-2">
            <input type="text" class="form-control" name="search" placeholder="Search...">
          </div>
      <label for="sort-select" class="mr-2">Sort by:</label>
      <select id="sortBy" name = "sortBy" class="form-control">
        <option value="1">Price (Low to High)</option>
        <option value="2">Price (High to Low)</option>
      </select>
      <button type="Submit" class="btn btn-primary mx-2">Sort</button>
    </form>
  </div>
</div>
		
		
		</div>
		<div id="auctions-container" class="row">
		
		<%
		if( !auctions.isEmpty()){
			for(Auctions a:auctions){%>
			
				<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="images/shopping.jpg" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title" name="pid" >Product ID: <%= a.getPid() %></h5>
						<h6 class = "category">Category: <%= a.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
						<% String link = "place-bid?auctionId="+a.getId(); %>
						<a href=<%= link %> class="btn btn-primary" >View Auction</a>
						</div>
						
					</div>
				</div>


			</div>
			<% }
			
		}
		%>
			
		</div>
	</div>

</body>
</html>