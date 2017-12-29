<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Menu"%>
<%@ page import="com.itqf.lvyou.model.Role"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	Role role=(Role) request.getAttribute("role");
	List<Menu> roleMenu = (List<Menu>)request.getAttribute ("reletedMenus");
	List<Menu> menus = (List<Menu>) request.getAttribute("menus");
%>
<div class="panel hidden" id="woMenuSearchPanel">
	<div class="panel-head" id="woMenuSearchPanelHeader">
		<span class='icon-times float-right rotate'></span>
		<h4 class="icon-search">&nbsp;查询</h4>
	</div>
	<div class="panel-body padding-small" id="woMenuSearchPanelBody">
		<form onsubmit="return false;" class="form-inline" id="woMenuSearchForm">
			<div class="form-group">
				<div class="label">
					<label for="name">&nbsp;&nbsp;&nbsp;&nbsp;名称</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="name" name="name"
						maxlength="50" value="" placeholder="" />
				</div>
			</div>
			<button type="button" class="button button-small bg-main"
				onclick="Wobb.searchMenu();">
				<span class="icon-search text-white">&nbsp;查询</span>
			</button>
		</form>
	</div>
</div>
<div class="panel" id="woMenuListPanel">
	<div class="panel-head" id="woMenuListPanelHeader">
		<form onsubmit="return false;">
			<span class='icon-search float-right' id="woMenuListPanelShowSearch" onclick="$('#woMenuSearchPanel').removeClass ('hidden')"></span>
			<h4>角色[<%=role.getName() %>]的关联菜单列表</h4>
		</form>
	</div>
	
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woMenuListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选"/>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="WoKit.destroyMainFrame();">
					<span>取消</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle" onclick="Wobb.submitRoleRelatedMenus ('<%=role.getId() %>');">
					<span>确定</span>
				</button>
			</div>
			<div id="woMenuListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">名称</th>
		<th th:width="*">URL</th>
		<th th:width="200">上级</th>
	</tr>
	<%
		for (Menu m : menus) {
			String parentName = m.getParent() == null ? "" : m.getParent().getName();
	%>
	<tr>
	<td style="text-align: center"><input type="checkbox"
	name="woSelectedIds" value="<%=m.getId()%>"
	id="woUserListPanel_<%=m.getId()%>" <%=m.isIn(roleMenu)?"checked='checked'":"" %>/></td>
		
		<td class="woTableTd"><%=m.getId()%></td>
		<td class="woTableTd"><%=m.getName()%></td>
		<td class="woTableTd"><%=m.getUrl()%></td>
		<td class="woTableTd"><%=parentName%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>
			</div>
		</form>
	</div>
</div>