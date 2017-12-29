<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.User"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	User u = (User) request.getAttribute("user");
%>
<div>
	<form method="post" class="form-x" id="woUserUpdateForm" enctype="multipart/form-data">
		<div class="form-group">
			<div class="label">
				<label for="id">ID</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="id" name="id" size="50"
					placeholder="请输入ID" data-validate="required:必填 "
					value="<%=u.getId()%>" readonly="readonly" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="loginName">登录名</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="loginName" name="loginName" size="50"
					placeholder="请输入名称" data-validate="required:必填 "
					value="<%=u.getLoginName()%>" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="password">密码</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="password" name="password" size="50"
					placeholder="请输入密码" data-validate="required:必填 "
					value="<%=u.getPassword()%>" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="headImageFile">头像</label>
			</div>
			<div class="field">
				<a class='x12' href="<%=basePath + u.getHeadImage()%>"
					target="_blank"> <img src="<%=basePath + u.getHeadImage()%>"
					class="radius" alt="暂无图片"></img>
				</a><a class="button input-file" onclick="$(this).next().val('-1');">+浏览图片 
				<input size="100" data-validate="required:请选择照片,regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件"
	            	type="file" name="headImageFile" id="headImageFile"/>
				</a> <input type="hidden" name="headImageClick" value="" />
				<input type="hidden" name="headImage" value="<%=u.getHeadImage() %>" />
			</div>
		</div>
		<div class="form-button">
			<button class="button bg-main icon-save" type="button"
				onclick="Wobb.submitUserUpdateForm();">保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();">取消</button>
		</div>
	</form>
</div>