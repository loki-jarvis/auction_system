<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<%@page import = "cn.auctionsystem.dao.AuctionsDao" %>
<%@page import = "cn.auctionsystem.dao.ProductDao" %>
<%@page import = "cn.auctionsystem.dao.Product_bidsDao" %>



<%@page import = "com.auctionsystem.model.Auctions" %>
<%@page import = "com.auctionsystem.model.Product" %>
<%@page import = "com.auctionsystem.model.Product_bids" %>



<%@page import="java.util.List" %>
<%@page import = "cn.auctionsystem.connection.DbCon" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manual Auction for Product </title>


<%

AuctionsDao ad = new AuctionsDao(DbCon.getConnection());
int aid = Integer.parseInt(request.getParameter("aid"));
Auctions auctions = ad.getSpecificAuction(aid);

// call products to get specific product details and description

ProductDao pd = new ProductDao(DbCon.getConnection());
int pid = auctions.getPid();
Product p = pd.getSpecificProduct(pid);


// call bid table to get current price.

Product_bidsDao pbid = new Product_bidsDao(DbCon.getConnection());
Product_bids prev_bid = pbid.getLatestBid(aid);

%>



<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

  <div class="container mt-4">
    <div class="row">
      <div class="col-md-6">
        <img src="images/shopping.jpg" class="img-fluid" alt="Product Image">
      </div>
      <div class="col-md-6">
        <h1>Product Name:<%= p.getName() %> </h1>
        <p class="text-muted">Product ID:<%= auctions.getPid() %></p>
        <p>Description: <%= p.getDescription() %> </p>
        <p class="text-muted">Current Price: <%= prev_bid.getCurrent_price() %> </p>
        <form  method = "post" action = "place-bid" >
          <div class="form-group">
            <label for="quantity">Enter your bid amount:</label>
            <input type="number" class="form-control" id="current_bid" name="current_bid" min="<%= prev_bid.getCurrent_price() + 1%>" required>
            <input type="hidden" name="pid" value="<%= auctions.getPid() %>">
  			<input type="hidden" name="aid" value="<%= auctions.getId() %>">
          </div>
          <button type="submit" class="btn btn-primary">Place bid</button>
        </form>
      </div>
    </div>
    
<!-- BELOW CODE FOR BUTTONS -->

   
    <hr>
    
    <div class="row mt-4">
      <div class="col-md-4">
      	<form action = "viewSimilar.jsp?cid=<%= p.getCategory() %>" method = "get">
      	<input type="hidden" name="cid" value="<%= p.getCategory() %>">
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          View Similar
        </button>
        </form>
      </div>
      <div class="col-md-4">
      <form action = "bidHistory.jsp?aid=<%= auctions.getId() %>" method = "get">
      <input type="hidden" name="aid" value="<%= auctions.getId() %>">
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          View Bid History
        </button>
        </form>
      </div>
      <div class="col-md-4">
      <form action = "moreFromSeller.jsp?uid=<%= auctions.getUid() %>>" method = "get">
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          View More from Seller
        </button>
        </form>
      </div>
    </div>




    
  </div>

</body>

</html>