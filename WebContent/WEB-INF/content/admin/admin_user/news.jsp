<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广东海洋大学体育馆管理系统</title>
<link rel="stylesheet"
	href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script src="../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="../css/page_main.css" />
</head>

<body>
	<nav class="navbar navbar-default" role="navigation" id="nav">
	<ul class="nav navbar-nav">
		<li id="logo"><a disabled>广东海洋大学体育馆管理系统-管理员平台</a></li>
		<li class="li_user  clicked"><a href="../admin_user">用户管理</a></li>
		<li class="li_comp"><a href="../admin_comp">赛事管理</a></li>
		<li class="li_area"><a href="../admin_area">场地管理</a></li>
		<li class="li_equi"><a href="../admin_equi">器材管理</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<%
			HttpSession s = request.getSession();
		%>
		<li><a> 当前在线： <%=s.getAttribute("username")%></a></li>
	</ul>
	</nav>
	<div class="row">
		<div class="col-md-2 text-center center-block">
			<ul class="verticalnav">
				<li><a href="../admin_user/delete">删除账号</a></li>
				<li><a href="../admin_user/recovery">恢复账号</a></li>
				<li><a href="../admin_user/right">权限管理</a></li>
				<li><a href="../admin_user/news" class="current">发布公告</a></li>
				<li><a href="../admin_user/info">个人信息</a></li>
				<li><a href="../logout">退出登录</a></li>
			</ul>
		</div>
			<div class="col-md-10  center-block"><br/>
			<div class="container">
			    <h3>温馨提示：所有公告按发布时间降序排序</h3>		
 				<h3>温馨提示：公告标题限制20字符，内容限制100字符</h3>				
			</div>
			<form class="form-horizontal" action="newsAdd" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">标题:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="newsTitle" value="标题">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">内容:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="newsContent" value="内容">
					</div>
				</div>
				
	            <%
	            TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
	            TimeZone.setDefault(tz) ;
	            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	            %>
	            
				<div class="form-group">
					<input type="hidden" name="newsWriter" value="<%=s.getAttribute("userName")%>" readonly>
					<input type="hidden" name="newsDate"   value="<%=date %>" readonly>
					<button type="submit" class="btn btn-success btn-block ">确 认 发 出</button>
				</div>
			</form><hr style=" height:5px;border-top: 2px ridge white;" />
			<h3 style="color:red;" class="text-center">
			<%=s.getAttribute("messageUserNewsAdd")%></h3>

			<%
			for(int i=0;i<Integer.valueOf(s.getAttribute("newsCountAll").toString());i++){
				if(s.getAttribute("userNews" + i + "deleteA").equals("已删除仅管理员可见")){
			%>
				<table class="table table-bordered" id="news" style="background:#eee">
				<%
				}else{
				%>
				<table class="table table-bordered" id="news">
				<%
				}
				%>
				<tr>
					<td>标题</td>
					<td><%=s.getAttribute("userNews"+i+"titleA")%></td>
					<td rowspan="2">

				         <form action="newsChange" class="form-horizontal" method="post">
				<%
                   if(s.getAttribute("userNews" + i + "deleteA").equals("已删除仅管理员可见")){
			    %>		      
				<button type="submit" class="btn btn-success btn-block">恢复</button>
				<%
                   }else{
				%>
				<button type="submit" class="btn btn-danger btn-block">删除</button>
				<%
                   }
				%>
                               
                                <input type="hidden" class="form-control" name="newsDelete"
								readonly value="<%=s.getAttribute("userNews" + i + "deleteA")%>">
							    <input type="hidden" class="form-control" name="newsID"
								readonly value="<%=s.getAttribute("userNews" + i + "idA")%>">
								
								<h5><%=s.getAttribute("userNews" + i + "deleteA")%></h5>
				         </form>				
                    </td>
				</tr>								
				<tr>
					<td>内容</td>
					<td><%=s.getAttribute("userNews"+i+"contentA")%></td>
				</tr>
			</table>
			<%
			}
			%>
		</div>
	</div>
</body>


</html>