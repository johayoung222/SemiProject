<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int certifiedNum = (int)request.getAttribute("certified");
    	System.out.println(certifiedNum);
        
    %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script>
function check(){
	var certified = $("#certified").val().trim();
	console.log(certified);
	var certifiedNum = <%=certifiedNum%>;
	console.log(certifiedNum);

	
	
	if(certified.length == 0){
		alert("인증번호를 입력하세요");
		return false;
	}else if(certified != certifiedNum){
		alert("인증번호가 틀렸습니다. 인증번호를 다시입력해주세요.");
		return false;
	}else{
		alert("인증 완료");
		
		

		self.close();
	}
} 
</script>
<style>
#emailcertified-container{
	border: 1px solid red;
	width: 340px;
	height:130px;
	margin: 0 auto;
}
#emailcertified-container label{
	margin: 0px auto;
	position: relative;
	top:50px;
	left:25px;
}
#emailcertified-container #certified{
	margin: 0 auto;
	position: relative;
	top:50px;
	left:25px;
}
#emailcertified-container #check{
	margin: 0 auto;
	position: relative;
	top:52px;
	background-color: rgba(142, 40, 170, 0.65);
    color: rgb(248, 248, 248);
    border: 0;
    cursor: pointer;
    border-radius: 3px;
    left:25px;
}

</style>
</head>
<body>
	<div id="emailcertified-container">
		<label for="certified">인증번호 : </label>
		<input type="textname="certified" id="certified"/>
		<input type="button" value="확인" id="check" onclick="check();"/>
	</div>
</body>
</html>