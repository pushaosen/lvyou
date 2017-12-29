var Wobb = {};

Wobb.loadLoginOptions = function (loginName, roleId) {
	WoAjaxKit.load({
		domSelector : '#woUserOptions',
		url : WoKit.basePath + 'loadLoginOptions?roleId=' + roleId + '&loginName=' + loginName
	});
};

Wobb.loadUserCreateForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/user/loadCreateForm'
	});
};

Wobb.loadUserImportForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/user/loadImportForm'
	});
};

Wobb.exportUsers = function() {
	var data = WoKit.getFormData('#woUserSearchForm');
	//window.open(WoKit.basePath + 'sys/user/export?loginName='+ data.loginName);
	window.open(WoKit.basePath + 'sys/user/export?loginName='+ data['loginName']);
};

Wobb.exportEmployees = function() {
	var data = WoKit.getFormData('#woEmployeeSearchForm');
	//window.open(WoKit.basePath + 'sys/user/export?loginName='+ data.loginName);
	window.open(WoKit.basePath + 'sys/employee/export?employName='+ data['employName'] +'&phone=' + data['phone'] +'&idCard=' +data['idCard']);
};

Wobb.loadEmployeeImportForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'ly/employee/loadImportForm'
	});
};

Wobb.loadEmployeeCreateForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'ly/employee/loadCreateForm'
	});
};

Wobb.submitForm = function(cfg) {
	WoAjaxKit.submitForm(cfg.domSelector, {
		type : "post",
		dataType : "json",
		validateForm : true,
		url : WoKit.basePath + cfg.url,
		success : function(json) {
			WoKit.showInfo(json.msg);
			if (json.code == 1) {
				WoKit.destroyMainFrame();
				if (cfg.success) {
					cfg.success(json);
				}
			}
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
			if (XmlHttpRequest.responseJSON) {
				WoKit.showWarn(XmlHttpRequest.responseJSON.message);
			} else {
				WoKit.showWarn('提交失败！');
			}
		}
	});
};

Wobb.submitUserCreateForm = function() {
	Wobb.submitForm({
		domSelector : '#woUserCreateForm',
		url : 'sys/user/create',
		success : Wobb.searchUser
	});
};

Wobb.submitUserImportForm = function() {
	Wobb.submitForm({
		domSelector : '#woUserImportForm',
		url : 'sys/user/import',
		success : Wobb.searchUser
	});
};

Wobb.submitEmployeeImportForm = function() {
	Wobb.submitForm({
		domSelector : '#woEmployeeImportForm',
		url : 'sys/employee/import',
		success : Wobb.searchEmployee
	});
};

Wobb.submitEmployeeCreateForm = function() {
	Wobb.submitForm({
		domSelector : '#woEmployeeCreateForm',
		url : 'sys/employee/create',
		success : Wobb.searchEmployee
	});
};

Wobb.loadUserUpdateForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个用户！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/user/loadUpdateForm?userId=' + id
	});
};

Wobb.loadEmployeeUpdateForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个员工！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/employee/loadUpdateForm?employeeId=' + id
	});
};

Wobb.submitUserUpdateForm = function() {
	Wobb.submitForm({
		domSelector : '#woUserUpdateForm',
		url : 'sys/user/update',
		success : Wobb.searchUser
	});
};

Wobb.submitEmployeeUpdateForm = function() {
	Wobb.submitForm({
		domSelector : '#woEmployeeUpdateForm',
		url : 'sys/employee/update',
		success : Wobb.searchEmployee
	});
};

Wobb.deleteUsers = function() {
	var ids = WoKit.getListSelectedIds('#woUserListPanelHeaderForm');
	if (WoKit.isEmpty(ids)) {
		WoKit.showWarn('请选择至少一个用户！');
		return;
	}
	WoKit.showConfirm('确认删除选中的用户吗？', function() {
		WoAjaxKit.requestJson({
			url : WoKit.basePath + 'sys/user/delete?userIds=' + ids,
			success : Wobb.searchUser
		});
	});
};

Wobb.deleteEmployees = function() {
	var ids = WoKit.getListSelectedIds('#woEmployeeListPanelHeaderForm');
	if (WoKit.isEmpty(ids)) {
		WoKit.showWarn('请选择至少一个员工！');
		return;
	}
	WoKit.showConfirm('确认删除选中的员工吗？', function() {
		WoAjaxKit.requestJson({
			url : WoKit.basePath + 'sys/employee/delete?employeeIds=' + ids,
			success : Wobb.searchEmployee
		});
	});
};

