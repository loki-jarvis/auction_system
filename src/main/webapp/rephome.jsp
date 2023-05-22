<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="cn.auctionsystem.dao.QuestionsDao"%>
<%@page import="com.auctionsystem.model.Question"%>
<%@page import="cn.auctionsystem.model.User"%>
<%@page import="cn.auctionsystem.connection.DbCon"%>
<%@page import="java.util.*"%>

<%
QuestionsDao qd = new QuestionsDao(DbCon.getConnection());

List<Question> question = qd.getUnansweredQuestions();
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



	<div id="auctions-container" class="row">

		<%
		if (!question.isEmpty()) {
			for (Question q : question) {
		%>

		<div class="col-md-3 my-3 mx-3">
			<div class="card w-100" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title" >
						Question:
						<%=q.getQuestion()%></h5>
					<h6 class="category" style="display: inline-block">
						Answer:
						<%=q.getAnswer()%></h6>
					<form action="answerQuestion.jsp?id=<%=q.getId()%>>"
						method="get">
						<input type="hidden" name="id" value="<%=q.getId()%>">
						<button type="submit"
							class="btn btn-outline-secondary btn-lg btn-block">Answer this question</button>
					</form>
				</div>
			</div>
		</div>

		<%
		}

		}
		%>


	</div>
	
	
	  <hr>
    
    <div class="row mt-4">
      <div class="col-md-4">
      	<form  method = "get">
      	<input type="hidden" name="cid">
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          Edit User Information
        </button>
        </form>
      </div>
      <div class="col-md-4">
      <form  method = "get">
      <input type="hidden" name="aid" >
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          Edit/Remove Bids
        </button>
        </form>
      </div>
      <div class="col-md-4">
      <form  method = "get">
      <input type="hidden" name="uid" >
        <button type="submit" class="btn btn-outline-secondary btn-lg btn-block">
          Edit/Remove Auctions
        </button>
        </form>
      </div>
    </div>


</body>
</html>