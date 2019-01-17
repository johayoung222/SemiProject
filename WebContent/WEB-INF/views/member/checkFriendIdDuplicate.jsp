<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	int status = (int)request.getAttribute("status");
	/*
	status : 1
	- 본인에게는 친구추가를 할 수 없습니다.
	status : 2
	- 입력하신아이디는 존재하지 않는 아이디입니다.
	status : 3
	- 입력하신아이디께 친구 요청에 성공하셨습니다.
	status : 4
	- 같은 사용자에게 친구요청을 하셨습니다.
	status : 5
	- 이미 친구인 사용자입니다.
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 추가 팝업</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/checkidDuplicate.css" />
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script>

function setMemberId(){
	self.close();	
}
</script>

</head>
<body>
	<div id="checkid-container">
	<%if(status == 1){ %>
		<%=msg %>
		<br /><br />
		<button onclick="setMemberId();">닫기</button>
	<% } else if(status == 2) { %>
		<%=msg %>
		<br /><br />
		<button onclick="setMemberId();">닫기</button>
	<% } else if(status == 3) { %>
		<%=msg %>
		<br /><br />
		<button onclick="setMemberId();">닫기</button>	
	<% } else if(status == 4) { %>
		<%=msg %>
		<br /><br />
		<button onclick="setMemberId();">닫기</button>	
	
	<%} else if(status == 5) {%>
		<%=msg %>
		<br /><br />
		<button onclick="setMemberId();">닫기</button>	
	<% } %>
	</div>
</body>
</html>