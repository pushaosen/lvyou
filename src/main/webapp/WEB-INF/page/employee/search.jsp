<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Employee"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">员工姓名</th>
		<th th:width="200">性别</th>
		<th th:width="200">工号</th>
		<th th:width="200">电话</th>
		<th th:width="200">身份证</th>
		<th th:width="200">职务</th>
	</tr>
	<%
		for (Employee e : employees) {
			request.setAttribute("e", e);
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="${e.id }"
			id="woEmployeeListPanel_${e.id }" /></td>
		<td class="woTableTd">${e.id }</td>
		<td class="woTableTd">${e.employName }</td>
		<td class="woTableTd">${e.sex }</td>
		<td class="woTableTd">${e.no }</td>
		<td class="woTableTd">${e.mobile }</td>
		<td class="woTableTd">${e.idCard }</td>
		<td class="woTableTd">${e.position }</td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>