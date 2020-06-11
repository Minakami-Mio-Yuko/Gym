<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广东海洋大学体育馆管理系统</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="css/page_main.css" />
</head>

<body>
	<nav class="navbar navbar-default" role="navigation" id="nav">
	<ul class="nav navbar-nav">
		<li id="logo"><a disabled>广东海洋大学体育馆管理系统-管理员平台</a></li>
		<li class="li_user  clicked"><a href="admin_user">用户管理</a></li>
		<li class="li_comp"><a href="admin_comp">赛事管理</a></li>
		<li class="li_area"><a href="admin_area">场地管理</a></li>
		<li class="li_equi"><a href="admin_equi">器材管理</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<%
			HttpSession s = request.getSession();
		%>
		<li><a> 当前在线： <%=s.getAttribute("username")%>
		</a></li>
	</ul>
	</nav>
	<div class="row">
		<div class="col-md-2 text-center center-block">
			<ul class="verticalnav">
				<li><a href="admin_user/delete">删除账号</a></li>
				<li><a href="admin_user/recovery">恢复账号</a></li>
				<li><a href="admin_user/right">权限管理</a></li>
				<li><a href="admin_user/news">发布公告</a></li>
				<li><a href="admin_user/info">个人信息</a></li>
				<li><a href="logout">退出登录</a></li>
			</ul>
		</div>
		<div class="col-md-10"></div>
	</div>
</body>
</html>