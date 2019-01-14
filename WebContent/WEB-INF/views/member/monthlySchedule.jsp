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
	int start = (int)request.getAttribute("start");
	int last = (int)request.getAttribute("last");
	Map<Integer,List<Schedule>> map = (HashMap<Integer,List<Schedule>>)request.getAttribute("map");
	
	Member m = (Member)request.getAttribute("memberLoggedIn");
	
	//schedule data 를 date별로 나누기

%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/month.css" />
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">

<script>
/* 일일 칸에 클릭 이벤트 */
function addClickEvent(){
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
</script>
<style>
	table#add tr td:first-of-type{
       color:red;
   }
   /* table#add tr td:last-of-type{
       color:blue;
   } */
   span.sat{
       color:blue;
   }
   #year-box{
		background-color: white;
       width: 100%;
       height: 100%;
       position: absolute;
       display: none;
       z-index: 100;
   }
   .year{
       width: 24%;
       height: 180px;
       display: inline-block;
       border: .5px solid lightgray;
   }
   .year:hover{
		box-shadow: 1px 1px 5px .5px black;
   }
   .year img{
   		margin: 0;
   		width: 100%;
   		height: 100%;
   		display: inline-block;
   }
</style>



	<!-- 스케줄영역 -->
	<div id="schedule">
		<div id="main">
            <span id="prevMonth">&lt;</span>
            <span id="cYear"><%=year %></span>년
            <span id="cMonth"><%=month+1 %></span>월
            <span id="nextMonth">&gt;</span>
        </div>
		<!-- 년간 달력 테스트 -->
		<div id="year-box">
		    <div class="year" id="month_1"><img src="<%=request.getContextPath() %>/images/year/month1.png" alt="1" /></div>
		    <div class="year" id="month_2"><img src="<%=request.getContextPath() %>/images/year/month2.png" alt="2" /></div>
		    <div class="year" id="month_3"><img src="<%=request.getContextPath() %>/images/year/month3.png" alt="3" /></div>
		    <div class="year" id="month_4"><img src="<%=request.getContextPath() %>/images/year/month4.png" alt="4" /></div>
		    <div class="year" id="month_5"><img src="<%=request.getContextPath() %>/images/year/month5.png" alt="5" /></div>
		    <div class="year" id="month_6"><img src="<%=request.getContextPath() %>/images/year/month6.png" alt="6" /></div>
		    <div class="year" id="month_7"><img src="<%=request.getContextPath() %>/images/year/month7.png" alt="7" /></div>
		    <div class="year" id="month_8"><img src="<%=request.getContextPath() %>/images/year/month8.png" alt="8" /></div>
		    <div class="year" id="month_9"><img src="<%=request.getContextPath() %>/images/year/month9.png" alt="9" /></div>
		    <div class="year" id="month_10"><img src="<%=request.getContextPath() %>/images/year/month10.png" alt="10" /></div>
		    <div class="year" id="month_11"><img src="<%=request.getContextPath() %>/images/year/month11.png" alt="11" /></div>
		    <div class="year" id="month_12"><img src="<%=request.getContextPath() %>/images/year/month12.png" alt="12" /></div>
		</div>
		<script>
		/* 년간 달력 스크립트 */
		$("#year-box .year").each(function(idx, item){
		    $(item).click(function(e){
		    	location.href = "<%=request.getContextPath() %>/schedule/monthOfYear?month="+e.target.alt;
		    });
		});
		</script>
		<table id="month">
			<tr>
				<th style="color:red;">일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th style="color:blue;">토</th>
			</tr>
		</table>
		<table id="add">
			<script>
			var html = "";
			var start = <%=start %>;
			for(var i=0; i<=<%=last %>+1; i++){
                html = "<td><span></span></td>";
                if(i>=start && i<=<%=last %>+1){
                if(i%7 == 6)html = "<td><span id='"+(i-start+1)+"' class='sat'>"+(i-start+1)+"</span></td>";
                else html = "<td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
                if(i%7 == 0) html = "<tr><td><span id='"+(i-start+1)+"'>"+(i-start+1)+"</span></td>";
                }
                document.write(html);
            }
			var span = $("#add").find("span");
			for(var i=0; i< span.length; i++){
				<% for(int i=1; i<=31; i++){
					if(!map.get(i).isEmpty()){ %>
				if(span[i].id == <%=i %>) span[i].innerText = span[i].id+" <%=map.get(i).get(0).getScheduleTitle() %>";
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
        						if(i%7 == 6){
        							html += "<td><span id='"+(i-start+2)+"' class='sat'>"+(i-start+2)+"</span></td>";
        						}
        						else{
        							html += "<td><span id='"+(i-start+2)+"'>"+(i-start+2)+"</span></td>";
        						}
		        			
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
        						if(i%7 == 6){
        							html += "<td><span id='"+(i-start+2)+"' class='sat'>"+(i-start+2)+" </span></td>";
        						}
        						else{
		        					html += "<td><span id='"+(i-start+2)+"'>"+(i-start+2)+" </span></td>";
        							
        						}
        					}else{
        					html += "<td><span></span></td>";
        					}
        				}else{
        					if(i >= start-1){
        					html += "<tr><td><span id='"+(i-start+2)+"'>"+(i-start+2)+" </span></td>";
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
        
        
        /* 공휴일 뿌리기 */
        
        /* 스크롤 이벤트 */
		$(window).scroll(function(e){
			var scrollTop = $(this).scrollTop();
			if(scrollTop >= 0.5){
				$("#year-box").css("display","block");
			}else{
				$("#year-box").css("display","none");
			}
			
		});      
        </script>
        
</body>
</html>