<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="cn.auctionsystem.dao.AuctionsDao"%>
<%@page import="com.auctionsystem.model.Auctions"%>


<%@page import="java.util.List"%>
<%@page import="cn.auctionsystem.connection.DbCon"%>


<%
AuctionsDao ad = new AuctionsDao(DbCon.getConnection());
int cid = Integer.parseInt(request.getParameter("cid"));
List<Auctions> auctions = ad.getSimilarAuctions(cid);
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


	<div class="container">

		<div class="card-header my-3">
			Similar Auctions

			<div id="auctions-container" class="row">

				<%
				if (!auctions.isEmpty()) {
					for (Auctions a : auctions) {
				%>

				<div class="col-md-3 my-3">
					<div class="card w-100" style="width: 18rem;">
						<img class="card-img-top" src="images/shopping.jpg"
							alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title" name="pid">
								Product ID:
								<%=a.getPid()%></h5>
							<h6 class="category">
								Category:
								<%=a.getCategory()%></h6>
							<div class="mt-3 d-flex justify-content-between">
								<%
								String link = "place-bid?auctionId=" + a.getId();
								%>
								<a href=<%=link%> class="btn btn-primary">View Auction</a>
							</div>

						</div>
					</div>


				</div>
				<%
				}

				}
				%>

			</div>

		</div>
	</div>

</body>
</html>