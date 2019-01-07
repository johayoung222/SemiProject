<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.member.model.vo.*"  %>
<%
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");    
%>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css">
  <script src="js/jquery-3.3.1.js"></script>
</head>
<style>
#logged-in{
	width: 250px;
	position: absolute;
	right: 0px;
	top: 5px;			
}
</style>
<body>
  <nav class="header">
    <div class="logo">
      <img src="<%=request.getContextPath() %>/images/logo.png" width="50px" height="50px" >
      <span class="logofont">7' Scheduler
      </span>
    </div>  
   <%--  <%if(memberLoggedIn != null){ %>--%>
  <table id="logged-in" >
	<tr>
		<td>
		 <%--	<%=memberLoggedIn.getMemberName() %>님,	안녕하세요 :)--%>
		 000님, 안녕하세요:)
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="정보수정" onclick=/>
			&nbsp;
			<input type="button" value="로그아웃" onclick=/>
		</td>
	</tr>
	</table>	
	<%--<%}else{ %>
	
	
	
	<%} %>--%>
    
  </nav>
  
</body>