<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎使用广东海洋大学体育馆管理系统</title>
		<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		<link rel="stylesheet" href="css/page_index.css" />
	</head>

	<body>
		<div class="container">
			<h1>
			广东海洋大学体育馆管理系统
		</h1>
		</div>

		<div class="container">
			<br />
			<form class="form-horizontal" role="form" action="login" method="post">
				<h2><center><font color="red">                       
				${requestScope.messageLogin} 
				</font></center></h2>
				<div class="form-group">
					<label for="loginname" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" value="201611701223" 
						id="loginname" name="loginname" placeholder="请输入账号">
					</div>
				</div>

				<div class="form-group">
					<label for="loginpass" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control"
						 value="201611701223" 
						id="loginpass" name="loginpass" placeholder="请输入密码">
					</div>
				</div>

				<div class="form-group">
					<label for="loginrole" class="col-sm-2 control-label">角色</label>
					<div class="col-sm-10">
						<label class="radio-inline"> <input type="radio"
						name="loginrole" id="loginrole" value="0">非管理员
					</label> <label class="radio-inline"> <input type="radio"
						name="loginrole" id="loginrole" value="1" checked>管理员
					</label>
					</div>

				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-info btn-block">登 录</button>
				</div>
			</form>

		</div>

		<div class="container">
			<br />
			<form class="form-horizontal" role="form" action="register" method="post">
				<h2><center><font color="red"> 
				${requestScope.messageRegister } 
				</font></center></h2>

				<div class="form-group">
					<label for="registername" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" 
						id="registername" name="registername" placeholder="请输入账号">
					</div>
				</div>

				<div class="form-group">
					<label for="registerpass1" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" 
						id="registerpass1" name="registerpass1" placeholder="请输入密码">
					</div>
				</div>

				<div class="form-group">
					<label for="registerpass2" class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" 
						id="registerpass2" name="registerpass2" placeholder="请输入密码">
					</div>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-info btn-block">注 册</button>
				</div>
				<h2><center><font color="red"> 
					${requestScope.messageRegisterSuccess }
				</center></font></h2>
			</form>

		</div>
		<div class="container">
		<h3>温馨提示1：密码不能为空且长度在12个字符以内</h3>
		<h3>温馨提示2：仅本校学工号可作为账号进行登录注册</h3>
		<h3>温馨提示3：默认密码即为学工号</h3>
		</div>

	</body>

</html>