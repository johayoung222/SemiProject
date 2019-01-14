<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int status = Integer.parseInt(request.getParameter("status"));
	String msg = request.getParameter("msg");
	/*
	status : 1
	- 본인에게는 친구추가를 할 수 없습니다.
	status : 2
	- 입력하신아이디는 존재하지 않는 아이디입니다.
	status : 3
	- 입력하신아이디께 친구 요청에 성공하셨습니다.
	status : 4
	- 같은 사용자에게 친구요청을 하셨습니다.
	 */
	 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 추가 팝업</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/checkidDuplicate.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<script>
function checkIdDuplicate(){
/*
	//아이디중복검사폼을 전송.
	var memberId = $("#memberId").val().trim();
	
	
	if( memberId.length < 4 && memberId.length<13){
		alert("아이디는 4글자 이상 12글자 이하 가능 합니다.");
		return;
	}
*/	
	checkIdDuplicateFrm.memberId.value = memberId;
	checkIdDuplicateFrm.submit();
	
}

function setMemberId(){
	// opener.signupform.idValid.value = "1";
	// opener.signupform.memberPwd.focus();
	self.close();
	
	
}
</script>

</head>
<body>
	<div id="checkid-container">
	<%if(status == 1){ %>
		본인에게는 친구추가를 할 수 없습니다.
		<br /><br />
		<button onclick="setMemberId();">닫기</button>
	<% } else if(status == 2) { %>
		입력하신아이디는 존재하지 않는 아이디입니다.
		<br /><br />
		<button onclick="setMemberId();">닫기</button>
	<% } else if(status == 3) { %>
		입력하신아이디께 친구 요청에 성공하셨습니다.
		<br /><br />
		<button onclick="setMemberId();">닫기</button>	
	<% } else if(status == 4) { %>
		같은 사용자에게 친구요청을 하셨습니다.
		<br /><br />
		<button onclick="setMemberId();">닫기</button>	
	
	<%} 
	else {%>
		[<span id="duplicated"></span>]는
		이미 사용중입니다.
		<form action="<%=request.getContextPath()%>/member/checkIdDuplicate"
			  method="post"
			  name="checkIdDuplicateFrm">
		<input type="text" 
			   name="memberId" 
			   id="memberId" 
			   placeholder="아이디를 입력하세요."/>
		<button type="button" onclick="checkIdDuplicate();">중복검사</button>	   
	</form>
		
	<%} %>
	</div>
</body>
</html>