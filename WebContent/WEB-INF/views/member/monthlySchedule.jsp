<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	//전달받은 데이터에서 현재일자를 꺼냄.
	Map<Integer,Integer> map = (HashMap<Integer,Integer>)request.getAttribute("map");
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
	int start = (int)request.getAttribute("start");
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/month.css" />
<%-- <%@ include file="/WEB-INF/views/common/side.jsp" %> --%>
	<div id="sidebar">
	
	</div>

	<!-- 스케줄영역 -->
	<div id="schedule">
		<div id="main">
            <span>&lt;</span>
            <span><%=year %>년</span>
            <span><%=month %>월</span>
            <span id="nextMonth">&gt;</span>
        </div>
        <script>
        $("#nextMonth").click(function(){
        	$.ajax({
        		url: "<%=request.getContextPath() %>/schedule/nextMonth.do",
        		dataType: "json",
        		data: {"cYear":<%=year %>, "cMonth":<%=month %>},
        		success: function(data){
        			console.log(data);
        		}
        	});
        });
        
        </script>
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
			<script>
			var html = "";
			var tr = $("<tr></tr>");
			var table = $("#month");
			for(var i=0; i<=34; i++){
				html = "<td><span></span></td>";
				if(i><%=start %>){
				html = "<td><span>"+(i-<%=start %>)+"</span></td>";
				if(i%7 == 0) html = "<tr><td><span>"+(i-<%=start %>)+"</span></td>";
				}
				document.write(html);
			}
			
			</script>
		</table>
	</div>
</body>
</html>