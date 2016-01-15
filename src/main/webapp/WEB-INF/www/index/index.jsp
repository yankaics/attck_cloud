<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Attck Cloud - 自动化攻击云平台</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet"
	href="<%=basePath%>libs/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=basePath%>libs/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="<%=basePath%>libs/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=basePath%>libs/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="<%=basePath%>libs/plugins/iCheck/square/blue.css">
<style>
.login {
	width: 90%;
	margin: auto;
}

.login-page, .register-page {
	background: #fff;
}
</style>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>Attck </b>Cloud
		</div>
		<div class="login-box-body">
			<!-- <p class="login-box-msg">Sign in to start your session</p> -->
			<form action="<%=basePath%>login.html" method="post">
				<div class="form-group has-feedback">
					<input type="email" class="form-control" placeholder="Email"
						name="username"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password"
						name="passwd"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">

					<div class="login">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script src="<%=basePath%>libs/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="<%=basePath%>libs/bootstrap/js/bootstrap.min.js"></script>
	<script>
		
	</script>
</body>
</html>
