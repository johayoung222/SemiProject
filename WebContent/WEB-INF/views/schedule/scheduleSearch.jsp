<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.kh.schedule.model.vo.*" %>
    
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%	
	List<Schedule> list = (List<Schedule>)request.getAttribute("list");
	int cPage = (int)request.getAttribute("cPage");
	int numPerPage = (int)request.getAttribute("numPerPage");
	String pageBar = (String)request.getAttribute("pageBar");
	String searchType = request.getParameter("searchType");
	String searchKeyword = request.getParameter("searchKeyword");
	
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/scheduleList.css" />
<style>
div#search-scheduleTitle{
	display: <%="scheduleTitle".equals(searchType)?"inline-block":"none"%>;
}
div#search-scheduleContent{
	display: <%="scheduleContent".equals(searchType)?"inline-block":"none"%>;
}
div#search-scheduleIcon{
	display: <%="scheduleIcon".equals(searchType)?"inline-block":"none"%>;
}
</style>
<script>
$(function(){
	var scheduleTitle = $("#search-scheduleTitle");	
	var scheduleContent = $("#search-scheduleContent");
	var scheduleIcon = $("#search-scheduleIcon");	
	
	$("select#searchType").change(function(){
		scheduleTitle.hide();
		scheduleContent.hide();
		scheduleIcon.hide();
		
		$("#search-"+$(this).val()).css("display","inline-block");
		var check = $("select#searchType option:selected").val();
		
		if(check == "scheduleIcon"){
			$("#divicon").show();
		}else{
			$("#divicon").hide();
		}
	});
	
	$(".icon").on('click',function(){		
		var clickedIcon = $(this).attr("alt");		
		$("#iconValue").val(clickedIcon);	
		clickedIcon = "";				
	});
	
	$("#iconClose").on('click',function(){
		$("#divicon").hide();
	});	
	
	
			
});


</script>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<section id="schedulesearch-container">	
<h2>스케줄 찾기</h2>	
		검색 &nbsp;&nbsp;
		<select id="searchType">
			<option value="scheduleTitle" <%="scheduleTitle".equals(searchType)?"selected":"" %>>제목</option>
			<option value="scheduleContent" <%="scheduleContent".equals(searchType)?"selected":"" %>>내용</option>
			<option value="scheduleIcon" <%="scheduleIcon".equals(searchType)?"selected":"" %>>아이콘</option>
		</select>
		&nbsp;
		<div id="search-scheduleTitle">			
			<form action="<%=request.getContextPath()%>/schedule/scheduleSearch">
				<input type="hidden" 
					   name="searchType"
					   value="scheduleTitle" />
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 제목을 입력하세요."
					   value="<%="scheduleTitle".equals(searchType)?searchKeyword:""%>"/>&nbsp;
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-scheduleContent">			
			<form action="<%=request.getContextPath()%>/schedule/scheduleSearch">
				<input type="hidden" 
					   name="searchType"
					   value="scheduleContent" />
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 내용을 입력하세요."
					   value="<%="scheduleContent".equals(searchType)?searchKeyword:""%>"/>&nbsp;
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-scheduleIcon">			
			<form action="<%=request.getContextPath()%>/schedule/scheduleSearch">
				<input type="hidden" 
					   name="searchType"
					   id="scheduleIcon"
					   value="scheduleIcon" />			
				<input type="search" 
					   name="searchKeyword"
					   id="iconValue"
					   size="25"
					   placeholder="검색할 아이콘을 선택하세요."
					   readonly/>&nbsp;			
				<button type="submit">검색</button>				
			</form>
		</div>
			<div id="divicon">
				<table id="tableicon">
				<tr>
					<td><img src="<%=request.getContextPath() %>/images/baseball.png" class="icon" alt="baseball.png"  ></td>
					<td><img src="<%=request.getContextPath() %>/images/birthday.png" class="icon" alt="birthday.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/bowling.png" class="icon" alt="bowling.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/family.png" class="icon" alt="family.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/hospital.png" class="icon" alt="hospital.png"></td>
				</tr>	
				<tr>				
					<td><img src="<%=request.getContextPath() %>/images/like.png" class="icon" alt="like.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/marry.png" class="icon" alt="marry.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/shopping.png" class="icon" alt="shopping.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/soju&beer.png" class="icon" alt="soju&beer.png"></td>
					<td><img src="<%=request.getContextPath() %>/images/test.png" class="icon" alt="test.png"></td>
				</tr>
				<tr>
					<td colspan=5><button id="iconClose" >닫기</button></td>		
				</tr>			
				</table>		
			</div>		
</section>
<section id="schedulelist-container">		
	<table id="tbl-schedulelist">
	<tr>
		<th>번호</th>
		<th>아이콘</th>
		<th>스케줄 날짜</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
	</tr>
	<!-- 스크립틀릿 처리요망 -->
	<% if(list == null || list.isEmpty()){ %>
		<tr>
			<td colspan="6" align="center">
					검색결과가 없습니다.
			</td>
		</tr>
	<%} 
	else {
		int index=0;
		for(Schedule s : list){
			index++;			
	%>			
		<tr>					
			<td><%=(cPage-1)*7+index%></td>	
			<td><img src="<%=request.getContextPath()%>/images/<%=s.getScheduleIcon()%>"/></td>				
			<td><%=s.getScheduleDate() %></td>			
			<td>
			<a href="<%=request.getContextPath()%>/schedule/selectOne?scheduleNo=<%=s.getScheduleNo()%>">
			<%=s.getScheduleTitle() %></a></td>
			<td id="contentWidth"><%=s.getScheduleContent() %></td>
			<td><%=s.getMemberId() %></td>
		</tr>
	<% }
	} %>		
	</table>
	<div id="pageBar">
	<%=pageBar %>
	</div>
</section>
