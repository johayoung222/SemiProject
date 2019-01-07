<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	//전달받은 데이터에서 현재일자를 꺼냄.
	Map<Integer,Integer> map = (HashMap<Integer,Integer>)request.getAttribute("map");
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/month.css" />
<%@ include file="/WEB-INF/views/common/side.jsp" %>
	<div id="sidebar">
	
	</div>


	<!-- 스케줄영역 -->
	<div id="schedule">
		<div id="main">
            <span>&lt;</span>
            <span><%=year %>년</span>
            <span><%=month %>월</span>
            <span>&gt;</span>
        </div>
		<table id="month">
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>