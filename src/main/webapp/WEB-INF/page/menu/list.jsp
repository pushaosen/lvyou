<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Menu"%>
<%@ page import="java.util.List"%>
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
			<h4>菜单列表</h4>
		</form>
	</div>
	
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woMenuListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选"/>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadMenuCreateForm();">
					<span>创建</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadMenuCreateChildForm();">
					<span>创建子菜单</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadMenuUpdateForm();">
					<span>修改</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle" onclick="Wobb.deleteMenus ();">
					<span>删除</span>
				</button>
			</div>
			<div id="woMenuListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<jsp:include page="search.jsp"></jsp:include>
			</div>
		</form>
	</div>
</div>