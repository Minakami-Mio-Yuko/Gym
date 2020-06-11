<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
					<h1>新建场地</h1>
				</div>
				</div>
				
					<div class="row">
                   <div class="col-md-12" style="height: 100px; text-align: center;">
					   
				   </div>
				   </div>
				   
				   <form action="${pageContext.request.contextPath}/Admin/newsub" >
				   	<div class="row">
				   				   
					   <div class="col-md-4" style=" text-align: right;">
						  名称
						  </div>
						  <div class="col-md-4" style=" text-align: center;">
						  <input type="text" class="form-control"  placeholder="名称" name="siteName">						   
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
				   	<input type="text" class="form-control"  placeholder="位置" name="siteLocation">						   
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
				   	<input type="text" class="form-control"  placeholder="配置" name="siteConfiguration">						   
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
				   	<input type="text" class="form-control"  placeholder="租金" name="siteRentprice">						   
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
				   	<input type="text" class="form-control"  placeholder="押金" name="siteDepositprice">						   
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
				   	<input type="text" class="form-control"  placeholder="状态" name="sitestate.siteCondition">						   
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
				   	<input type="text" class="form-control"  placeholder="是否可预约" name="sitestate.siteBook">						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>
				   <div class="row">
				   <div class="col-md-2 offset-5" align="center">
				<button type="submit" class="btn btn-lg btn-primary" role="button" >新建</button> 				
				</div>
				</div>
				   </form>
							
				
   </div>



</body>

</html>