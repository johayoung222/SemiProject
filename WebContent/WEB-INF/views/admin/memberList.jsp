<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
    <%@ page import="com.kh.member.model.vo.*" %>
    
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%	
	List<Member> list = (List<Member>)request.getAttribute("list");
	int cPage = (int)request.getAttribute("cPage");
	int numPerPage = (int)request.getAttribute("numPerPage");
	String pageBar = (String)request.getAttribute("pageBar");
	
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/memberList.css" />
<script>
$(function(){
	var memberId = $("#search-memberId");	
	var memberName = $("#search-memberName");
	var memberLoginglog = $("#search-memberLoginlog");
	
	
	$("select#searchType").change(function(){
		memberId.hide();
		memberName.hide();
		memberLoginlog.hide();
		
		$("#search-"+$(this).val()).css("display","inline-block");
	});	
});

</script>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<section id="member-container">	
<h2>회원 리스트</h2>	
		검색 &nbsp;&nbsp;
		<select id="searchType">
			<option value="memberId">아이디</option>
			<option value="memberName">이름</option>
			<option value="memberLoginlog">로그인횟수</option>
		</select>
		&nbsp;
		<div id="search-memberId">			
			<form action="<%=request.getContextPath()%>/admin/memberSearch">
				<input type="hidden" 
					   name="searchType"
					   value="memberId" />
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 아이디를 입력하세요."/>&nbsp;
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-memberName">			
			<form action="<%=request.getContextPath()%>/admin/memberSearch">
				<input type="hidden" 
					   name="searchType"
					   value="memberName" />
				<input type="search" 
					   name="searchKeyword"
					   size="25"
					   placeholder="검색할 이름을 입력하세요."/>&nbsp;
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-memberLoginlog">			
			<form action="<%=request.getContextPath()%>/admin/memberSearch">
				<input type="hidden" 
					   name="searchType"
					   value="memberLoginlog" />
				<input type="search" 
					   name="searchKeyword"					  
					   size="25"
					   placeholder="접속횟수 순위"
					   readonly />	&nbsp;						
				<button type="submit" id="btn">검색</button>				
			</form>
		</div>
</section>
<section id="memberList-container">		
	<table id="tbl-memberList">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>성별</th>
		<th>나이</th>
		<th>이메일</th>
		<th>로그인횟수</th>
		<th>상태</th>
		<th>SNS연동</th>		
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
		for(Member m : list){
			index++;			
	%>			
		<tr>					
			<td><%=(cPage-1)*7+index%></td>						
			<td><%=m.getMemberId()%></td>
			<td><%=m.getMemberName()%></td>			
			<td><%=m.getMemberGender()%></td>			
			<td><%=m.getMemberAge()%></td>			
			<td><%=m.getMemberEmail()%></td>			
			<td><%=m.getMemberLoginlog()%></td>			
			<td><%=m.getMemberStatus()%></td>			
			<td><%=m.getMemberSnsaccount()%></td>			
		</tr>
	<% }
	} %>		
	</table>
	<div id="pageBar">
	<%=pageBar %>
	</div>
</section>
