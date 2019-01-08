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
 <script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
 
 <title>7 Scheduler(signup)</title>



</head>

<body>
 
 <div class="content">
   <section>
   <form action="<%=request.getContextPath()%>/member/checkIdDuplicate"
	  method="post"
	  name="checkIdDuplicateFrm">
	<input type="hidden" name="memberId" />
       </form>
     <form class="singupFrm" name="signupform" action="<%=request.getContextPath() %>/member/memberEnroll" method="post"
          onsubmit="return validate();" >

       <div class="signup_box">
           <span>7's Scheduler</span>
         <div class="input_login">
           <input type="text" name="memberId" id="memberId_" placeholder="아이디를 입력하세요">
           &nbsp;&nbsp;
           <input type="button" id="idCheck" value="중복검사" onclick="checkIdDuplicate();"/>
           <input type="hidden" name="idValid" id="idValid"   value="0" />
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
                   value="M" checked>
            &nbsp;&nbsp;
            <label for="female">여자</label>
            <input type="radio" name="gender" id="gender"
                   value="F">
         </div>
         <br>
         <div class="login">
           <input type="submit" value="회원가입" >
         </div>
       </div>
       <div class="login_box">
         <span>계정이 있으신가요?<a href="<%=request.getContextPath() %>/index.jsp">로그인</a></span>
       </div>
     </form>
   </section>
 </div>

<script>
  function validate(){
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  function checkIdDuplicate(){
		//아이디중복검사폼을 전송.
		var memberId = $("#memberId_").val().trim();
		if(memberId.length < 4){
			return;
		}
		
		//팝업창을 target으로 폼전송
		var target = "checkIdDuplicate";
		//첫번째 인자 url은 생략, form의 action값이 이를 대신한다.
		var popup = open("", target, "left=300px, top=100px, height=200px, width=500px");
		
		checkIdDuplicateFrm.memberId.value = memberId;
		//폼의 대상을 작성한 popup을 가리키게 한다. 
		checkIdDuplicateFrm.target = target;
		checkIdDuplicateFrm.submit();
		
	}


</script>




</body>

</html>