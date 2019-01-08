<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/side.jsp"%>
<style>
#scheduleList-container {
	margin: 0 0 10px 0;
	padding: 3px;
	background-color: lightblue;
	height:100px;
}
div#search-scheduleTitle {
	display: inline-block;
}
div#search-scheduleContent, div#search-scheduleIcon{
	display: none;
}
div#divicon{	
	width: 290px;
	height: 247px;
	background-color: yellow;	
	position:absolute;
	margin-top:5px;
}
#icon{
	width:50px;
	height:50px;
}
#tableicon{
	border-spacing : 5px;
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
	});
	
});

</script>

<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<section id="scheduleList-container">		
		검색 :&nbsp;
		<select id="searchType">
			<option value="scheduleTitle">제목</option>
			<option value="scheduleContent">내용</option>
			<option value="scheduleIcon">아이콘</option>
		</select>
		&nbsp;
		<div id="search-scheduleTitle">			
			<form action="<%=request.getContextPath()%>/schedule/searchschedule">
				<input type="hidden" 
					   name="searchType"
					   value="scheduleTitle" />
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 제목을 입력하세요."/>&nbsp;
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-scheduleContent">			
			<form action="<%=request.getContextPath()%>/schedule/searchschedule">
				<input type="hidden" 
					   name="searchType"
					   value="scheduleContent" />
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 내용을 입력하세요."/>&nbsp;
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-scheduleIcon">			
			<form action="<%=request.getContextPath()%>/schedule/searchschedule">
				<input type="hidden" 
					   name="searchType"
					   value="scheduleIcon" />				
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 아이콘을 선택하세요."/>
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








