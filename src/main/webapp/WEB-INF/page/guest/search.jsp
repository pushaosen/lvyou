<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Guest"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Guest> guests = (List<Guest>) request.getAttribute("guests");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">游客姓名</th>
		<th th:width="200">性别</th>
		<th th:width="200">出生日期</th>
		<th th:width="200">电话号码</th>
		<th th:width="200">身份证号</th>
	</tr>
	<%
		for (Guest g : guests) {
			request.setAttribute("g", g);
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="${g.id }"
			id="woEmployeeListPanel_${g.id }" /></td>
		<td class="woTableTd">${g.id }</td>
		<td class="woTableTd">${g.name }</td>
		<td class="woTableTd">${g.sex }</td>
		<td class="woTableTd">${g.birthday }</td>
		<td class="woTableTd">${g.mobile }</td>
		<td class="woTableTd">${g.idCard }</td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>