<%@page import="com.itqf.lvyou.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Role"%>
<%@ page import="com.itqf.lvyou.model.PageBean" %>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Role> roles = (List<Role>) request.getAttribute("roles");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th width="200">ID</th>
		<th width="200">姓名</th>
		<th width="*">描述</th>
	</tr>
	<%
		for (Role r : roles) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=r.getId()%>"
			id="woUserListPanel_<%=r.getId()%>" /></td>
		<td class="woTableTd"><%=r.getId()%></td>
		<td class="woTableTd"><%=r.getName()%></td>
		<td class="woTableTd"><%=r.getDescription()%></td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>
<!-- <script> -->
<%-- 	Wobb.totalUsers=<%=users.getTotal()%>; --%>
<!-- </script> -->