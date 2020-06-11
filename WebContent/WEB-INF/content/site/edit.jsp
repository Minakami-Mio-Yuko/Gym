<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="utf-8" />
		<title>场地管理</title>
		<script src="../js/jquery-3.4.1.js"></script>			
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/bootstrap-theme.css" />	
		<script src="../js/bootstrap.js"></script>

	</head>
<body>
<div class="container">
				<div class="row">
				<div class="col-md-12" style="text-align: center;">
					<h1>修改场地</h1>
				</div>
				</div>
				
					<div class="row">
                   <div class="col-md-12" style="height: 100px; text-align: center;">
					   
				   </div>
				   </div>
				   
				   <form action="${pageContext.request.contextPath}/Admin/editsub">
				   <div class="row">
				   <div class="col-md-4" style=" text-align: right;">
				   ID
				   </div>
				  <div class="col-md-4">
				    <input type="text" class="form-control"  value="${detail.siteId}" name="siteId" readonly="readonly"/>
				   </div>
				   </div>
				   				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   	
				   </div>
				   </div>
				   	<div class="row">
				   				   
					   <div class="col-md-4" style=" text-align: right;">
						  名称
						  </div>
						  <div class="col-md-4" style=" text-align: center;">
						  <input type="text" class="form-control"  value="${detail.siteName}" name="siteName">						   
					   </div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   	
				   </div>
				   </div>

				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	位置
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;">
				   	<input type="text" class="form-control"  value="${detail.siteLocation}" name="siteLocation">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	配置
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;">
				   	<input type="text" class="form-control"  value="${detail.siteConfiguration}" name="siteConfiguration">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	租金
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;">
				   	<input type="text" class="form-control"  value="${detail.siteRentprice}" name="siteRentprice">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	押金
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;" >
				   	<input type="text" class="form-control"  value="${detail.siteDepositprice}" name="siteDepositprice">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	状态
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;">
				   	<input type="text" class="form-control"  value="${detail.sitestate.siteCondition}" name="sitestate.siteCondition">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	是否可预约
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;">
				   	<input type="text" class="form-control"  value="${detail.sitestate.siteBook}" name="sitestate.siteBook">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   <div class="col-md-2 offset-5" align="center">
				<button type="submit" class="btn btn-lg btn-primary" role="button" >修改</button> 				
				</div>
				</div>
				   </form>
							
				
   </div>



</body>

</html>