Wobb.searchUser = function () {
	// 获取查询参数 : {loginName : ''}
	//查找id以woUserSearch开头的form
	var data = WoKit.getFormData("form[id^='woUserSearch']");
	// 加载html覆盖列表body
	WoAjaxKit.load({
		domSelector : '#woUserListPanelBody',
		url : WoKit.basePath + 'sys/user/search',
		data : data
	});
};

Wobb.searchEmployee = function () {
	// 获取查询参数 : {loginName : ''}
	var data = WoKit.getFormData('#woEmployeeSearchForm');
	// 加载html覆盖列表body
	WoAjaxKit.load({
		domSelector : '#woEmployeeListPanelBody',
		url : WoKit.basePath + 'sys/employee/search',
		data : data
	});
};

Wobb.showSearchForm = function () {
	// 显示查询视图层
	$('#woUserSearchPanel').removeClass ('hidden');
};

Wobb.loadMenuCreateForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/menu/loadCreateForm'
	});
};

Wobb.submitMenuCreateForm = function() {
	Wobb.submitForm({
		domSelector : '#woMenuCreateForm',
		url : 'sys/menu/create',
		success : Wobb.searchMenu
	});
};

Wobb.loadMenuUpdateForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个菜单！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/menu/loadUpdateForm?menuId=' + id
	});
};

Wobb.submitMenuUpdateForm = function() {
	Wobb.submitForm({
		domSelector : '#woMenuUpdateForm',
		url : 'sys/menu/update',
		success : Wobb.searchMenu
	});
};

// 创建子菜单按钮点击事件
Wobb.loadMenuCreateChildForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个菜单作为父菜单！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/menu/loadCreateChildForm?parentId=' + id
	});
};

Wobb.submitMenuChildForm = function() {
	Wobb.submitForm({
		domSelector : '#woMenuCreateChildForm',
		url : 'sys/menu/create',
		success : Wobb.searchMenu
	});
};

Wobb.deleteMenus = function() {
	var ids = WoKit.getListSelectedIds('#woMenuListPanelHeaderForm');
	if (WoKit.isEmpty(ids) || ids.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个菜单！');
		return;
	}
	WoKit.showConfirm('确认删除选中的菜单吗？', function() {
		WoAjaxKit.requestJson({
			url : WoKit.basePath + 'sys/menu/delete?menuId=' + ids,
			success : Wobb.searchMenu
		});
	});
};

Wobb.searchMenu = function () {
	// 获取查询参数 : {loginName : ''}
	var data = WoKit.getFormData('#woMenuSearchForm');
	// 加载html覆盖列表body
	WoAjaxKit.load({
		domSelector : '#woMenuListPanelBody',
		url : WoKit.basePath + 'sys/menu/search',
		data : data
	});
};

Wobb.loadRoleRelatedMenusList = function () {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个角色！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/role/loadRoleRelatedMenusList?roleId=' + id
	});
};

Wobb.setRoleRelatedMenus = function (roleId) {
	var menuIds = WoKit.getListSelectedIds('#woMenuListPanelHeaderForm');
	WoAjaxKit.requestJson({
		url : WoKit.basePath + 'sys/role/setRelatedMenus',
		data : {
			'menuIds' : menuIds,
			'roleId' : roleId
		},
		success : function () {
			WoKit.destroyMainFrame();
		}
	});
};

Wobb.deleteRoles = function() {
	var ids = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(ids)) {
		WoKit.showWarn('请选择至少一个角色！');
		return;
	}
	WoKit.showConfirm('确认删除选中的角色吗？', function() {
		WoAjaxKit.requestJson({
			url : WoKit.basePath + 'sys/role/delete?roleIds=' + ids
		});
	});
};

Wobb.loadGuardianRelationList = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个宝贝！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'wobb/baby/loadGuardianRelations?babyId=' + id
	});
};

Wobb.loadGuardianRelationListByGuardian = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个监护人！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'wobb/guardian/loadGuardianRelationsg?guardianId=' + id
	});
};

// 以下是实现分页的相关操作
Wobb.loadUserNextPage = function(){
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woUserPageStart').val());
	var pageSize = parseInt($('#woUserPageSize').val());
	if(pageStart < Wobb.totalUsers - pageSize){
		// 计算分页参数
		pageStart += pageSize;
	}
	// 设置分页参数
	$('#woUserPageStart').prop('value', pageStart);
	// 或者
	// $('#woUserPageStart').attr('value', pageStart);
	// 提交
	Wobb.searchUser();
}

Wobb.loadUserLastPage = function(){
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woUserPageStart').val());
	var pageSize = parseInt($('#woUserPageSize').val());
	if(pageStart != 0){
		// 计算分页参数
		pageStart -= pageSize;
	}
	// 设置分页参数
	$('#woUserPageStart').prop('value', pageStart);
	// 或者
	// $('#woUserPageStart').attr('value', pageStart);
	// 提交
	Wobb.searchUser();
}

