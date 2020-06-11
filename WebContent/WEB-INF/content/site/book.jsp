<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="utf-8" />
		<title>欢迎您</title>
		<script src="../js/jquery-3.4.1.js"></script>			
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/bootstrap-theme.css" />	
		<script src="../js/bootstrap.js"></script>
        <script src="../js/My97DatePicker/WdatePicker.js"></script>
	</head>
<body>
<div class="container">
				<div class="row">
				<div class="col-md-12" style="text-align: center;">
					<h1>订单预约</h1>
				</div>
				</div>
				
					<div class="row">
                   <div class="col-md-12" style="height: 50px; text-align: center;">
					   
				   </div>
				   </div>
				   				<div class="row">
					<div class="col-md-12">
					<table style="width: 100%;" class="table table-striped table-hover table-bordered" >
					<thead>
						<tr>						
	                        <th>当前场地已被预约开始时间</th>
	                        <th>当前场地已被预约结束时间</th>
						</tr>		
					</thead>
					<c:forEach var="order" items="${list}">	
						<tr>
							<td align="center">${order.orderStarttime}</td>
							<td align="center">${order.orderEndtime}</td>
						</tr>
						</c:forEach>
					</table>
					</div>				
				</div>	
								   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   	
				   </div>
				   </div>
				   <form action="${pageContext.request.contextPath}/user/insertorder" >
				   
				   <div class="row">
				   <div class="col-md-4" style=" text-align: right;">
				   Id
				   </div>
				   						  <div class="col-md-4" style=" text-align: center;">
						  <input type="text" class="form-control"  value="${param.id}"  name="id" readonly="readonly"/>						   
					   </div>
				   </div>
				   								   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   	
				   </div>
				   </div>
				   	<div class="row">
				   				   
					   <div class="col-md-4" style=" text-align: right;">
						  开始时间
						  </div>
						  <div class="col-md-4" style=" text-align: center;">
						  <input class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="starttime"/>					   
					   </div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   	
				   </div>
				   </div>

				   <div class="row">
				   				
				   	<div class="col-md-4" style=" text-align: right;">
				   	结束时间
				   	</div>
				   	<div class="col-md-4" style=" text-align: center;">
				   	<input class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="endtime"/>						   
				   	</div>				   
				   </div>
				   <div class="row">
				   <div class="col-md-12" style="height: 15px; text-align: center;">
				   
				   </div>
				   </div>

				   <div class="row">
				   <div class="col-md-2 offset-5" align="center">
				<button type="submit" class="btn btn-lg btn-primary" role="button" >预约</button> 				
				</div>
				</div>
				   </form>
							
				
   </div>



</body>

</html>