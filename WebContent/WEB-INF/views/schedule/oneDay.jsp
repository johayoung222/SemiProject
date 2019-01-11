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
<h2><%=year %>년 <%=month %>월 <%=day %>일 <%=member.getMemberName() %>님의 작성</h2>
<div id="oneday-container">
	<form action="<%=request.getContextPath() %>/schedule/insertSchedule" id="boardInfo" name="insertFrm" method="post">
		<input type="hidden" name="year" value="<%=year %>"/>
		<input type="hidden" name="month" value="<%=month %>"/>
		<input type="hidden" name="day" value="<%=day %>"/>
		<input type="hidden" name="time" value="100"/>
	</form>

<div id="todolist">
	<h2>To do List</h2>
	<div id="insertBoard">+</div>
	<div id="right-click">
	<% if(!list.isEmpty()){ 
		String s = "";	
		for(int i=0; i<list.size(); i++){ 
	 		s += "<div><h4 id='"+list.get(i).getScheduleNo()+"'>"+list.get(i).getScheduleTitle()+"</h4></div>";
	   } %>
	<%=s %>
	<% } %>
	</div>
</div>
<div id="middleLine"></div>
<style>
#contextMenu{
	position: absolute;
	width: 150px;
    border: 1px solid black;
    background-color: rgba(211, 211, 211, 0.815);
    display: none;
}
#contextMenu .menu1{
	height: 25px;
	border: none;
}
#contextMenu div:hover{
	background-color: #616161d0;
}
#right-click{
	border: none;
}
</style>
<script>
$("#right-click").contextmenu(function(e) {
	console.log(e);
	console.log(e.target);
	var target = e.target;
	var pageX = e.originalEvent.pageX;
	var pageY = e.originalEvent.pageY;
	$("#contextMenu").css({"left":pageX, "top":pageY, "display":"block"});
	
	//e를 갖다 써야하는데 함수 스코프를 고려해서 값을 넘겨줘야 함.
	$("#contextMenu div").each(function(idx,item,target){
		$(item).click(function(target){
			$(this).parent()[0].style.display = 'none';
			console.log(target.id);
		});
	});
});

</script>

<div id="timeline">
	<h2>TimeLine</h2>
	<div id="scroll-box">
		<div id="0">00시 
			<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 0){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
		</div>
		<div id="1">01시
			<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 1){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
		</div>
        <div id="2">02시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 2){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="3">03시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 3){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="4">04시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 4){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="5">05시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 5){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="6">06시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 6){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="7">07시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 7){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="8">08시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 8){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="9">09시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 9){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="10">10시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 10){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="11">11시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 11){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="12">12시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 12){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="13">13시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 13){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="14">14시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 14){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="15">15시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 15){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="16">16시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 16){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="17">17시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 17){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="18">18시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 18){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="19">19시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 19){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="20">20시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 20){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="21">21시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 21){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="22">22시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 22){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
        <div id="23">23시
        	<%for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 23){%>
				<%=list.get(i).getScheduleTitle() %>	
			<%}
			}%>
        </div>
	</div>
</div>
</div>
<div id="contextMenu">
	<div class="menu1">삭제하기</div>
</div>
<script>
$("#insertBoard").click(function(){
	insertFrm.submit();
});

$("#todolist div#insertBoard").nextAll().click(function(){
	var target = $(this).children().children();
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