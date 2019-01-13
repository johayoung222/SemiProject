<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
	// String[] popupArr = (String[])request.getAttribute("popupArr");
	String memberId = (String)request.getAttribute("memberId");
	List<String> popup = (List<String>)session.getAttribute("popup"); 
	System.out.println(popup);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 받을꺼야 말꺼야</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
</head>
<body>
	<div id="checkid-container">

		<br /><br />
		<form action="<%=request.getContextPath()%>/member/checkFriend"
			  method="post"
			  name="checkFriendFrm">
		<button>추가</button>
		<button>취소</button>
		<button onclick="self.close();">닫기</button>	   
	</form>
		
	</div>
</body>
</html>

