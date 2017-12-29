<%@page pageEncoding="UTF-8" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
	response.sendRedirect(basePath + "index"); 
%>
<html lang="zh-cn">
<body>
<h2>欢迎来到旅游管理平台！</h2>
</body>
</html>