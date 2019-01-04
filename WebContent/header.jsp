<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션을 가져와서 로그인 상태일 경우 스케줄을 뿌릴 수 있는 리스트 반환

%>
    
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
    <title>Semiproject</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />
<script>
$(function(){
	$("#login").click(function(){
		alert("로그인 페이지로 이동!");
	});
});
</script>
</head>
<body>
  <nav>
    <div class="logo">
      <img src="images/p3.jpg" alt=""width="30px" height="30px"> &nbsp;7 Scheduler </div>
    <div class="nav-main">
        <ul>  
        <li id="login">Login</li>
      </ul>
      <div class="clear"></div>
    </div>
  </nav>