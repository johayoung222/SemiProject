<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!doctype html>
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://fonts.googleapis.com/css?family=Anton|Coiny|Do+Hyeon|Gothic+A1|Nanum+Gothic+Coding|Nanum+Pen+Script|Noto+Sans+KR|Pacifico" rel="stylesheet">
 <!-- 폰트추가(폼상단) -->
 <link href="https://fonts.googleapis.com/css?family=Fredericka+the+Great%7C Rochester| Alfa+Slab+One| Staatliches| Noto+Sans+KR| Abril+Fatface" rel="stylesheet">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/register.css">
 <!-- 파비콘 적용링크 -->

 <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/logo(favicon).png" type="image/png" sizes="128x128">
 <script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
 
 <title>7 Scheduler(signup)</title>

</head>
<body>
	<form action="<%=request.getContextPath()%>/member/checkEmailCertified"
	  			 method="get"
	  			 name="checkEmailCertifiedFrm">
			<input type="hidden" name="memberEmail" value=""/>
	</form>

 
 <div class="content">
   <section>
   	
   <form action="<%=request.getContextPath()%>/member/checkIdDuplicate"
      method="post"
      name="checkIdDuplicateFrm">
    <input type="hidden" name="memberId" />
       </form>
     <form class="singupFrm" name="signupform" action="<%=request.getContextPath() %>/member/memberEnroll" method="post" onsubmit="return saveMember();" >
  
       <div class="signup_box">
           <span>7's Scheduler</span>
         <div class="input_login">
           <input type="text" name="memberId" id="memberId_" placeholder="ID 입력(영대소문자, 4~12자 입력)">
           &nbsp;&nbsp;
           <input type="button" id="idCheck" value="중복검사" onclick="checkIdDuplicate();"/>
           <input type="hidden" name="idValid" id="idValid"  value="0" />
         </div>
         <div class="input_login">
           <input type="password" name="memberPwd" id="memberPwd" placeholder="비밀번호를 입력하세요.(숫자/문자/특수포함 8~15자리)">
         </div>
         <div class="input_login">
           <input type="password" name="memberpwdcheck" id="memberpwdcheck" onkeyup="checkPwd()" placeholder="비밀번호를 다시 입력하세요">
            <br />
            <br />
            <div id="checkPwd"></div>          
         </div>
         <div class="input_login">
             <input type="text" name="memberName" id="memberName" placeholder="이름을 입력하세요(두글자 이상)">
         </div>
         <div class="input_login">
           <input type="email" name="memberEmail" id="memberEmail" placeholder="이메일을 입력하세요">
           &nbsp;&nbsp;
           <input type="button" name="emailclear" id="emailclear" value="인증하기" onclick="sendMail();">
           <input type="hidden" name="target" id="result" value="0"/>
         </div>
         <div class="input_login">
           <input type="date" name="memberDate" id="memberDate" data-placeholder="생년월일을 입력하세요" required aria-required="true" >         
         </div>
         <div class="input_login">
            <label for="male" id="man">남자</label>
            <input type="radio" name="gender" id="gender0"
                   value="M" checked>
            &nbsp;&nbsp;
            <label for="female">여자</label>
            <input type="radio" name="gender" id="gender1"
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
 
  
  function checkIdDuplicate(){
        //아이디중복검사폼을 전송.
        var memberId = $("#memberId_").val().trim();
        if(memberId.length == 0 ){
             alert("공백은 아이디로 만들수 없습니다");
             return false;
        }
        
         
    
        
        //팝업창을 target으로 폼전송
        var target = "checkIdDuplicate";
        //첫번째 인자 url은 생략, form의 action값이 이를 대신한다.
        var popup = open("", target, "left=300px, top=100px, height=50px, width=300px");
        
        checkIdDuplicateFrm.memberId.value = memberId;
        //폼의 대상을 작성한 popup을 가리키게 한다. 
        checkIdDuplicateFrm.target = target;
        checkIdDuplicateFrm.submit();
        
    }
  
 
  function saveMember(){
      //아이디 유효성 검사
     var memberId = document.getElementById('memberId_');
     var password = document.getElementById('memberPwd');
     var password1 = document.getElementById('memberpwdcheck');
     var memberName = document.getElementById('memberName');
     var email = document.getElementById('memberEmail');
     var result = $("#result").val();
     
     //아이디
     if(!chk(/^[a-z][a-z\d]{4,12}$/, memberId, "아이디는  숫자 포함 영대소문자, 4~12자 입력할것!"))
         return false;
      if(!chk(/[0-9]/, memberId, "아이디는 꼭 숫자 하나이상포함해주세요."))
         return false;
      
      //비밀번호
      if(!chk(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/,password,"패스워드는 숫자/문자/특수포함8~15자리")) 
          return false;

      if(password.value!=password1.value){
         alert("비밀번호가 일치하지 않습니다.");
         return false;
      }
      
      //이름
      if(!chk( /^[가-힣]{2,4}$/,memberName,"한글 2글자 이상"))
          return false;
      
      //이메일
      if(!chk(/^[0-9a-zA-Z]([\-.\w]*[0-9a-zA-Z\-_+])*@([0-9a-zA-Z][\-\w]*[0-9a-zA-Z]\.)+[a-zA-Z]{2,9}$/i,email,"이메일형식을 입력하세요." ))
          return false;
      if(result == 0){
    	  alert("이메일 인증을 해주세요!");
    	  return false;
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
    return true;
  }
 function checkPwd(){
    
    var pw1 = document.getElementById('memberPwd').value;
    var pw2 = document.getElementById('memberpwdcheck').value;
    
    if(pw1 !='' && pw2 != ''){
    if(pw1 == pw2){
        result ='<div id="result_true">비밀번호가 일치합니다.:)</div>';
        document.getElementById('checkPwd').innerHTML = result;
        document.getElementById('checkPwd').style.color = "blue";
    }else{
        result ='<div id="result_false">비밀번호가 일치하지 않습니다.:(</div>';
         document.getElementById('checkPwd').innerHTML = result;
         document.getElementById('checkPwd').style.color = "red";
        
      }
    } 
     
 }
 function sendMail(){
	  var memberEmail = $("#memberEmail").val();
	  if(memberEmail.trim().length == 0){
		  alert("이메일을 입력하세요.");
		  return false;
	  }
	  //팝업창을 target으로 폼전송
		var target = "checkEmailCertified";
		//첫번째 인자 url은 생략, form의 action값이 이를 대신한다.
		var popup = open("", target, "left=300px, top=100px, height=135px, width=470px");
		//폼의 대상을 작성한 popup을 가리키게 한다. 
		checkEmailCertifiedFrm.target = target;
		
		//console.log(memberEmail);
		
		checkEmailCertifiedFrm.memberEmail.value = memberEmail;
		checkEmailCertifiedFrm.submit();		
 }

 
 </script>



</body>
</html>