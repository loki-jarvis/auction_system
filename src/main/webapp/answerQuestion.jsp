<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import = "cn.auctionsystem.dao.QuestionsDao" %>

<%@page import="java.util.List" %>
<%@page import = "cn.auctionsystem.connection.DbCon" %>  
<%@page import = "com.auctionsystem.model.Question" %>
    
<%


int id = Integer.parseInt(request.getParameter("id"));

QuestionsDao qd = new QuestionsDao(DbCon.getConnection());

Question q = qd.getSpecificQuestion(id);



%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Answer Question</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>


<div class="card">
  <div class="card-body">
    <h5 class="card-title">Question: <%= q.getQuestion() %></h5>
    <p class="card-text">Posted by: <%= q.getUid() %></p>
    <p class="card-text">Posted on: <%= q.getQ_post_time() %></p>
    <form action="answer-question" method="post">
      <div class="form-group">
        <label for="answerTextArea">Answer:</label>
        <textarea class="form-control" id="answerTextArea" rows="3" name="answer" required></textarea>
      </div>
      <input type="hidden" name="questionId" value="<%= q.getId() %>">
      <button type="submit" class="btn btn-primary">Answer</button>
    </form>
  </div>
</div>




</body>
</html>