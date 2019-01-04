<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 경국이의 테스트 -->
<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
  <script src="js/jquery-3.3.1.js"></script>
  <title>7 Scheduler</title>

</head>

<body>
  <nav class="header">
    <div class="logo">
      <img src="<%=request.getContextPath() %>/images/logo.png" width="50px" height="50px" >
      <span class="logofont">
        7' Scheduler
      </span>
    </div>
  </nav>
  <div class="content">
    <section>

        <img src="<%=request.getContextPath() %>/images/flower1.PNG" class="conimg" id="conimg1">
        <img src="<%=request.getContextPath() %>/images/flower2.PNG" class="conimg" id="conimg2">
        <img src="<%=request.getContextPath() %>/images/flower3.PNG" class="conimg" id="conimg3">

      <form class="loginFrm" name="loginform" action=" " method="post" onsubmit="return CheckLogin();">
        <div class="login_box">
          <div class="input_login">
            <input type="text" name="memberId" id="memberId" placeholder="아이디를 입력하세요">
          </div>
          <div class="input_login">
            <input type="password" name="memberPwd" id="memberPwd" placeholder="비밀번호를 입력하세요">
          </div>
          <br>
          <br>
          <div class="login">
            <input type="submit" value="로그인">
          </div>
          <hr>
        
          <div class="sns">
            <input type="submit" value="FaceBook으로 로그인">
          </div>
          <br>
        </div>
        <div class="signup_box">
          <span>계정이 없으신가요?<a href="">회원가입</a></span>
        </div>
      </form>
    </section>
  </div>

<script>

$(function(){
  $(".conimg").hide();
  $(".conimg:first").fadeIn();
  setInterval(function(){
      var $next = ($(".conimg").next().length)?
                  $(".conimg").next():$(".conimg:first");
      
      $("#conimg1").fadeOut();
      $next.fadeIn();
    },3000);

});
</script>




</body>

</html>