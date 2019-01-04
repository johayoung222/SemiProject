<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
  <script src="js/jquery-3.3.1.js"></script>
  <title>7 Scheduler</title>

  <style media="screen">


    * {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    }

    body {
    padding: 0;
    margin: 0;
    font-family: 'Open Sans', Arial, sans-serif;
    color: #333;
    
    background-color: rgb(248, 248, 248);
    }

    p {
    line-height: 1.75;
    }

    section {
    padding: 40px;
    }


    .content {
    margin-top: 80px;
    width: 100%;
    height: 764px;
    background-color: rgb(248, 248, 248);
    }

    .contained {
      width: 728px;
      margin: 0 auto;
    }

    /* @media (max-width: 41em) {
    .contained {
      width: 100%;
    }
    } */


    nav {
    /* position: fixed; */
    position: relative;
    top: 0;
    left: 0;
    width: 100%;
    height: 60px;
    background-color: rgb(206, 219, 186);
    color:#fff;
    z-index: 1000;
    }

    nav .logo {
    float: left;
    font-size: 1.5em;
    font-family: 'Staatliches', cursive;
    padding: 5px;
    margin: 0 auto;
    text-align: center;
    }
  

    nav ul {
    float: right;
    list-style: none;
    margin: 0;
    padding: 0;
    }

    nav ul li {
    display: inline-block;
    line-height: 35px;
    padding: 5px, 10px;
    font-family: 'Alfa Slab One', cursive;
    font-size: 30px;
    transform: translateY(10px);
    }

    nav ul li:hover{
      color: lightgray;
      border: black;
    }

    .loginFrm{
      float:right;
      margin: 0px 180px 0px 0px;
    }
    .logofont{
      position: relative;
      top: -17px;
    }
    .con{
      width: 520px;
      height: 500px;
      margin-left: 90px;
      display: inline-block;
      background: beige;
      border: 1px solid rgb(248, 248, 248);
      border-radius:50px; 
    }
    .conimg{
      width:520px;
      height: 500px;
      position: absolute;
      border: red;
      border-radius: 50px;
      visibility: visible;
    }
  
    


/* login */
.login_box { width:500px; height:400px; padding: 50px 30px 30px 50px; margin: 0 auto; background-color:rgba(255, 255, 255, 0.993); opacity: 0.8; 
	border-radius:7px; border: 1px solid rgb(248, 248, 248); }
.signup_box { width:500px; height:100px; padding: 35px 30px 30px 50px; margin:0 auto ; background-color:rgba(255, 255, 255, 0.993); opacity: 0.8; 
	border-radius:7px; border: 1px solid rgb(248, 248, 248); text-align: center; font-size: 18px;}

.login_box .input_login { border-bottom: 2px solid #c4c5c4; padding: 20px 0 9px 0; font:bolder;}
.login_box .input_login input { width: 100%; color: #828180; font-size: 15px; border:none; font-family: 'Noto Sans KR', sans-seri;}

.login_box .check { color: #000; font-size: 14px; padding: 9px 0 15px 0; font-family: 'Noto Sans KR', sans-seri;}

.login_box  .login input { width:100%; height:50px; background-color:rgb(156, 36, 167); color:rgb(248, 248, 248); font-size:16px; 
          padding:17px 0 16px; border:0; cursor:pointer; font-family: 'Noto Sans KR', sans-seri;}
.login_box span{font-family: 'Noto Sans KR', sans-seri;  font-size: 18px; padding: 0px 190px}
.login_box  .sns input {
  width:100%; height:50px; background-color:rgb(40, 77, 170); color:rgb(248, 248, 248); font-size:16px; 
				  padding:3px 17px 0 16px; border:0; cursor:pointer; font-family: 'Noto Sans KR', sans-seri; transform: translateY(20px)}



.login_box .last {float: right; width:100%; margin-top:30px; border-top:1px solid #ebebeb; padding-top:20px; }
.login_box .last .join {font-size: 30px;}
.login_box .last .search { float:right;}
.login_box .last .join a { color:#00a6de;}
.login_box .last .search a { color:#626262;} 
.login_box .last { width:100%; margin-top:10px; border-top:1px solid #ebebeb; padding-top:20px; font:bolder; font-size: 30px ;	 font-family: 'Abril Fatface', cursive;}
.login_box .last .join { float:left;}
.login_box .last .join a { color:rgb(14, 13, 13); border-radius: 20%; font:bolder;} 
.login_box .last .join a:hover { color:rgb(183, 152, 224); border-radius: 20%; font:bolder;}


        
    </style>

</head>

<body>
  <nav class="header">
    <div class="logo">
      <img src="logo.png" width="50px" height="50px" >
      <span class="logofont">
        7' Scheduler
      </span>
    </div>
  </nav>
  <div class="content">
    <section>
      <div class="con">
        <img src="flower1.PNG" class="conimg" id="conimg1">
        <img src="flower2.PNG" class="conimg" id="conimg2">
        <img src="flower3.PNG" class="conimg" id="conimg3">
      </div>
      <form class="loginFrm" name="loginform" action="mypage.html" method="post" onsubmit="return CheckLogin();">
        <div class="login_box">
          <div class="input_login">
            <input type="text" name="memberid" id="memberid" placeholder="아이디를 입력하세요">
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
        </div>
        <div class="signup_box">
          <span>계정이 없으신가요?<a href="">회원가입</a></span>
        </div>
      </form>
    </section>
  </div>

<script>

// $(function(){
//   $(".conimg").hide();
//     $(".conimg:first").fadeIn();
//     $(".conimg").click(function(){
//         var $next = ($(this).next().length)?
//                     $(this).next():$(".conimg:first");
        
//         $(this).fadeOut();
//         $next.fadeIn()
//   });
// });
$(function(){
  $(".conimg").hide();
  $(".conimg:first").fadeIn();
  setInterval(function(){
      var $next = ($(".conimg").next().length)?
                  $(".conimg").next():$(".conimg:first");
      
      // $(this).fadeOut();
      $next.fadeIn();
    },3000);

});
</script>




</body>

</html>