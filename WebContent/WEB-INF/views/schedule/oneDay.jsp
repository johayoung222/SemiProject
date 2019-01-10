<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				com.kh.schedule.model.vo.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>

<%
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
	Member member = (Member)request.getAttribute("member");
	List<Schedule> list = (List<Schedule>)request.getAttribute("list");

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
		<input type="hidden" name="time" value="time"/>
	</form>

<div id="todolist">
	<h2>To do List</h2>
	<div id="insertBoard">+</div>
	<% if(!list.isEmpty()){ 
		String s = "";	
		for(int i=0; i<list.size(); i++){ 
	 		s += "<div><h4 id='"+list.get(i).getScheduleNo()+"'>"+list.get(i).getScheduleTitle()+"</h4></div>";
	   } %>
	<%=s %>
	<% } %>
</div>
<div id="middleLine"></div>

<div id="timeline">
	<h2>TimeLine</h2>
	<div id="scroll-box">
		<div id="0">00시</div>
		<div id="1">01시</div>
        <div id="2">02시</div>
        <div id="3">03시</div>
        <div id="4">04시</div>
        <div id="5">05시</div>
        <div id="6">06시</div>
        <div id="7">07시</div>
        <div id="8">08시</div>
        <div id="9">09시</div>
        <div id="10">10시</div>
        <div id="11">11시</div>
        <div id="12">12시</div>
        <div id="13">13시</div>
        <div id="14">14시</div>
        <div id="15">15시</div>
        <div id="16">16시</div>
        <div id="17">17시</div>
        <div id="18">18시</div>
        <div id="19">19시</div>
        <div id="20">20시</div>
        <div id="21">21시</div>
        <div id="22">22시</div>
        <div id="23">23시</div>
	</div>
</div>
</div>
<script>
$("#insertBoard").click(function(){
	insertFrm.submit();
});

$("#todolist div#insertBoard").nextAll().click(function(){
	var target = $(this).children();
	var boardNo = target.attr("id");
	location.href = "<%=request.getContextPath() %>/schedule/selectOne?scheduleNo="+boardNo;
});

$("#scroll-box div").each(function(idx, item){
	$(item).click(function(){
		var time = $(this).attr("id");
		insertFrm.time.value = time;
		insertFrm.submit();
	});
});
</script>
</body>
</html>