Wobb.loadUserFirstPage = function(){
	// 设置分页参数
	$('#woUserPageStart').prop('value', 0);
	// 或者
	// $('#woUserPageStart').attr('value', pageStart);
	// 提交
	Wobb.searchUser();
}

Wobb.loadUserFinalPage = function(){
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woUserPageStart').val());
	var pageSize = parseInt($('#woUserPageSize').val());
	// 计算分页参数
	var end = Wobb.totalUsers % pageSize;
	if(end != 0){
		pageStart = Wobb.totalUsers - end;
	}else{
		pageStart = Wobb.totalUsers - pageSize;
	}
	// 设置分页参数
	$('#woUserPageStart').prop('value', pageStart);
	// 或者
	// $('#woUserPageStart').attr('value', pageStart);
	// 提交
	Wobb.searchUser();
}

// 用户保存用户总数
// Wobb.totalUsers = 0;

//角色列表中的设置菜单按钮的点击响应事件
Wobb.loadRoleRelatedMenuList = function() {
	var id = WoKit.getListSelectedIds('#woRoleListPanelHeaderForm');
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个角色！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/role/loadRelatedMenuList?roleId=' + id
	});
};

Wobb.submitRoleRelatedMenus = function(roleId) {
	var ids = WoKit.getListSelectedIds('#woMenuListPanelHeaderForm');
	if (WoKit.isEmpty(ids)) {
		WoKit.showWarn('请至少选择一个菜单！');
		return;
	}
	// 发送ajax-json请求，传入角色ID及多个菜单ID
	WoAjaxKit.requestJson({
		url : WoKit.basePath + 'sys/role/relatedMenus?roleId=' + roleId +'&menuIds=' +ids,
		success : WoKit.destroyMainFrame
	});
};

// 景区信息的导入导出
Wobb.loadSceneImportForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'ly/scene/loadImportForm'
	});
};

Wobb.submitSceneImportForm = function() {
	Wobb.submitForm({
		domSelector : '#woSceneImportForm',
		url : 'ly/scene/import',
		success : Wobb.searchUser
	});
};

Wobb.exportScenes = function() {
	var data = WoKit.getFormData('#woSceneSearchForm');
	//window.open(WoKit.basePath + 'sys/user/export?loginName='+ data.loginName);
	window.open(WoKit.basePath + 'ly/scene/export?name='+ data['name']);
};

Wobb.searchScene = function () {
	// 获取查询参数 : {loginName : ''}
	//查找id以woUserSearch开头的form
	var data = WoKit.getFormData("form[id^='woSceneSearch']");
	// 加载html覆盖列表body
	WoAjaxKit.load({
		domSelector : '#woSceneListPanelBody',
		url : WoKit.basePath + 'ly/scene/search',
		data : data
	});
};

Wobb.loadSceneCreateForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'ly/scene/loadCreateForm'
	});
};

Wobb.submitSceneCreateForm = function() {
	Wobb.submitForm({
		domSelector : '#woSceneCreateForm',
		url : 'ly/scene/create',
	    success : Wobb.searchScene
	});
};

Wobb.loadSceneNextPage = function(){
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woScenePageStart').val());
	var pageSize = parseInt($('#woScenePageSize').val());
	if(pageStart < Wobb.totalScenes - pageSize){
		// 计算分页参数
		pageStart += pageSize;
	}
	// 设置分页参数
	$('#woScenePageStart').prop('value', pageStart);
	Wobb.searchScene();
}

Wobb.loadSceneLastPage = function(){
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woScenePageStart').val());
	var pageSize = parseInt($('#woScenePageSize').val());
	if(pageStart != 0){
		// 计算分页参数
		pageStart -= pageSize;
	}
	// 设置分页参数
	$('#woScenePageStart').prop('value', pageStart);
	Wobb.searchScene();
}

Wobb.loadSceneFirstPage = function(){
	// 设置分页参数
	$('#woScenePageStart').prop('value', 0);
	Wobb.searchScene();
}

Wobb.loadSceneFinalPage = function(){
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woScenePageStart').val());
	var pageSize = parseInt($('#woScenePageSize').val());
	// 计算分页参数
	var end = Wobb.totalScenes % pageSize;
	if(end != 0){
		pageStart = Wobb.totalScenes - end;
	}else{
		pageStart = Wobb.totalScenes - pageSize;
	}
	// 设置分页参数
	$('#woScenePageStart').prop('value', pageStart);
	Wobb.searchScene();
}