<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				com.kh.member.model.vo.*,
				com.kh.schedule.model.vo.*" %>
<%
	//전달받은 데이터에서 현재일자를 꺼냄.
	Map<Integer,Integer> map = (HashMap<Integer,Integer>)request.getAttribute("map");
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
	int start = (int)request.getAttribute("start");
	List<Schedule> list = (List<Schedule>)request.getAttribute("list");
	
	Member m = (Member)request.getSession(false).getAttribute("memberLoggedIn");
	
	if(m != null){
				
	}
	
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/month.css" />
<script>
function addClickEvent(){
	insertData();
	var tag = $("#add").find("td");
	tag.each(function(idx, item){
		$(item).click(function(){
			var year = $("#cYear").text();
			var month = $("#cMonth").text();
			var day = $(this).text();
			if(day != ""){
			location.href = "<%=request.getContextPath() %>/schedule/oneday?year="+year+"&month="+month+"&day="+day;
			}
		});
	});
}

function insertData(){
	var span = $("#add").find("span");
	console.log(span);
	<% for(int i=0; i<list.size(); i++){
		
	} %>
	for(var i=0; i< span.length; i++){
		if(span[i].id == 3) span[i].innerText += "schedule";
	}
}
</script>


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
		</table>
		<table id="add">
			<script>
			var html = "";
			var start = <%=start %>;
			for(var i=0; i<=<%=map.get(month) %>+1; i++){
				html = "<td><span></span></td>";
				if(i>=start && i<=<%=map.get(month) %>+1){
				html = "<td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
				if(i%7 == 0) html = "<tr><td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
				}
				document.write(html);
			}
			insertData();
			addClickEvent();
			
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
        			var start = data[2];
        			var last = data[3]+start;
        			$("#cYear").text(nextYear);
        			$("#cMonth").text(nextMonth+1);
        			
        			var table = $("#add");
        			table.html("");
        			var html = "";
        			for(var i=0; i<last-1; i++){

        				if(i%7 != 0){
        					if(i >= start-1){
        					html += "<td><span id='"+(i-start+2)+"'>"+(i-start+2)+"</span></td>";
        					}else{
        					html += "<td><span></span></td>";
        					}
        				}else{
        					if(i >= start-1){
        					html += "<tr><td><span id='"+(i-start+2)+"'>"+(i-start+2)+"</span></td>";
        					}else{
        					html += "<tr><td><span></span></td>";
        					}
        				}
        			}
        			table.append(html);
        			$("#month").after(table);
        			addClickEvent();
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
        			var start = data[2];
        			var last = data[3]+start;
        			$("#cYear").text(prevYear);
        			$("#cMonth").text(prevMonth+1);
        			
        			var table = $("#add");
        			table.html("");
        			var html = "";
        			for(var i=0; i<last-1; i++){

        				if(i%7 != 0){
        					if(i >= start-1){
        					html += "<td><span>"+(i-start+2)+"</span></td>";
        					}else{
        					html += "<td><span></span></td>";
        					}
        				}else{
        					if(i >= start-1){
        					html += "<tr><td><span>"+(i-start+2)+"</span></td>";
        					}else{
        					html += "<tr><td><span></span></td>";
        					}
        				}
        			}
        			table.append(html);
        			$("#month").after(table);
        			addClickEvent();
        		}
        	});
        });
        
        
        
        
        </script>
</body>
</html>