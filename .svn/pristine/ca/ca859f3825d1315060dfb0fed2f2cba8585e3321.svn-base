<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.TicketType"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<TicketType> ticketTypes = (List<TicketType>) request.getAttribute("ticketTypes");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">票据名称</th>
		<th th:width="200">票价</th>
		<th th:width="200">所属景区</th>
	</tr>
	<%
		for (TicketType t : ticketTypes) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=t.getId()%>"
			id="woEmployeeListPanel_<%=t.getId()%>" /></td>
		<td class="woTableTd"><%=t.getId()%></td>
		<td class="woTableTd"><%=t.getName()%></td>
		<td class="woTableTd"><%=t.getPrice()%></td>
		<td class="woTableTd"><%=t.getScene().getName()%></td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>