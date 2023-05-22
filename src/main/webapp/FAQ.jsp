<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="cn.auctionsystem.dao.QuestionsDao"%>
<%@page import="com.auctionsystem.model.Question"%>
<%@page import="cn.auctionsystem.model.User"%>
<%@page import="cn.auctionsystem.connection.DbCon"%>
<%@page import="java.util.*"%>

<%
QuestionsDao qd = new QuestionsDao(DbCon.getConnection());

List<Question> question = qd.getAllQuestions();

User user = (User) session.getAttribute("auth");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>



	<div id="auctions-container" class="row">

		<%
		if (!question.isEmpty()) {
			for (Question q : question) {
		%>

		<div class="col-md-3 my-3">
			<div class="card w-100" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title" name="pid">
						Question:
						<%=q.getQuestion()%></h5>
					<h6 class="category">
						Answer:
						<%=q.getAnswer()%></h6>
				</div>
			</div>


		</div>
		<%
		}

		}
		%>

		<%
		if (user != null) {
		%>

		<form action="FAQ" method="post">
			<div class="form-group">
				<label for="question">Add Question:</label> <input type="text"
					class="form-control" id="question" name="question" required>
			</div>
			<input type="hidden" id="user_id" name="user_id"
				value="<%=user.getUid()%>">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

		<%
		}
		%>

	</div>






</body>
</html>