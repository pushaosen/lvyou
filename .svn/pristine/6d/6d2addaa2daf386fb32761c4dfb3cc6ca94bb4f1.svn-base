<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.User"%>
<%@ page import="java.util.List"%>
<div>
	<form method="post" class="form-x" id="woUserCreateForm"
	enctype="multipart/form-data">
		<div class="form-group">
			<div class="label">
				<label for="id">ID</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="id" name="id" size="50"
					placeholder="请输入ID" data-validate="required:必填 " value="" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="loginName">登录名</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="loginName" name="loginName" size="50"
					placeholder="请输入名称" data-validate="required:必填 " value="" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="password">密码</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="password" name="password" size="50"
					placeholder="请输入密码" data-validate="required:必填 "  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="headImageFile">头像</label>
			</div>
			<div class="field">
				<a class="button input-file" href="javascript:void(0);">+ 上传头像
	       		 <input size="100" data-validate="required:请选择照片,regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件"
	            	type="file" name="headImageFile" id="headImageFile"/>
	   			 </a>
			</div>
		</div>

		<!-- <div class="form-group">
			<div class="label">
				<label for="headImageFile">头像</label>
			</div>
			<div class="field">
				<a class="button input-file">上传头像<input size="100" type="file"
					name="headImageFile" id="headImageFile" />
				</a>
			</div>
		</div> -->
		<div class="form-button">
			<button class="button bg-main icon-save" type="button"
				onclick="Wobb.submitUserCreateForm();"> 保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();"> 取消</button>
		</div>
	</form>
</div>