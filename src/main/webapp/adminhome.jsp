<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List" %>
<%@page import = "cn.auctionsystem.dao.*" %>
<%@ page import = "cn.auctionsystem.connection.*" %>
<%@page import = "com.auctionsystem.model.Category" %>
<%@page import = "com.auctionsystem.model.Product" %>
    
<% 

CategoryDao cd = new CategoryDao(DbCon.getConnection());
List<Category> categories = cd.getAllCategories();


ProductDao pd = new ProductDao(DbCon.getConnection());
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



<button onclick="location.href='http://localhost:8080/cs336Sample/addrepresentative';">Add Representative</button>
<button onclick="location.href='http://localhost:8080/cs336Sample/generatesalesreport';">Generate Sales Report</button>


<div class="container">

		<div class="card-header my-3">All Categories</div>
		<div class="row">
		
		<%
		if( !categories.isEmpty()){
			for(Category c:categories){%>
			
				<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="images/shopping.jpg" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%= c.getName() %></h5>
						<h6 class = "id">ID: <%= c.getId() %></h6>
						<h6 class = "description">Description: <%= c.getDescription() %></h6>						
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