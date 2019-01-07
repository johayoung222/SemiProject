<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!doctype html>
<html>

<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- 폰트추가(폼상단) -->
 <link href="https://fonts.googleapis.com/css?family=Fredericka+the+Great%7C Rochester| Alfa+Slab+One| Staatliches| Noto+Sans+KR| Abril+Fatface" rel="stylesheet">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/register.css">

 <!-- 파비콘 적용링크 -->
 <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/logo(favicon).png" type="image/png" sizes="128x128">

 <script src="js/jquery-3.3.1.js"></script>
 <title>7 Scheduler(signup)</title>
<script>
function saveMember(){
	//아이디 유효성 검사
   	var memberId = document.getElementById('memberId');
    var password = document.getElementById('memberPwd');
    var password1 = document.getElementById('memberpwdcheck');
    var memberName = document.getElementById('memberName');
    var email = document.getElementById('memberEmail');
    
    //
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
 	
 	if(password.value!=password1.value){ 

        alert("비밀번호가 일치하지 않습니다.");
 	}
 
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


</head>

<body>
 
 <div class="content">
   <section>
     <form class="singupFrm" name="signupform" action="<%=request.getContextPath() %>/member/memberEnroll" method="post"
          onsubmit="return validate()" >

       <div class="signup_box">
           <span>7's Scheduler</span>
         <div class="input_login">
           <input type="text" name="memberId" id="memberId" placeholder="아이디를 입력하세요">
         </div>
         <div class="input_login">
           <input type="password" name="memberPwd" id="memberPwd" placeholder="비밀번호를 입력하세요">
         </div>
         <div class="input_login">
           <input type="password" name="memberpwdcheck" id="memberpwdcheck" placeholder="비밀번호를 다시 입력하세요">
         </div>
         <div class="input_login">
             <input type="text" name="memberName" id="memberName" placeholder="이름을 입력하세요">
         </div>
         <div class="input_login">
           <input type="email" name="memberEmail" id="memberEmail" placeholder="이메일을 입력하세요">
           &nbsp;&nbsp;
           <input type="button" id="emailclear" value="인증하기">
         </div>
         <div class="input_login">
           <input type="date" name="memberDate" id="memberDate" data-placeholder="생년월일을 입력하세요" required aria-required="true" >
         </div>
         <div class="input_login">
            <label for="male" id="man">남자</label>
            <input type="radio" name="gender" id="gender"
                   value="m" checked>
            &nbsp;&nbsp;
            <label for="female">여자</label>
            <input type="radio" name="gender" id="gender"
                   value="f">
         </div>
         <br>
         <div class="login">
           <input type="submit" value="회원가입" onclick="saveMember();" >
         </div>
       </div>
       <div class="login_box">
         <span>계정이 있으신가요?<a href="<%=request.getContextPath() %>/index.jsp">로그인</a></span>
       </div>
     </form>
   </section>
 </div>




</body>

</html>