<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="panel hidden" id="woSceneSearchPanel">
	<div class="panel-head" id="woSceneSearchPanelHeader">
		<span class='icon-times float-right rotate'></span>
		<h4 class="icon-search">&nbsp;查询</h4>
	</div>
	<div class="panel-body padding-small" id="woSceneSearchPanelBody">
		<form onsubmit="return false;" class="form-inline"
			id="woSceneSearchForm">
			<div class="form-group">
				<div class="label">
					<label for="name">&nbsp;&nbsp;&nbsp;&nbsp;景区名称</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="name" name="name"
						 maxlength="50" value="" 
						placeholder="" />
				</div>
			</div>
			<button type="button" class="button button-small bg-main"
				onclick="Wobb.searchScene();"  onfocus="$('#woScenePageStart').val(0)">
				<span class="icon-search text-white">&nbsp;查询</span>
			</button>
		</form>
	</div>
</div>
<div class="panel" id="woSceneListPanel">
	<div class="panel-head" id="woSceneListPanelHeader">
		<!-- woSceneSearchPageForm -->
		<form onsubmit="return false;" id="woSceneSearchPageForm">
			<span class='icon-search float-right' id="woSceneListPanelShowSearch"
				onclick="$('#woSceneSearchPanel').removeClass ('hidden')"></span>
			<!-- <h4>用户列表</h4> -->
			<span> <span class='icon-step-backward'
				onclick="Wobb.loadSceneFirstPage();"> </span> <span
				class='icon-backward' onclick="Wobb.loadSceneLastPage();"></span> <span
				class="text-gray" id="woScenePageText" style="color: black;">景区列表</span>
				<span class='icon-forward' onclick="Wobb.loadSceneNextPage();">
			</span> <span class='icon-step-forward' onclick="Wobb.loadSceneFinalPage();">
			</span> <span class='icon-refresh' onclick="Wobb.searchScene();"></span>
			</span> <input type="hidden" class="input" id="woScenePageStart"
				name="woPageStart" value="0" /> <input type="hidden" class="input"
				id="woScenePageSize" name="woPageSize" value="10" />
		</form>
	</div>
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woSceneListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选" />
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle"
					onclick="Wobb.loadSceneCreateForm();">
					<span>创建</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle"
					onclick="Wobb.loadSceneUpdateForm();">
					<span>修改</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle"
					onclick="Wobb.deleteScenes ();">
					<span>删除</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle"
					onclick="Wobb.loadSceneImportForm ();">
					<span>导入</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle"
					onclick="Wobb.exportScenes();">
					<span>导出</span>
				</button>
			</div>
			<div id="woSceneListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<jsp:include page="search.jsp"></jsp:include>
			</div>
		</form>
	</div>
</div>