<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Employee"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
Employee e = (Employee) request.getAttribute("employee");
%>
<div>
	<form method="post" class="form-x" id="woEmployeeUpdateForm" enctype="multipart/form-data">
		<div class="form-group">
			<div class="label">
				<label for="id">ID</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="id" name="id" size="50"
					placeholder="请输入ID" data-validate="required:必填 "
					value="<%=e.getId()%>" readonly="readonly" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="employName">员工姓名</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="employName" name="employName" size="20" required="required"
					placeholder="请输入姓名" data-validate="required:必填 " value="<%=e.getEmployName()%>" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="sex">性别</label>
			</div>
			<div class="field">
		<% if(e.getSex().equals("1")){ %>
			
					<input type="radio" id="sex" name="sex"
					placeholder="" value="1" checked="checked" />男
					<input type="radio" id="sex" name="sex"
					placeholder="" value="2"/>女
					
			
		<%}else{ %>
					<input type="radio" id="sex" name="sex"
					placeholder="" value="1"  />男
					<input type="radio" id="sex" name="sex" 
					placeholder="" value="2" checked="checked"/>女
		<%} %>
		
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="card">员工号</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="card" name="card" size="50" required="required"
					placeholder="请输入员工号" data-validate="required:必填 "  value="<%=e.getNo()%>" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="phone">联系电话</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="phone" name="phone" maxlength="11" pattern="[\\d]{11}" required="required"
					placeholder="请输入联系电话" data-validate="required:必填 " value="<%=e.getMobile()%>"  />
			</div>
		</div>
		
		<div class="form-group">
			<div class="label">
				<label for="idCard">身份证</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="idCard" name="idCard" maxlength="18"
					placeholder="请输入身份证号"  value="<%=e.getIdCard()%>"/>
			</div>
		</div>
		
		<%-- <div class="form-group">
			<div class="label">
				<label for="position">职务</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="position" name="position" size="20"
					placeholder="请输入职务" data-validate="required:必填 " value="<%=e.getPosition()%>" />
			</div>
		</div> --%>
		
		
		<div class="form-group">
			<div class="label">
				<label for="position">职务</label>
			</div>
			<div class="field">
					<select id="position" name="position" data-validate="required:必填 ">
					<option value="<%=e.getPosition()%>"><%=e.getPosition()%></option>
					<option value="1">主管</option>
					<option value="2">副主管</option>
					<option value="3">普通员工</option>
					<option value="4">售票员</option>
				</select>
			</div>
		</div>
		
	<!-- 		<div class="form-group">
			<div class="label">
				<label for="headImageFile">头像</label>
			</div>
			<div class="field">
				<a class="button input-file" href="javascript:void(0);">+ 上传头像
	       		 <input size="100" data-validate="required:请选择照片,regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件"
	            	type="file" name="headImageFile" id="headImageFile"/>
	   			 </a>
			</div>
		</div> -->
		
		
		<div class="form-group">
			<div class="label">
				<label for="headImageFile">头像</label>
			</div>
			<div class="field">
				<a class='x12' href="<%=basePath + e.getHeadImage()%>"
					target="_blank"> <img src="<%=basePath + e.getHeadImage()%>"
					class="radius" alt="暂无图片"></img>
				</a><a class="button input-file" onclick="$(this).next().val('-1');">+浏览图片
				 <input size="100" data-validate="required:请选择照片,regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件"
	            	type="file" name="headImageFile" id="headImageFile"/>
				</a> <input type="hidden" name="headImageClick" value="" />
				<input type="hidden" name="headImage" value="<%=e.getHeadImage() %>" />
			</div>
		</div>
		<div class="form-button">
			<button class="button bg-main icon-save" type="button"
				onclick="Wobb.submitEmployeeUpdateForm();">保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();">取消</button>
		</div>
	</form>
</div>