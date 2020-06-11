<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript"  charset="UTF-8" src="../js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>  
        <link rel="stylesheet"  charset="UTF-8" href="../css/bootstrap.min.css" />
                <link rel ="stylesheet" href="../css/equi.css"/>
        <title>return</title>
    </head >
    <body onload="onload_ajax_return()">
       <div role="navigation" >
  　 <div class="navbar-header">
       <a href="##" class="navbar-brand">器材归还</a>
     <ul class="nav navbar-nav"> 
	 	<li><a href="#form" >订单列表</a></li>      	
	 </ul>
  　</div>
     </div>  
     
 
  <div >
         <form id="form" name="users_equi/return_query" method="post" style="padding-top: 70px">
  			<table class="table text-nowrap table-hover " id="return_tb">
				<tr id="return_tr">
					<th style="padding-left: 50px;">订单号</th>
					<th style="padding-left: 50px;">器材</th>
					<th style="padding-left: 50px;">预约费用</th>
					<th style="padding-left: 50px;">预约时间</th>
					<th style="padding-left: 50px;">租借费用</th>
					<th style="padding-left: 50px;">租借时间</th>
					<th style="padding-left: 50px;">归还时间</th>
					<th style="padding-left: 50px;"></th>
				</tr>
			</table>
       </form>
    <div class="modal lead" id="mymodal">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="tips"></h4>
			</div>
			<div class="modal-body" id="modal_body">
				<p id="tips_content"></p>
			</div>
			<div class="modal-footer" id="modelButton">
				<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

    <div class="modal lead" id="confirm_modal">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="confirm_tips"></h4>
			</div>
			<div class="modal-body" id="confirm_modal_body">
				<p id="tips_content"></p>
			</div>
			<div class="modal-footer" id="confirm_model_button">
				<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
 </body>
<script type="text/javascript" charset="UTF-8" src="../js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src="../js/interface.js"></script> 
<script type="text/javascript" charset="UTF-8" src="../js/return.js"></script> 
</html>