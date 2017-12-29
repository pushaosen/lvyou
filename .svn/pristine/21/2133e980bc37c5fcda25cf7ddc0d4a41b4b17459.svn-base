<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.Comment"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Comment> comments = (List<Comment>) request.getAttribute("comments");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">评论标题</th>
		<th th:width="200">评论内容</th>
		<th th:width="200">评论时间</th>
		<th th:width="200">评论游客</th>
		<th th:width="200">评论景点</th>
	</tr>
	<%
		for (Comment c : comments) {
			request.setAttribute("c", c);
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="${c.id }%>"
			id="woEmployeeListPanel_${c.id }" /></td>
		<td class="woTableTd">${c.id }</td>
		<td class="woTableTd">${c.title }</td>
		<td class="woTableTd">${c.content }</td>
		<td class="woTableTd">${c.time }</td>
		<td class="woTableTd">${c.guest.name }</td>
		<td class="woTableTd">${c.scene.name }</td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>