<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>


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
    background-color: rgb(248, 248, 248);
    }

    .contained {
  width: 728px;
  margin: 0 auto;
    }

    @media (max-width: 41em) {
    .contained {
      width: 100%;
    }
    }

    .clear {
    clear: both;
    }

    nav {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    background-color: rgb(75, 0, 126);
    color:#fff;
    z-index: 1000;
    }

    nav .nav-main {
    padding: 5px 20px;
    }

    nav .nav-actions {
      height: 45px;
      line-height: 40px;
      padding: 0 20px;
      background-color: rgb(36, 175, 129);
    }

    nav .logo {
    float: left;
    line-height: 50px;
    font-size: 1.5em;
    
    font-family: 'Staatliches', cursive;
    padding: 5px;
    margin: 0 auto;
   
    
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


    section>img{
      z-index: -100;
      padding: 50px;

    }
    

 /* footer */
    footer {
            width: 100%;
            height: 100px;
            background-color: #000000da;
            color: white;
            font-size: 20px;
            text-align: center;
            line-height: 50px;
            padding: 0 ;
            margin: 0 auto;
            position: fixed;
            transform: translateY(200px);

        }
/* login */
.login_box { width:600px; height:500px; padding: 50px 30px 30px 50px; margin: 0 auto; background-color:rgba(255, 255, 255, 0.993); opacity: 0.8; 
	border-radius:5px; border: 1px solid rgb(248, 248, 248);; transform: translateX();}
.login_box .input_login { border-bottom: 2px solid #c4c5c4; padding: 20px 0 9px 0; font:bolder;}
.login_box .input_login input { width: 100%; color: #828180; font-size: 15px; border:none; font-family: 'Noto Sans KR', sans-seri;}

.login_box .check { color: #000; font-size: 14px; padding: 9px 0 15px 0; font-family: 'Noto Sans KR', sans-seri;}

.login_box  .login input { width:100%; height:55px; background-color:rgb(30, 6, 75); color:rgb(248, 248, 248); font-size:16px; 
          padding:17px 0 16px; border:0; cursor:pointer; font-family: 'Noto Sans KR', sans-seri;}
.login_box span{font-family: 'Noto Sans KR', sans-seri;  font-size: 18px; padding: 0px 240px}
.login_box  .sns input {
  width:100%; height:55px; background-color:rgb(66, 103, 178); color:rgb(248, 248, 248); font-size:16px; 
				  padding:3px 17px 0 16px; border:0; cursor:pointer; font-family: 'Noto Sans KR', sans-seri; transform: translateY(20px)}



.login_box .last { width:100%; margin-top:30px; border-top:1px solid #ebebeb; padding-top:20px;}
.login_box .last .join { float:left;}
.login_box .last .search { float:right;}
.login_box .last .join a { color:#00a6de;}
.login_box .last .search a { color:#626262;} 
.login_box .last { width:100%; margin-top:10px; border-top:1px solid #ebebeb; padding-top:20px; font:bolder; font-size: 30px ;	 font-family: 'Abril Fatface', cursive;}
.login_box .last .join { float:left;}
.login_box .last .join a { color:rgb(14, 13, 13); border-radius: 20%; font:bolder;} 
.login_box .last .join a:hover { color:rgb(183, 152, 224); border-radius: 20%; font:bolder;}


        
    </style>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/landing.css" />

  <div class="content">
    <section>
        <span>Login</span>
        
    
        <form name="loginform" action="mypage.html" method="post" onsubmit="return CheckLogin();">
            <div class="login_box">
              <div class="input_login">
                <input type="text" name="logckuid" id="logckuid" placeholder="아이디를 입력하세요">
              </div>
              <div class="input_login">
                <input type="password" name="logckpwd" id="logckpwd" placeholder="비밀번호를 입력하세요">
              </div>
              <div class="last">
              <div class="join"><a href="join.html">☞ go to sign up</a></div>
              <br>
              <br>
              <div class="login">
                <input type="submit" value="LOGIN">
              </div>
              
              <hr>
              <span>또는</span>
              
              <div class="sns">
                  <input type="submit" value="FaceBook login" >
                </div>
          
              <br>
              <br>
    
    
              
    
                </div>
              </div>
            </div>
        </div>
        </form>
   
      </div>
      
      
      <footer>
          <span>Copyrightⓡ windowSide Front Group: semiProject </span>
              </footer>
    </section>


  
 
<script type="text/javascript">
(function($) {
  $.fn.semisticky = function(options) {
  return this.each(function() {
    new SemiSticky($(this), options);
  });
  };
}(jQuery));

var SemiSticky = function(element, options) {
  var _this = this;
  
  options = $.extend({
  offsetLimit: element.outerHeight(),
  scrollThreshold: 50,
  onScroll: function() {}
  }, options);
  
  this.element = element;
  this.state = 'fixed';
  this.currentOffsetAmount = 0;
  
  this.init = function() {
  var oldScrollTop = $(document).scrollTop();
  var thresholdCounter = 0;
  
  $(window).on('scroll.semisticky', function() {
    var newScrollTop = $(document).scrollTop();
    var delta = oldScrollTop - newScrollTop;
    thresholdCounter = Math.min(Math.max(thresholdCounter + delta, -options.scrollThreshold), options.scrollThreshold);
    var newOffset;

    if (Math.abs(thresholdCounter) >= options.scrollThreshold || _this.state == 'scrolling') {
    if (delta < 0 && _this.state !== 'hidden') {
      
      if (_this.currentOffsetAmount > -options.offsetLimit) {
      _this.currentOffsetAmount = Math.max(_this.currentOffsetAmount + delta, -options.offsetLimit);
      _this.element.css('top', _this.currentOffsetAmount);
      _this.state = 'scrolling';
      } else {
      _this.state = 'hidden';
      thresholdCounter = 0;
      }
      
    } else if (delta > 0 && _this.state !== 'fixed') {
      
      if (_this.currentOffsetAmount < 0) {
      _this.currentOffsetAmount = Math.min(_this.currentOffsetAmount + delta, 0);
      _this.element.css('top', _this.currentOffsetAmount);
      _this.state = 'scrolling';
      } else {
      _this.state = 'fixed';
      thresholdCounter = 0;
      }
      
    }
    }
    
    options.onScroll.call(_this, delta);
    
    oldScrollTop = newScrollTop;
  });
  };
  
  this.die = function() {
  $(window).off('scroll.semisticky');
  };
  
  this.init();
};

</script>
  
  <script>
    $('nav').semisticky({
      offsetLimit: $('.nav-actions').outerHeight(),
    })
  </script>

</body>
</html>