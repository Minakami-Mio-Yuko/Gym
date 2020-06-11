<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广东海洋大学体育馆管理系统</title>
<script src="../jquery-3.4.1.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script src="../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="../css/page_main.css" />
</head>

<body>
	<nav class="navbar navbar-default" role="navigation" id="nav">
	<ul class="nav navbar-nav">
		<li id="logo"><a disabled>广东海洋大学体育馆管理系统-用户平台</a></li>
		<li class="li_user clicked"><a href="../users_user">用户相关</a></li>
		<li class="li_comp"><a href="../users_comp">赛事相关</a></li>
		<li class="li_area"><a href="../users_area">场地相关</a></li>
		<li class="li_equi"><a href="../users_equi">器材相关</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<%HttpSession s = request.getSession();%>
		<li><a> 当前在线： <%=s.getAttribute("username")%>
		</a></li>
	</ul>
	</nav>
	<div class="row">
		<div class="col-md-2 text-center center-block">
			<ul class="verticalnav">
				<li><a href="../users_user/change">修改密码</a></li>
				<li><a href="../users_user/info">个人信息</a></li>
				<li><a href="../users_user/news" class="current" >系统公告</a></li>
				<li><a href="../logout">退出登录</a></li>
			</ul>
		</div>
		<div class="col-md-10 center-block"></br>				
			<table class="table table-bordered" id="infoLatest">
				<tr>
					<th colspan="2" color="red" class="text-center">最新公告</th>
				</tr>
				<tr>
					<td>标题</td>
					<td><%=s.getAttribute("userNews0title")%></td>
				</tr>								
				<tr>
					<td>内容</td>
					<td><%=s.getAttribute("userNews0content")%></td>
				</tr>
				<tr>
					<td>作者：<%=s.getAttribute("userNews0writer")%></td>
					<td>发布时间：<%=s.getAttribute("userNews0date")%></td>
				</tr>

			</table>
			<%
			for(int i=0;i<Integer.valueOf(s.getAttribute("newsCount").toString());i++){
			%>
			<table class="table table-bordered" id="info">
				<tr>
					<td>标题</td>
					<td><%=s.getAttribute("userNews"+i+"title")%></td>
				</tr>								
				<tr>
					<td>内容</td>
					<td><%=s.getAttribute("userNews"+i+"content")%></td>
				</tr>
				<tr>
					<td>作者：<%=s.getAttribute("userNews"+i+"writer")%></td>
					<td>发布时间：<%=s.getAttribute("userNews"+i+"date")%></td>
				</tr>
			</table>
			<%
			}
			%>			
	    </div>
	</div>
</body>

</html>