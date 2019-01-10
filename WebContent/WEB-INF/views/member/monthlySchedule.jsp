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
	
	Member m = (Member)request.getSession(false).getAttribute("memberLoggedIn");
	
	//schedule data 를 date별로 나누기
	List<Schedule> dayList = null;
	HashMap<Integer,List<Schedule>> map = new HashMap<>();
	
			
			//년월일에 맞게 데이터 삽입해줘야 함
			Calendar c2 = Calendar.getInstance();
			for(int i=1; i<=31; i++) {
				dayList = new ArrayList<>();
				for(Schedule s : list) {
					Date date = s.getScheduleDate();
					c2.setTime(date);
					if(i == c2.get(Calendar.DATE)) {
						dayList.add(s);
					}
				}
				map.put(i, dayList);
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
			var day = $(this).children().attr("id");
			if(day != null){
			location.href = "<%=request.getContextPath() %>/schedule/oneday?year="+year+"&month="+month+"&day="+day;
			}
		});
	});
}

function insertData(){
	var span = $("#add").find("span");
	for(var i=0; i< span.length; i++){
		<% for(int i=1; i<=31; i++){
			if(!map.get(i).isEmpty()){ %>
		if(span[i].id == <%=i %>) span[i].innerText = span[i].id+"<%=map.get(i).get(0).getScheduleTitle() %>";
			<%}
		} %>
	}
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
			for(var i=0; i<35; i++){
				html = "<td><span></span></td>";
				if(i>=start && i<=<%=last %>+1){
				html = "<td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
				if(i%7 == 0) html = "<tr><td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
				}
				document.write(html);
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
        $("#nextMonth").click(function(){
        	$.ajax({
        		url: "<%=request.getContextPath() %>/schedule/nextMonth.do",
        		type: "get",
        		dataType: "json",
        		data: {"cYear":$("#cYear").text(), "cMonth":($("#cMonth").text()-1), "memberId":"<%=m.getMemberId() %>"},
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
        
       
        
        
        
        </script>
         <%if("admin".equals(m.getMemberId())){%>
		<div id="adminSide">
			<a href="<%=request.getContextPath()%>/admin/memberList">회원리스트 조회</a>
		</div>
		<%}%>
</body>
</html>