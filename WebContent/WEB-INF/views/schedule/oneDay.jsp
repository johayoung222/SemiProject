<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");

%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/oneday.css" />
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<h1><%=day %>일</h1>
<h2><%=year %>년 <%=month %>월 <%=day %>일 user님의 작성</h2>
<div id="oneday-container">
	<form action="<%=request.getContextPath() %>/schedule/insertSchedule" id="boardInfo" name="insertFrm" method="post">
		<input type="hidden" name="year" value="<%=year %>"/>
		<input type="hidden" name="month" value="<%=month %>"/>
		<input type="hidden" name="day" value="<%=day %>"/>
		<input type="hidden" name="user" value="user"/>
	</form>

<div id="todolist">
	<h2>To do List</h2>
	<div id="insertBoard">+</div>
</div>
<div id="middleLine"></div>

<div id="timeline">
	<h2>TimeLine</h2>
</div>
</div>
<script>
$("#insertBoard").click(function(){
	insertFrm.submit();
});
</script>
</body>
</html>