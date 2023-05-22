<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List" %>
<%@page import = "cn.auctionsystem.dao.*" %>
<%@ page import = "cn.auctionsystem.connection.*" %>
<%@page import = "com.auctionsystem.model.Category" %>
<%@page import = "com.auctionsystem.model.Product" %>
    
    
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<meta charset="UTF-8">
<title>Add Representative</title>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

<form action="addrepresentative" method="POST">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>
  
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required>
  
  <button type="submit">Submit</button>
</form>

</body>
</html>