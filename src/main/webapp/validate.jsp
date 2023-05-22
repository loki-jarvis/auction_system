<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cs336.pkg.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<% try {
	
			//Get the database connection
			ApplicationDB db = new ApplicationDB();	
			Connection con = db.getConnection();		

			//Create a SQL statement
			Statement stmt = con.createStatement();
			//Get the selected radio button from the index.jsp
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//Make a SELECT query from the table specified by the 'command' parameter at the index.jsp
			String str = "SELECT email, Name FROM user where email= '" + username + "' and password='"+password+"'";
			out.print(str);
			//Run the query against the database.
			ResultSet result = stmt.executeQuery(str);
		%>
			
		<!--  Make an HTML table to show the results in: -->
		<%
		if (result.next()) {

              String uid = result.getString("Name");

              HttpSession sess=request.getSession();  
              sess.setAttribute("name", uid);


              response.sendRedirect("homepage.jsp");  // No need to add whole URL unless this is in another Folder.
            } else {
            	HttpSession sess=request.getSession();  
                sess.setAttribute("login_failed", "false");
              response.sendRedirect("login.jsp");
            }
		%>	
		<%} catch (Exception e) {
			out.print(e);
		}%>
	

	</body>
</html>