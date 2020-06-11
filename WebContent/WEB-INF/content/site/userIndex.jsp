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
		欢迎您
		</h1>		
		<div class="container" style="background: white;">
			<form action="${pageContext.request.contextPath}/user/likequery">
			<div class="row">				
				<div class="col-md-4" align="center">
					<span style="font-family: "黑体";">是否可预约:</span>
					&nbsp;
					<select class="selectpicker" title="请选择" name="book">
					<option value="是">是</option>
					<option value="否">否</option>
					</select>					
				</div>
				<div class="col-md-4" align="center">
					<span style="font-family: "黑体";">名称:</span>&nbsp;
					<input type="text" name="name"/>				
				</div>
				<div class="col-md-2" align="center">
				<button type="submit" class="btn btn-primary" role="button" >查询</button> 				
				</div>
				
				<div class="col-md-2" align="center">
				<a href="${pageContext.request.contextPath}/user/myorder"  class="btn btn-primary" role="button" >我的订单</a> 				
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
							<th>名称</th>
							<th>位置</th>
							<th>配置</th>
							<th>租金</th>
							<th>押金</th>
							<th>状态</th>
							<th>是否可预约</th>
							<th>操作</th>
						</tr>		
					</thead>
					<c:forEach var="detail" items="${list}">	
						<tr>
							<td align="center">${detail.siteId}</td>
							<td align="center">${detail.siteName}</td>
							<td align="center">${detail.siteLocation}</td>
							<td align="center">${detail.siteConfiguration}</td>
							<td align="center">${detail.siteRentprice}</td>
							<td align="center">${detail.siteDepositprice}</td>
							<td align="center">${detail.sitestate.siteCondition}</td>
							<td align="center"><c:choose><c:when test="${detail.sitestate.siteBook==1}">可预约</c:when><c:otherwise>不可预约</c:otherwise></c:choose></td>
							<td align="center"><p> <a href="${pageContext.request.contextPath}/user/book?id=${detail.siteId}" class="btn btn-sm btn-primary" >预约</a></p></td>
						</tr>
						</c:forEach>
					</table>
					</div>				
				</div>				
			</div>		
	</body>
</html>