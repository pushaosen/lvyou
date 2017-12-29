<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itqf.lvyou.model.TicketRecord"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<TicketRecord> ticketrecords = (List<TicketRecord>) request.getAttribute("ticketrecords");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">票据说明</th>
		<th th:width="200">售票时间</th>
		<th th:width="200">票类型</th>
		<th th:width="200">购票用户</th>
		<th th:width="200">售票员</th>
	</tr>
	<%
		for (TicketRecord t : ticketrecords) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=t.getId()%>"
			id="woEmployeeListPanel_<%=t.getId()%>" /></td>
		<td class="woTableTd"><%=t.getId()%></td>
		<td class="woTableTd"><%=t.getInstruction()%></td>
		<td class="woTableTd"><%=t.getTime()%></td>
		<td class="woTableTd"><%=t.getTickettype().getName()%></td>
		<td class="woTableTd"><%=t.getGuest().getName()%></td>
		<td class="woTableTd"><%=t.getEmployee().getEmployName()%></td>
		
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>