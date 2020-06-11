<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../css/bootstrap.min.css" />
        <link rel ="stylesheet" href="../css/equi.css"/>
<title>添加器材</title>

</head>
  <body>
   <div  role="navigation">
  　<div class="navbar-header">
  　    <a href="##" class="navbar-brand">器材添加</a>
  　</div>
   </div>
   
<form  class="text-center" style="background-color: #96b97d;" id="form" method="post" name="admin_equi/add">
   <div class="form-group row" style="padding-top: 100px;font-size: large;">
   	   <div class="left col-lg-5 text-right">
   		    <label class="control-label">器材名称</label>
   	   </div>
   	   <div class="right col-lg-3 ">
   			<input type="text" class="form-control " list="greetings" name="equName"/> 
   			<datalist id="greetings" style="display:none;">
                   <option value="篮球">篮球</option>
                   <option value="足球">足球</option>
                   <option value="羽毛球">羽毛球</option>
            </datalist>

   	   </div>
   </div>
   
   <div class="form-group row" style="padding-top: 10px;font-size: large;">
   	   <div class="left col-lg-5 text-right">
   		    <label class="control-label">预约价格</label>
   	   </div>
   	   <div class="right col-lg-3 ">
   			<input type="number" class="form-control"  oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" name="reservationPrice"/> 
   	   </div>
   </div>
   
   <div class="form-group row" style="padding-top: 10px;font-size: large;">
   	   <div class="left col-lg-5 text-right">
   		    <label class="control-label">租用价格</label>
   	   </div>
   	   <div class="right col-lg-3 ">
   			<input type="number" class="form-control " oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" name="rentPrice"/> 
   	   </div>
   </div>
   
   <div class="form-group row" style="padding-top: 10px;font-size: large;">
   	   <div class="left col-lg-5 text-right">
   		    <label class="control-label">维护价格</label>
   	   </div>
   	   <div class="right col-lg-3 ">
   			<input type="number" class="form-control " oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" name="maintenancePrice"/> 
   	   </div>
   </div>
   
   <div class="form-group row" style="padding-top: 10px;font-size: large;">
   	   <div class="left col-lg-5 text-right">
   		    <label class="control-label">购买价格</label>
   	   </div>
   	   <div class="right col-lg-3 ">
   			<input type="number" class="form-control " oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" name="buyPrice"/> 
   	   </div>
   </div>
   <div class="form-group row" style="padding-top: 10px;padding-bottom:50px; font-size: large;">
       <div class="left col-lg-5 text-right">
   		    <label class="control-label">添加数量</label>
   	   </div>
       <div class="left col-lg-1" align="right">
   			<input type="number" class="form-control " oninput = "value=value.replace(/[^\d]/g,'')" name="newQuantity"/> 
   	   </div>
   	   <div class="left col-lg-2" align="right">
          <button type="button" class="btn btn-primary" style="position: relative;top:0%;transform: translateY(0%);" id="submitBtn" onclick="ajax()">确认添加</button>        	
   	   </div>
   </div>
</form>

    <div class="modal lead" id="mymodal">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="tips"></h4>
			</div>
			<div class="modal-body">
				<p id="tips_content">123</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/interface.js"></script>     
</body>
</html>