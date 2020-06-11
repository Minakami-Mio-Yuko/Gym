<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">		
<title>用户</title>

         <script src="../js/jquery-3.4.1.js"></script>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<script src="../js/bootstrap.js"></script>	
</head>
	<body style="background: #E6E6FA;">
		<h1 style="color: #004085;" align="center">
		我的订单
		</h1>		
		<div class="container" style="background: white;">
			<form action="${pageContext.request.contextPath}/user/likequery">
			<div class="row">				
				<div class="col-md-4" align="center">
			
				</div>
				<div class="col-md-4" align="center">
			
				</div>
				<div class="col-md-2" align="center">
			
				</div>
				
				<div class="col-md-2" align="center">
			
				</div>
				
				</div>
				</form>
				<div class="row">
					<div class="col-md-12"style="height: 20px;">
												
					</div>					
				</div>
				
				<div class="row">
					<div class="col-md-12">
					<table style="width: 100%;" class="table table-striped table-hover table-bordered" >
					<thead>
						<tr>						
							<th>Id</th>
							<th>场地名称</th>
							<th>起始时间</th>
							<th>结束时间</th>
							<th>下单时间</th>
							<th>租金</th>
							<th>押金</th>
						</tr>		
					</thead>
					<c:forEach var="order" items="${list}">	
						<tr>
							<td align="center">${order.orderId}</td>
							<td align="center">${order.siteDetail.siteName}</td>
							<td align="center">${order.orderStarttime}</td>
							<td align="center">${order.orderEndtime}</td>
							<td align="center">${order.orderBooktime}</td>
							<td align="center">${order.orderRentprice}</td>
							<td align="center">${order.orderDepositprice}</td>													
						</tr>
						</c:forEach>
					</table>
					</div>				
				</div>				
			</div>		
	</body>
</html>