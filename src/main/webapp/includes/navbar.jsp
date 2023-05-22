
<%@page import="cn.auctionsystem.model.*" %>

<% User auth = (User) request.getSession().getAttribute("auth"); 
	if(auth != null){
		request.setAttribute("auth", auth);
	}

%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="#">RU Auction Ready?</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="FAQ.jsp">FAQ</a>
				</li>
				
				
				<%
				
				if(auth != null){%>
				
				<li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
				
				<%
				}
				else
				{
				%>
				

				<li class="nav-item "><a class="nav-link" href="newLogin.jsp">Login</a>
				</li>

				<li class="nav-item "><a class="nav-link" href="signup.jsp">Signup</a></li>
				
				<% 
				} 
				%>
				

			</ul>

		</div>
	</div>
</nav>