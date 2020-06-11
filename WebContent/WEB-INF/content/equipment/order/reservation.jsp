<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript"  charset="UTF-8" src="../js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>  
        <link rel="stylesheet"  charset="UTF-8" href="../css/bootstrap.min.css" />
                <link rel ="stylesheet" href="../css/equi.css"/>
        <title>reservation</title>
    </head >
    <body>
       <div role="navigation" >
  　 <div class="navbar-header">
       <a href="##" class="navbar-brand">器材预约</a>
     <ul class="nav navbar-nav"> 
	 	<li><a href="#form" >器材列表</a></li>      	
	 </ul>
  　</div>
     </div>  
     
     <div>
       <form style="padding-top:70px;">
         <table class="table text-nowrap table-hover lead" >
           <tr>
             <th style="width:450px;">请输入租用日期：<input id="date" style="height:30px;" onfocus="WdatePicker({readOnly:true,minDate:'%y-%M-{%d+1}'})" /></th>
             <th style="width:450px;">时间段：
             <select id="time"  style="height:30px;padding-top: 1px;padding-bottom: 1px">  
                      <option>上午(8:00—12:00)</option>
                      <option>下午(13:00——17:00)</option>
                      <option>晚上(18:00——22:00)</option>
                      <option>1天</option>
                      <option>2天</option>
                      <option selected="selected"></option>
              </select>
             </th>
             <th><input type="button" class="btn btn-primary" onclick="ajax_reservation_query()" value=查询空闲器材    /></th>
           </tr>
         </table>
       </form>
     </div>
 
  <div >
         <form id="form" name="users_equi/res_query" method="post">
  			<table class="table text-nowrap table-hover " id="reservation_tb">
				<tr id="reservation_tr">
					<th style="padding-left: 50px;">器材名称</th>
					<th style="padding-left: 50px;">预约价格</th>
					<th style="padding-left: 50px;">租用价格</th>
					<th style="padding-left: 50px;">损坏赔偿价格</th>
					<th style="padding-left: 50px;">遗失赔偿价格</th>
					<th style="padding-left: 50px;">剩余数量</th>
					<th style="padding-left: 50px;">预约数量</th>
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
<script type="text/javascript" charset="UTF-8" src="../js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src="../js/interface.js"></script> 
<script type="text/javascript" charset="UTF-8" src="../js/reservation.js"></script> 
</html>