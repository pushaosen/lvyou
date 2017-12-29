<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Site"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Site> sites = (List<Site>) request.getAttribute("sites");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">景点名称</th>
		<th th:width="200">景点描述</th>
		<th th:width="200">景点地址</th>
		<th th:width="200">所属景区</th>
		<th th:width="200">对外开放</th>
	</tr>
	<%
		for (Site s : sites) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=s.getId()%>"
			id="woEmployeeListPanel_<%=s.getId()%>" /></td>
		<td class="woTableTd"><%=s.getId()%></td>
		<td class="woTableTd"><%=s.getName()%></td>
		<td class="woTableTd"><%=s.getDescription()%></td>
		<td class="woTableTd"><%=s.getPlace()%></td>
		<td class="woTableTd"><%=s.getScene().getName()%></td>
		<td class="woTableTd"><%=s.getOpen()%></td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>