<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	int day = (int)request.getAttribute("day");

%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/oneday.css" />
<h1><%=day %>일</h1>
<div id="oneday-container">

<div id="todolist">
	<h2>To do List</h2>
</div>
<div id="middleLine"></div>

<div id="timeline">
	<h2>TimeLine</h2>
</div>
</div>
</body>
</html>