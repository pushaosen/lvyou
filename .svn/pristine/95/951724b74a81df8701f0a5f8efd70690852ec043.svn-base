<%@ page pageEncoding="utf-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit" />
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css" />
<link rel="stylesheet" href="<%=basePath%>css/wo.engine.css" />
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/jquery.form.min.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<script src="<%=basePath%>js/respond.js"></script>
<script src="<%=basePath%>js/wo.engine.js"></script>
<script>
	$(document).ready(function() {
		pintuer();
		$(document).on('click', WoKit.hideDropMenu);
	});
</script>
<link type="image/x-icon" href="http://www.pintuer.com/favicon.ico"
	rel="shortcut icon" />
<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>
<body>
	<div class="container">
		<div class="line">
			<div class="xs6 xm3 xs3-move xm4-move">
				<br /> <br />
				<br /> <br />
				<br /> <br />
				<br /> <br />
				<form id="sysLoginForm" method="post" class="form-x" action="<%=basePath%>authenticate">
					<div class="panel">
						<div class="panel-head">
							<strong>登录后台</strong>
						</div>
						<div class="panel-body" style="padding: 30px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input" name="user"
										placeholder="登录账号"
										data-validate="required:请填写账号,length#>=3:账号长度不符合要求" /> <span
										class="icon icon-user"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input" name="password"
										placeholder="登录密码"
										data-validate="required:请填写密码,length#>=6:密码长度不符合要求" /><span
										class="icon icon-key"></span>
								</div>
							</div>
						</div>
						<div class="panel-foot text-center">
							<button class="button button-block bg-main text-big" type='submit'>立即登录</button>
							<span class="text-red">${error}</span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>