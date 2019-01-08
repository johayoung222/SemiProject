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
	<div id="scroll-box">
		<div id="time0">00시</div>
		<div id="time1">01시</div>
        <div id="time2">02시</div>
        <div id="time3">03시</div>
        <div id="time4">04시</div>
        <div id="time5">05시</div>
        <div id="time6">06시</div>
        <div id="time7">07시</div>
        <div id="time8">08시</div>
        <div id="time9">09시</div>
        <div id="time10">10시</div>
        <div id="time11">11시</div>
        <div id="time12">12시</div>
        <div id="time13">13시</div>
        <div id="time14">14시</div>
        <div id="time15">15시</div>
        <div id="time16">16시</div>
        <div id="time17">17시</div>
        <div id="time18">18시</div>
        <div id="time19">19시</div>
        <div id="time20">20시</div>
        <div id="time21">21시</div>
        <div id="time22">22시</div>
        <div id="time23">23시</div>
	</div>
</div>
</div>
<script>
$("#insertBoard").click(function(){
	insertFrm.submit();
});

</script>
</body>
</html>