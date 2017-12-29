<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.User"%>
<%@ page import="java.util.List"%>
<div>
	<form method="post" class="form-x" id="woSceneCreateForm"
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
				<label for="name">景区名称</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="name" name="name" size="20"
					placeholder="请输入名称" data-validate="required:必填 " value="" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="description">描述</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="description" name="description" size="50"
					placeholder="请输入地址" data-validate="required:必填 "  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="sex">是否对外开放</label>
			</div>
			<div class="field">
				<!-- <input type="text" class="input" id="sex" name="open" size="2"
					placeholder="请输入性别" /> -->
					<input type="radio" id="open" name="open"
					placeholder="" value="1" checked="checked" />是
					<input type="radio" id="open" name="open"
					placeholder="" value="2"/>否
					
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="address">地址</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="address" name="address" size="50"
					placeholder="请输入地址" data-validate="required:必填 "  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="telephone">联系电话</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="telephone" name="telephone" maxlength="20"	
			placeholder="请输入联系电话" data-validate="required:必填 "  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="headImageFile">图片</label>
			</div>
			<div class="field">
				<a class="button input-file" href="javascript:void(0);">+ 上传图片
	       		 <input size="100" data-validate="regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件"
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
				onclick="Wobb.submitSceneCreateForm();"> 保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();"> 取消</button>
		</div>
	</form>
</div>