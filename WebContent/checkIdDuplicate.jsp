<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	boolean isUsable = (boolean)request.getAttribute("isUsable");
	String memberId = (String)request.getAttribute("memberId");
	System.out.printf("[%s %s]\n",isUsable, memberId);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>아이디 중복검사</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script>
function checkIdDuplicate(){
	   //아이디중복검사폼을 전송.
	   var memberId = $("#memberId_").val().trim();
	   if(memberId.length < 4){
	      alert("아이디는 4글자 이상가능합니다.");
	      return;
	   }  
	   
	   checkIdDuplicateFrm.target = target;
	   checkIdDuplicateFrm.submit();
	   
	}
function setMemberId(memberId){
	//부모창의 frm
	var frm = opener.document.memberEnrollFrm;
	frm.memberId.value=memberId;
	frm.idValid.value = 1;
	frm.password.focus();
	
	//현재창을 제어
	self.close();
	
}
</script>
<style>
#checkid-container{
	text-align:center;
	padding-top:50px;
	
}
span#duplicated{
	color:red;
	font-weight:bold;
}
</style>
</head>
<body>

	<div id="checkid-container">
	<%if(isUsable){ %>
		[<%=memberId %>]는 사용가능합니다.
		<br /><br />
		<button type="button" onclick="setMemberId('<%=memberId %>')">닫기</button>
	<%}
	else{%>
		[<span id="duplicated"><%=memberId %></span>]는 
		이미 사용중입니다.
		<form action="<%=request.getContextPath()%>/member/checkIdDuplicate"
	     method="post"
	     name = "checkIdDuplicateFrm">
	     <input type="text" name="memberId" id="memberId" placeholder="아이디를 입력하세요." />
	     <button type="button" onclick="checkIdDuplicate();">확인</button>
	   	
	</form>
		
	<%} %>
	</div>
</body>
</html>