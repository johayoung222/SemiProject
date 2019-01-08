<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
	String user = (String)request.getAttribute("user");

%>
<h2><%=year %>년 <%=month %>월 <%=day %>일 <%=user %>님의 작성</h2>
</body>
</html>