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
    <div class="row">
      <div class="col-md-6">
        <img src="images/shopping.jpg" class="img-fluid" alt="Product Image">
      </div>
      <div class="col-md-6">
        <h1>Product Name: <%= p.getName() %> </h1>
        <p class="text-muted">Product ID:<%= auctions.getPid() %></p>
        <p>Description: <%= p.getDescription() %> </p>
        <p class="text-muted">Current Price: <%= prev_bid.getCurrent_price() %> </p>
        <form  method = "post" action = "place-bid" >
          <div class="form-group">
          	<input type="hidden" id="current_bid" name="current_bid" value=" <%= prev_bid.getCurrent_price() + auctions.getBidIncrement()%> ">
            <input type="hidden" name="pid" value="<%= auctions.getPid() %>">
  			<input type="hidden" name="aid" value="<%= auctions.getId() %>">
          </div>
          <button type="submit" class="btn btn-primary" onclick="showAlert()" >Place bid</button>
        </form>
      </div>
    </div>
 
  
  
  
  
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
      <input type="hidden" name="uid" value="<%= auctions.getUid() %>">
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          View More from Seller
        </button>
        </form>
      </div>
    </div>
   </div>
  
  
  <script>
		function showAlert() {
			alert("Bid Placed Successfully! ");
		}
	</script>

</body>
</html>