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
<%@ include file="/WEB-INF/views/common/side.jsp" %>
	<div id="sidebar">
	
	</div>

	<!-- 스케줄영역 -->
	<div id="schedule">
		<div id="main">
            <span id="prevMonth">&lt;</span>
            <span id="cYear"><%=year %></span>년
            <span id="cMonth"><%=month+1 %></span>월
            <span id="nextMonth">&gt;</span>
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
			<script>
			var html = "";
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
	<script>
        $("#nextMonth").click(function(){
        	$.ajax({
        		url: "<%=request.getContextPath() %>/schedule/nextMonth.do",
        		type: "get",
        		dataType: "json",
        		data: {"cYear":$("#cYear").text(), "cMonth":($("#cMonth").text()-1)},
        		success: function(data){
        			console.log(data);
        			var nextYear = data[0];
        			var nextMonth = data[1];
        			$("#cYear").text(nextYear);
        			$("#cMonth").text(nextMonth+1);
        		}
        	});
        });
        
        $("#prevMonth").click(function(){
        	$.ajax({
        		url: "<%=request.getContextPath() %>/schedule/prevMonth.do",
        		dataType: "json",
        		type: "get",
        		data: {"cYear":$("#cYear").text(), "cMonth":($("#cMonth").text()-1)},
        		success: function(data){
        			console.log(data);
        			var prevYear = data[0];
        			var prevMonth = data[1];
        			$("#cYear").text(prevYear);
        			$("#cMonth").text(prevMonth+1);
        		}
        	});
        });
        </script>
</body>
</html>