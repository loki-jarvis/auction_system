<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">

		<h1>Create New Auction</h1>

		<div style="width: 50%;">
		<form method="post" action="create-auction">
			
			<div class="form-group">
				<label for="name">Product ID:</label> <input type="number"
					class="form-control" id="pid" name="pid" required>
			</div>
			<div class="form-group">
				<label for="minimum_price">Minimum Price:</label> <input
					type="number" class="form-control" id="minimumPrice"
					name="minimumPrice" step="0.01" required>
			</div>
			<div class="form-group">
				<label for="closing_time">Closing Time:</label> <input
					type="datetime-local" class="form-control" id="closingTime"
					name="closingTime" required>
			</div>
			<div class="form-group">
				<label for="bid_type">Bid Type:</label> <select class="form-control"
					id="bidType" name="bidType" required>
					<option value="">-- Select Bid Type --</option>
					<option value="1">Manual</option>
					<option value="2">Automatic</option>
				</select>
			</div>
			<div class="form-group">
				<label for="upper_limit">Upper Limit:</label> <input type="number"
					class="form-control" id="upperLimit" name="upperLimit"
					>
			</div>
			<div class="form-group">
				<label for="bid_increment">Bid Increment:</label> <input
					type="number" class="form-control" id="bidIncrement"
					name="bidIncrement" >
			</div>
			<div class="form-group">
				<label for="category">Category:</label> <select class="form-control"
					id="category" name="category" required>
					<option value="">-- Select Category --</option>
					<option value="1">Category 1</option>
					<option value="2">Category 2</option>
					<option value="3">Category 3</option>
					<option value="3">Category 4</option>
				</select>
			</div>
			<div class="form-group">
				<label for="user">User:</label> <input type="number"
					class="form-control" id="uid" name="uid" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		</div>

	</div>



</body>
</html>