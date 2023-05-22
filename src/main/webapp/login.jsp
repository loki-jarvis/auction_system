<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cs336.pkg.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction System</title>
<link rel="stylesheet" media="screen" href="../css/style.css">
<%@include file="includes/header.jsp"%>
</head>

<body>
<%@include file = "includes/navbar.jsp" %>

	<section class="vh-100" style="background-color: #508bfc;">
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-12 col-md-8 col-lg-6 col-xl-5">
				<div class="card shadow-2-strong" style="border-radius: 1rem;">
					<div class="card-body p-5 text-center">

						<h3 class="mb-5">
							<img
								src="data:image/png;base64,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">
						</h3>

						<form method="post" action="validate.jsp">
							<!-- note the show.jsp will be invoked when the choice is made -->
							<!-- The next lines give HTML for radio buttons being displayed -->
							<%
							// Check if the login failed
							if (session.getAttribute("login_failed") == "false") {
								out.print("<p>Login failed. Please try again.</p>");
								session.removeAttribute("login_failed");
							}
							%>

							<div class="form-outline mb-4">
								<input type="text" name="username" value="username"
									id="typeEmailX-2" class="form-control form-control-lg" /> <label
									class="form-label" for="typeEmailX-2">Email</label>
							</div>

							<div class="form-outline mb-4">
								<input type="password" name="password" value="password"
									id="typePasswordX-2" class="form-control form-control-lg" /> <label
									class="form-label" for="typePasswordX-2">Password</label>
							</div>

							<!-- Checkbox -->

							<button class="btn btn-primary btn-lg btn-block" type="submit"
								value="submit">Login</button>




							<!--  <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;"
              type="submit"><i class="fab fa-google me-2"></i> Sign in with google</button>
            <button class="btn btn-lg btn-block btn-primary mb-2" style="background-color: #3b5998;"
              type="submit"><i class="fab fa-facebook-f me-2"></i>Sign in with facebook</button>
			-->
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>


</body>
</html>
