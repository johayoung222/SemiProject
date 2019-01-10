<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				com.kh.member.model.vo.*,
				com.kh.schedule.model.vo.*" %>
<%
	//전달받은 데이터에서 현재일자를 꺼냄.
	List<Schedule> list = (List<Schedule>)request.getAttribute("list");
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
	int start = (int)request.getAttribute("start");
	int last = (int)request.getAttribute("last");
	Map<Integer,List<Schedule>> map = (HashMap<Integer,List<Schedule>>)request.getAttribute("map");
	
	Member m = (Member)request.getSession(false).getAttribute("memberLoggedIn");
	
	//schedule data 를 date별로 나누기

%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/month.css" />

<script>
/* 일일 칸에 클릭 이벤트 */
function addClickEvent(){
	var tag = $("#add").find("td");
	tag.each(function(idx, item){
		$(item).click(function(){
			var year = $("#cYear").text();
			var month = $("#cMonth").text();
			var day = $(this).children().attr("id");
			if(day != ""){
			location.href = "<%=request.getContextPath() %>/schedule/oneday?year="+year+"&month="+month+"&day="+day;
			}
		});
	});
}
</script>

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
			for(var i=0; i<=<%=last %>+1; i++){
				html = "<td><span></span></td>";
				if(i>=start && i<=<%=last %>+1){
				html = "<td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
				if(i%7 == 0) html = "<tr><td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
				}
				document.write(html);
			}
			var span = $("#add").find("span");
			for(var i=0; i< span.length; i++){
				<% for(int i=1; i<=31; i++){
					if(!map.get(i).isEmpty()){ %>
				if(span[i].id == <%=i %>) span[i].innerText = span[i].id+"<%=map.get(i).get(0).getScheduleTitle() %>";
					<%}
				} %>
			}
			addClickEvent();
			
			</script>
		</table>
	</div>
	<!-- 
	<div id="chat-body">		
		<div id="chat-before">
		앞에 초록색 동그라미 이모티콘 추가
			<strong>채팅</strong>
			뒤에 버튼 2~3가지 추가 친구 찾기 및 추가 / 새로운 그룹 추가 / 생각중
	
		</div>
	
		<div id="chat-find-friend">
			돋보기 모양 이모티콘
			input:text Ajax사용해서 회원이름 검색시 주르륵 나오게
			친구 찾기
			오른쪽에는 +버튼 이미지? 버튼하나만들어서 추가 하게끔
			 
		</div>	
	</div> -->
	<script>
		/* 다음달로 넘어가는 기능 */
        $("#nextMonth").click(function(){
        	$.ajax({
        		url: "<%=request.getContextPath() %>/schedule/nextMonth.do",
        		type: "get",
        		dataType: "json",
        		data: {"cYear":$("#cYear").text(), "cMonth":($("#cMonth").text()), "memberId":"<%=m.getMemberId() %>"},
        		success: function(data){
        			console.log(data);
        			var nextYear = data[1];
        			var nextMonth = data[2];
        			var start = data[3];
        			var last = data[4]+start;
        			var dataList = data[5];
        			$("#cYear").text(nextYear);
        			$("#cMonth").text(nextMonth+1);
        			console.log(data[5][0] == null);
        			
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
        			
        			var span = $("#add").find("span");
        			if(dataList != null){
        			for(var i=0; i< span.length; i++){
        				for(var j=0; j<dataList.length; j++){
        					console.log(i,j,dataList[j].scheduleTitle);
        				if(span[i].id == dataList[j].theDay) span[i].innerText = span[i].id+dataList[j].scheduleTitle;
        				}
        			}
        			}
        			
        			addClickEvent();
        		}
        	});
        });
        /* 이전달로 넘어가는 기능 */
        $("#prevMonth").click(function(){
        	$.ajax({
        		url: "<%=request.getContextPath() %>/schedule/prevMonth.do",
        		dataType: "json",
        		type: "get",
        		data: {"cYear":$("#cYear").text(), "cMonth":($("#cMonth").text()), "memberId":"<%=m.getMemberId() %>"},
        		success: function(data){
        			console.log(data);
        			var prevYear = data[1];
        			var prevMonth = data[2];
        			var start = data[3];
        			var last = data[4]+start;
        			var dataList = data[5];
        			$("#cYear").text(prevYear);
        			$("#cMonth").text(prevMonth+1);
        			console.log(data[5][0] == null);
        			
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
        			var span = $("#add").find("span");
        			if(dataList != null){
        			for(var i=0; i< span.length; i++){
        				for(var j=0; j<dataList.length; j++){
        					console.log(i,j,dataList[j].scheduleTitle);
        				if(span[i].id == dataList[j].theDay) span[i].innerText = span[i].id+dataList[j].scheduleTitle;
        				}
        			}
        			}
        			addClickEvent();
        		}
        	});
        });
        
        </script>
         <%if("admin".equals(m.getMemberId())){%>
		<div id="adminSide">
			<a href="<%=request.getContextPath()%>/admin/memberList">회원리스트 조회</a>
		</div>
		<%}%>
</body>
</html>