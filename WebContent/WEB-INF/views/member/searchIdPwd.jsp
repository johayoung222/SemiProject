<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css">
  <title>아이디/비밀번호 찾기</title>
  <script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<style>
#table1 {
	border: 1px solid black;
	width: 50%;
	height: 200px;
	position:absolute;
}

#table2{
	border: 1px solid black;
	width: 50%;
	height: 200px;
	
	/* position: right; */
}
#table3{
	border: 1px solid black;
	width:100%;
	height:52px;
	text-align: center;
}
#button1{
	text-align: center;
	
}
#button2{
	
	margin-top: 13px;
    margin-right: 47px;
}
#button3{
	
	margin-top: 13px;
    margin-left: 127px;
    
}
#searchid{
	text-align: center;
}
#searchId2{
	text-align: center;
}
#searchId3{
	padding-top: 84px;
    padding-left: 102px;
}
#searchPwd2{
	text-align: center;
}
#permute{
	text-align: center;
}
#hidetable{
	border: 1px solid black;
	width: 50%;
	height: 200px;
	float: right;
	display:none;
	text-align: center;
	color: black;
	
}
#newPwd{
	padding:35px;
}
</style>
<script>
function searchid(){
	 var memberName = document.getElementById('userName_');
	 var memberEmail = document.getElementById('email_');
	 
	 if(memberName.value =="" ){
		 alert("이름을 입력해주세요 :(");
		 memberName.focus();
		 return false;
	 }
	 if(memberEmail.value =="" ){
		 alert("이메일을 입력해주세요 :(");
		 memberEmail.focus();
		 return false;
	 }	 
	 
	var param = {
			"pname":$("#userName_").val(),
			"pemail":$("#email_").val()
	}
	$.ajax({
		type: "post",
		url:"<%=request.getContextPath()%>/member/searchId",
		data: param,
	success: function(data){
		console.log(data);
		var html="<table>";
		if(data != null){
			html +="<tr><td id='searchId2'>"+"당신의 아이디는 "+data.memberId+" 입니다."+"</td></tr>";
			/* html +="<td>"+param.pemail+"</td></tr>"; */
		}else{
            html += "<tr><td id='searchId2'>"+"<bold>"+"이름과 이메일이 일치하지 않습니다."+"</bold>"+"</td></tr>";
        }
		html+="</table>";
		
		$("#table1").html(html);
	},
	error:function(){
		
	}
	});
}

function pwdPermute(){
	var memberId=$("#userId_").val();
	console.log(memberId);
	var memberEmail = $("#email__").val();
	console.log(memberEmail);
	var new_Password = $("#new_password").val();
	console.log(new_Password);
	var check_Password = $("#check_password").val();
	console.log(check_Password);
	 
	if(!chk(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/,new_Password,"패스워드는 숫자/문자/특수포함8~15자리")) 
        return false;
	
	if(new_Password != check_Password){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	function chk(re, e, msg) {
	    if (re.test(e)) {
	    return true;
	    }
	    alert(msg);
	    e.value = "";
	    e.focus();
	    return false;
	}

	var param = {
			"memberId":$("#userId_").val(),
			"memberEmail":$("#email__").val(),
			"new_Password":$("#new_password").val()
	}
	console.log(param);
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/member/pwdPermute",
		data:param,
		success:function(data){
			console.log(data); 
			if(data != 0){
			var html="<table>";
				html +="<tr><td id='searchId3'>"+"비밀번호가 변경되었습니다."+"</td></tr>";
				html+="</table>";
			
			$("#hidetable").html(html);
			}else{
				alert("hh");
			}
		}
	});

	return true;
	
}

function sendMail(){
	var memberId=$("#userId_").val();
	var memberEmail = $("#email__").val();
	
	if(memberId.trim().length == 0){
        alert("아이디를 입력하세요.");
        return false;		
	}
	else if(memberEmail.trim().length == 0){
        alert("이메일을 입력하세요.");
        return false;
    }
    //팝업창을 target으로 폼전송
      var target = "checkEmailCertifiedPassword";
      //첫번째 인자 url은 생략, form의 action값이 이를 대신한다.
      var popup = open("", target, "left=700px, top=300px, height=135px, width=470px");
      //폼의 대상을 작성한 popup을 가리키게 한다.
      checkEmailCertifiedPasswordFrm.target = target;
      
      //console.log(memberEmail);
      
      checkEmailCertifiedPasswordFrm.memberEmail.value = memberEmail;
      checkEmailCertifiedPasswordFrm.memberId.value = memberId;
      
      checkEmailCertifiedPasswordFrm.submit();
}
</script>
</head>

<body>
<nav class="header">
    <div class="logo">
      <img src="<%=request.getContextPath() %>/images/logo.png" width="50px" height="50px" >
      <span class="logofont">7' Scheduler
      </span>
    </div>  
</nav>
	<div id="userIdPwd">
	<form action="<%=request.getContextPath()%>/member/searchIdPwd"
			name="searchIdPwd_" method="post">
			<table id="table1" style="float: left">
				<tr>
					<th class="searchid">아이디 찾기</th>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName" id="userName_" placeholder="이름을 입력하세요" required /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" id="email_" placeholder="이메일을 입력하세요" required /></td>
				</tr>
				 <tr>
                  	<td colspan="2" id="button1">
                  		<input type="button" value="아이디 찾기" onclick="searchid()" />
                  		
                  	</td>
                  </tr>
			</table>
	</form>
			<form action="<%=request.getContextPath()%>/member/checkEmailCertifiedPassword"
			name="checkEmailCertifiedPasswordFrm" method="post">
			<table id="table2" style="float: right">
				<tr>
					<th id="searchid">비밀번호 찾기</th>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userId" id="userId_" placeholder="아이디를 입력하세요" required /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" id="email__" placeholder="이메일을 입력하세요" required /></td>
				 <tr>
                  	<td colspan="2" id="button2">
                  		<input type="button" onclick="sendMail();" value="비밀번호 찾기" />
                  		
                  	</td>
                 </tr>
			</table>
			
			<form action="<%=request.getContextPath()%>/member/pwdPermute"
			 name="pwd" method="post">
				<input type="hidden" name="memberEmail" />
				<input type="hidden" name="memberId" />
				
				<table id="hidetable">
					<tr>
					<th id="permute">새 비밀번호 설정</th>
				</tr>
				<tr>
					<th id="newPwd">새 비밀번호</th>
					<td><input type="password" name="new_password" id="new_password" placeholder="새 비밀번호" required /></td>
				</tr>
				<tr>
					<th>새 비밀번호 확인</th>
					<td><input type="password" name="check_password" id="check_password" placeholder="새 비밀번호 확인" required /></td>
				 <tr>
                  	<td colspan="2" >
                  		<input type="button" id="button3" onclick="pwdPermute();" value="비밀번호 변경" />
                  	</td>
                 </tr>
				</table>
			</form>
	
			<table id="table3">
				 <tr>
					<td>
                  		<input type="button" onclick="self.close();" value="취소"  />
                  	</td>
                  </tr>
			</table>

		
	</div>

</body>
</html>