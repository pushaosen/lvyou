<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.User"%>
<%@ page import="com.itqf.lvyou.model.PageBean"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	PageBean<User> pgUsers = (PageBean<User>) request.getAttribute("pgUsers");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th width="300">ID</th>
		<th th:width="200">登录名</th>
		<th th:width="200">创建时间</th>
	</tr>
	<%
		for (User u : pgUsers.getList()) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=u.getId()%>"
			id="woUserListPanel_<%=u.getId()%>" /></td>
		<td class="woTableTd"><%=u.getId()%></td>
		<td class="woTableTd"><%=u.getLoginName()%></td>
		<td class="woTableTd"><%=String.valueOf(u.getCreateTime()).replace(".0", "")%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>

<script type="text/javascript">
	Wobb.totalUsers = <%=pgUsers.getTotal()%>;
</script>