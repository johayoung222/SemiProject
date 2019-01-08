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
	});
	
	$("#divicon img").on('click',function(){
		var clickedIcon = $(this).attr("alt");		
		$("#text").text($(this).attr("alt"));
		$("#search-scheduleIcon#searchKeyword").val($(this).attr("alt"));
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
					   name="numPerPage" 
					   value="<%=numPerPage%>"/>
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
					   name="numPerPage" 
					   value="<%=numPerPage%>"/>
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
					   name="numPerPage" 
					   value="<%=numPerPage%>"/>
				<input type="hidden" 
					   name="searchType"
					   value="scheduleIcon" />				
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 아이콘을 선택하세요."
					   readonly
					   value="<%="scheduleIcon".equals(searchType)?searchKeyword:""%>"/>
				<div id="divicon">
				<table id="tableicon">
				<tr>
					<td><img src="<%=request.getContextPath() %>/images/flower1.PNG" id="icon" alt="christmas"  ></td>
					<td><img src="<%=request.getContextPath() %>/images/flower2.PNG" id="icon" alt="birthday"></td>
					<td><img src="<%=request.getContextPath() %>/images/flower3.PNG" id="icon" alt="exhibition"></td>
					<td><img src="<%=request.getContextPath() %>/images/logo.PNG" id="icon" alt="family"></td>
					<td><img src="<%=request.getContextPath() %>/images/birthday.PNG" id="icon" alt="hospital"></td>
				</tr>
				<div id="text"></div>
				</table>					
				
				</div>				
				<button type="submit" id="btn">검색</button>				
			</form>
		</div>
</section>
<section id="schedulelist-container">		
	<table id="tbl-schedulelist">
	<tr>
		<th>번호</th>
		<th>스케줄 시작일</th>
		<th>스케줄 종료일</th>
		<th>제목</th>
		<th>작성일</th>		
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
			<td><%=s.getScheduleStartday() %></td>
			<td><%=s.getScheduleEndday() %></td>			
			<td>
			<a href="<%=request.getContextPath()%>/schedule/scheduleView?ScheduleNo=<%=s.getScheduleNo()%>">
			<%=s.getScheduleTitle() %></a></td>
			<td><%=s.getScheduleDate() %></td>					
		</tr>
	<% }
	} %>		
	</table>
	<div id="pageBar">
	<%=pageBar %>
	</div>
</section>
