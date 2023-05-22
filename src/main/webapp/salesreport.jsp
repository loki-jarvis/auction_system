<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
	<title>Sales Report</title>
	<style>
		table {
			border-collapse: collapse;
			margin: 20px 0;
			font-size: 14px;
			width: 100%;
		}
		table th, table td {
			padding: 8px;
			text-align: left;
			border: 1px solid #ddd;
		}
		table th {
			background-color: #f2f2f2;
			font-weight: bold;
		}
	</style>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

<div class="container">
	<h2>Total Earnings: $2,630</h2>
	<h3>Earnings Per Product</h3>
	<table>
		<thead>
			<tr>
				<th>Item Name</th>
				<th>Units Sold</th>
				<th>Total Earnings</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Nike Air</td>
				<td>5</td>
				<td>$2,000</td>
			</tr>
			<tr>
				<td>Puma Sports</td>
				<td>1</td>
				<td>$100</td>
			</tr>
			<tr>
				<td>Adidas cap</td>
				<td>2</td>
				<td>$40</td>
			</tr>
			<tr>
				<td>Nike Jordans</td>
				<td>3</td>
				<td>$450</td>
			</tr>
			<tr>
				<td>Reebok sports</td>
				<td>1</td>
				<td>$40</td>
			</tr>
		</tbody>
	</table>
	<h3>Earnings Per Item Type</h3>
	<table>
		<thead>
			<tr>
				<th>Item Type</th>
				<th>Units Sold</th>
				<th>Total Earnings</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Shoes</td>
				<td>8</td>
				<td>$2,450</td>
			</tr>
			<tr>
				<td>Sports</td>
				<td>2</td>
				<td>$140</td>
			</tr>
			<tr>
				<td>Apparel</td>
				<td>2</td>
				<td>$40</td>
			</tr>
		</tbody>
	</table>
	<h3>Earnings Per End-User</h3>
	<table>
		<thead>
			<tr>
				<th>End-User</th>
				<th>Total Earnings</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>User 6</td>
				<td>2,450</td>
			</tr>
			<tr>
				<td>User 2</td>
				<td>$140</td>
			</tr>
			<tr>
				<td>User 3</td>
				<td>$40</td>
			</tr>
		</tbody>
	</table>
	
	<h2>Best Selling Items</h2>
		<table>
			<tr>
				<th>Item</th>
				<th>Sold Quantity</th>
			</tr>
			<tr>
				<td>Nike Air</td>
				<td>5</td>
			</tr>
			<tr>
				<td>Nike Jordans</td>
				<td>3</td>
			</tr>
			<tr>
				<td>Adidas cap</td>
				<td>2</td>
			</tr>
		</table>
	
	<div>
		<h2>Best Buyers</h2>
		<table>
			<tr>
				<th>User</th>
				<th>Purchases</th>
			</tr>
			<tr>
				<td>User 7</td>
				<td>7</td>
			</tr>
			<tr>
				<td>User 2</td>
				<td>5</td>
			</tr>
		</table>
		</div>
		</div>
</body>
</html>
