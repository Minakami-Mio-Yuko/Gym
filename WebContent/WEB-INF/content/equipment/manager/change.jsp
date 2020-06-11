<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript"  charset=UTF-8" src="../js/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet"  charset=UTF-8" href="../css/bootstrap.min.css" />
                <link rel ="stylesheet" href="../css/equi.css"/>
        <title>equ_update</title>
    </head >
    <body  onload="onload_ajax_update()" >
       <div role="navigation" >
  　 <div class="navbar-header">
       <a href="##" class="navbar-brand">器材修改</a>
     <ul class="nav navbar-nav"> 	
	 	<li><a href="#form" >器材列表</a></li>      	
	 </ul>
  　</div>
     </div>
  <div >
         <form id="form" name="admin_equi/equ_update" method="post"style="padding-top:70px;">
  			<table class="table text-nowrap table-hover " id="update_tb">
				<tr id="update_tr">
					<th style="padding-left: 50px;">编号</th>
					<th style="padding-left: 50px;">器材名称</th>
					<th style="padding-left: 50px;">损坏情况</th>
					<th style="padding-left: 50px;">预约价格</th>
					<th style="padding-left: 50px;">租用价格</th>
					<th style="padding-left: 50px;">维护价格</th>
					<th style="padding-left: 50px;">购买价格</th>
					<th style="padding-left: 50px;"></th>
				</tr>
					
			</table>
       </form>
  
  </div>
  
    <div >
         <form id="form" name="admin_equi/equ_update_group" method="post"style="padding-top:70px;">
  			<table class="table text-nowrap table-hover " id="update_group_tb">
				<tr id="update_group_tr">
					<th style="padding-left: 50px;">器材名称</th>
					<th style="padding-left: 50px;">预约价格</th>
					<th style="padding-left: 50px;">租用价格</th>
					<th style="padding-left: 50px;">器材数量</th>
					<th style="padding-left: 50px;"></th>
				</tr>
					
			</table>
       </form>
  
  </div>

    <div class="modal lead" id="mymodal">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="tips"></h4>
			</div>
			<div class="modal-body">
				<p id="tips_content"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
 </body>
 	<script type="text/javascript"  charset="UTF-8" src="../js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src="../js/interface.js"></script> 
<script type="text/javascript" charset="UTF-8" src="../js/equ_update.js"></script> 
</html>