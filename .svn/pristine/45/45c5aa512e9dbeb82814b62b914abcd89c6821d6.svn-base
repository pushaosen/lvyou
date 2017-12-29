<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.User"%>
<%@ page import="java.util.List"%>
<div>
	<form method="post" class="form-x" id="woEmployeeCreateForm"
	enctype="multipart/form-data">
		<div class="form-group">
			<div class="label">
				<label for="id">ID</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="id" name="id" size="50" required="required"
					placeholder="请输入ID" data-validate="required:必填 " value="" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="employName">员工姓名</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="employName" name="employName" size="20" required="required"
					placeholder="请输入姓名" data-validate="required:必填 " value="" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="sex">性别</label>
			</div>
			<div class="field">
				<!-- <input type="text" class="input" id="sex" name="sex" size="2"
					placeholder="请输入性别" /> -->
					<input type="radio" id="sex" name="sex"
					placeholder="" value="1" checked="checked" />男
					<input type="radio" id="sex" name="sex"
					placeholder="" value="2"/>女
					
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="no">员工号</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="no" name="no" size="50" required="required"
					placeholder="请输入员工号" data-validate="required:必填 "  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="mobile">联系电话</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="mobile" name="mobile" maxlength="11" pattern="[\\d]{11} " 	
			placeholder="请输入联系电话,length#=11:电话长度不符合要求" data-validate="required:必填 "  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="idCard">身份证</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="idCard" name="idCard" maxlength="18"
					placeholder="请输入身份证号,length#=18:身份证长度不符合要求"  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="position">职务</label>
			</div>
			<div class="field">
					<select id="position" name="position" data-validate="required:必填 ">
					<option value="1">主管</option>
					<option value="2">副主管</option>
					<option value="3">普通员工</option>
					<option value="4">售票员</option>
				</select>
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
				onclick="Wobb.submitEmployeeCreateForm();"> 保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();"> 取消</button>
		</div>
	</form>
</div>