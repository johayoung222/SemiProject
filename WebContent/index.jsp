<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/header.jsp" %>

 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
 <div class="content">
   <section>
     <div id="slideshow">
       <div>
         <img src="<%=request.getContextPath() %>/images/flower1.PNG" class="conimg" id="conimg1">
       </div>
       <div>
          <img src="<%=request.getContextPath() %>/images/flower2.PNG" class="conimg" id="conimg2">
       </div>
       <div>
              <img src="<%=request.getContextPath() %>/images/flower3.PNG" class="conimg" id="conimg3">
       </div>
     </div>
     <form class="loginFrm" name="loginform" action="<%=request.getContextPath() %>/member/login" method="post" onsubmit="return CheckLogin();">
       <div class="login_box">
         <div class="input_login">
           <input type="text" name="memberid" id="memberid" placeholder="아이디를 입력하세요.">
         </div>
         <div class="input_login">
           <input type="password" name="memberpwd" id="memberpwd" placeholder="비밀번호를 입력하세요">
         </div>
         <br>
         <br>
         <div class="login">
           <input type="submit" value="로그인">
         </div>
         <hr>
         <span>또는</span>
         <div class="sns">
           <input type="submit" value="FaceBook으로 로그인">
         </div>
         <br>
         <span>비밀번호를 잊으셨나요?</span>
       </div>
       <div class="signup_box">
         <span>계정이 없으신가요?<a href="<%=request.getContextPath() %>/member/moveEnroll">회원가입</a></span>
       </div>
     </form>
   </section>
 </div>
<script>
$("#slideshow > div:gt(0)").hide();
setInterval(function(){
 $("#slideshow > div:first").fadeOut(1000).next().fadeIn(1000).end().appendTo("#slideshow");
} , 3000);

</script>
</body>
</html>