<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script>
function saveMember(){
	//아이디 유효성 검사

/* 	var memberId =$("#ckuserId_");
    if(!(memberId >= '0' && memberId <= '9') && !(memberId >= 'a' && memberId <= 'z')&&!(memberId >= 'A' && memberId <= 'Z')){
        alert("영소문자 4~12자리여야 합니다.");
        memberId.focus();
        return false;

    } 
    var memberPwd =$("#ckpwd");
    if(!(memberPwd )) */
 
   	var memberId = document.getElementById('ckuserId');
    var password = document.getElementById('ckpwd');
    var password1 = document.getElementById('checkPwd');
    var memberName = document.getElementById('ckuserName');
    var email = document.getElementById('ckemail');
    if(!chk(/^[a-z][a-z\d]{3,11}$/, memberId, "영대소문자, 4~12자 입력할것!"))
        return false;

 	if(!chk(/[0-9]/, memberId, "숫자 하나이상포함해주세요."))
        return false;
 	
 	if(!chk(/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,15}$/,password,"숫자/문자/특수포함8~15자리"))
 		
 		return false;
 	
 	if(!chk( /^[가-힣]{2,4}$/,memberName,"한글 2글자 이상"))
 		return false;
 	
 	if(!chk(/^[0-9a-zA-Z]([\-.\w]*[0-9a-zA-Z\-_+])*@([0-9a-zA-Z][\-\w]*[0-9a-zA-Z]\.)+[a-zA-Z]{2,9}$/i,email,"이메일을 입력하세요." ))
 		return false;
 	
 	
 	
 	
 	
	



   	
	
    	function chk(re, e, msg) {
        if (re.test(e.value)) {
        return true;
        }
        alert(msg);
        e.value = "";
        e.focus();
        return false;

 }
    



}

</script>

<section>

	<form name="regform" action="<%=request.getContextPath() %>/member/memberEnroll" method="POST" onsubmit="return validate()">
<div class="join_box">
	<h2>please... input your Information!</h2>
	<br> <br>
	<table id="enroll">
		<tr>
			<th>*아이디:</th>
			<td><input type="text" name="memberId" id="ckuserId" placeholder="영소문자로 시작 4~12자리" required></td>
		</tr>
		<tr>
			<th>*비밀번호:</th>
			<td><input type="password" name="memberPwd" id="ckpwd" placeholder="숫자/문자/특수포함 8~15자리" required></td>
		</tr>
		<tr>
			<th>*비밀 번호 확인:</th>
			<td><input type="password" id="checkPwd" placeholder="password를 재입력 해주세요" required></td>
		</tr>
		<tr>
			<th>*이름:</th>
			<td><input type="text" name="memberName" id="ckuserName" placeholder="이름을 입력해주세요" required></td>
		</tr>
		<tr>
			<th>*생년월일:</th>
			<td><input type="text" name="ssn" id="ckssn1" class="ssn" placeholder="주민번호 앞 6자리" required></td>
		</tr>
		<tr>
			<th>*성별:</th>
			<td>
				<label for="mail">남성</label>
				<input type="radio" id="mail" value="M" name="gender"/>
				<label for="femail">여성</label>
				<input type="radio" id="femail" value="F" name="gender"/>
			</td>
		</tr>
		<tr>
			<th>이메일:</th>
			<td><input type="email" name="email" id="ckemail" placeholder="email을 입력해주세요"></td>
		</tr>
		
	</table>
	<br> <br> <br>
	<div class="join">
		<input type="submit" value="Join" onclick="saveMember();">
	</div>
	<br>
	<div class="cancel">
		<input type="reset" value="cancel" id="Cancel" class="cancel" onclick="history.back(-10)">
	</div>
	</div>
</form>
</section>
</body>
</html>