<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Advice"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Advice> advices = (List<Advice>) request.getAttribute("advices");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">投诉标题</th>
		<th th:width="200">投诉内容</th>
		<th th:width="200">投诉时间</th>
		<th th:width="200">投诉游客</th>
		<th th:width="200">投诉景点</th>
	</tr>
	<%
		for (Advice a : advices) {
			request.setAttribute("a", a);
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="${a.id }"
			id="woEmployeeListPanel_${a.id }" /></td>
		<td class="woTableTd">${a.id }</td>
		<td class="woTableTd">${a.title }</td>
		<td class="woTableTd">${a.content }</td>
		<td class="woTableTd">${a.time }</td>
		<td class="woTableTd">${a.guest.name }</td>
		<td class="woTableTd">${a.scene.name }</td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>