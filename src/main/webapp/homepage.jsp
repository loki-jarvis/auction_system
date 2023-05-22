<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cs336.pkg.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Homepage</title>
		<link rel="stylesheet" media="screen" href="../css/style.css">
		<%@include file = "includes/header.jsp" %>
	</head>
	<body style="background-color: #508bfc;">
	<%@include file = "includes/navbar.jsp" %>
		<%
		if(   (session.getAttribute("name") )!=null   ){
		String name = session.getAttribute("name").toString();
		//if (name!=null)
			//out.print("Welcome "+name);
			//out.print("");
		//else
			//out.print("Error Retrieving User Details");
		//out.print("\nYou are now logged in");
		}
		else{
			response.sendRedirect("login.jsp");
		}
		%>
		
		
	
<section class="vh-100" style="background-color: #508bfc;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5"> Welcome ${name} </h3>
            <form method="post" action="logout.jsp">
	  	<input type="submit" class="btn btn-primary" value="Logout" />
		</form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
		
		
		
		
		
		
		
		
		
		
		
		
	</body>
</html>