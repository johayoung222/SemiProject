<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/header.jsp" %>



<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
<link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One%7CStaatliches%7CNoto+Sans+KR%7CAbril+Fatface" rel="stylesheet">

<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<title>7 Scheduler</title>
<style>
#back {
float: right;
margin-right: 450px;
}
#login_box{
	margin-left: 60%;
}
</style>

<script>

function back(){
	backFrm.submit();
}

<%--로그인 유효성 검사--%>
function CheckLogin(){
	if($("#memberId").val().trim().length == 0){
		alert("아이디를 입력하세요.");
		$("#memberId").focus();
		return false;//폼 전송방지
	}
	if($("#memberPwd").val().trim().length == 0){
		alert("비밀번호를 입력하세요.");
		$("#memberPwd").focus();
		return false;
	}	
	return true;
}

function searchIdPwd(){     
	   var url = "<%=request.getContextPath()%>/member/searchIdPwd";
	   var title = "searchIdPwd";
	   var status = "left=300px, top=100px, width=800px, height=300px";
	   
	  open(url, title, status);
   
}


</script>
</head>

<body>
 
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
     <%if(memberLoggedIn == null){ %>
     <!-- login form -->
     <form class="loginFrm" name="loginform" action="<%=request.getContextPath()%>/member/login" method="post" onsubmit="return CheckLogin();">
       <div class="login_box">
         <div class="input_login">
           <input type="text" name="memberId" id="memberId" placeholder="아이디를 입력하세요." >
         </div>
         <div class="input_login">
           <input type="password" name="memberPwd" id="memberPwd" placeholder="비밀번호를 입력하세요">
         </div>
         <br>
         <br>
         <div class="login">
         
         <!-- login 유효성 검사 -->
           <input type="submit" value="로그인">
         </div>
         <hr>
         <span>또는</span>
         <div class="sns">
          <input type="button" value="FaceBook으로 로그인">
         </div>
         <span id="search_" onclick="searchIdPwd();">비밀번호를 잊으셨나요?</span>
       </div>
       <div class="signup_box">
         <span>계정이 없으신가요?<a href="<%=request.getContextPath() %>/member/moveEnroll">회원가입</a></span>
       </div>
     </form>
     <% }else{ %>
     <div class="login_box" id="login_box">
     
     </div>
     <script>
     var memberId = "<%=memberLoggedIn.getMemberId()%>";
     	$.ajax({
			url: "<%=request.getContextPath()%>/schedule/daySchedule.do",
			type: "get",
			dataType: "json",
			data: "memberId="+memberId,
			success: function (data) {
				
				for(var schedule in data){
					console.log(data); //data는 이미 javascript배열객체
					//json <----> javascript
					//	   <--- JSON.stringgify()
					//	  	---> JSON.parse()
					var table = $("<table></table>");
					var html = "<tr><th>타이틀</th></tr>";
					
					for(var i in data){
						var user = data[i];
						
						html += "<tr><td>"+user.scheduleTitle+"</td></tr>";
						
					}
					table.append(html);
					console.log(html);
					
					
					
					$("#login_box").html(table);
					
				}
				
				
				
			},
			error: function (jqxhr, textStatus, errorThrown) {
				console.log("ajax처리실패!");
				console.log(jqxhr);
				console.log(textStatus);
				console.log(errorThrown);
			}
			
		});
     
     
     
     </script>
     <div>
     <button id="back" onclick="back();">스케줄러 입장!</button>
     <form action="<%=request.getContextPath() %>/member/mainSchedule" name="backFrm" method="post">
     	<input type="hidden" name="memberId" value="<%=memberLoggedIn.getMemberId() %>"/>
     	<% if(request.getSession().getAttribute("exPwd") != null){
     		String exPwd = (String)request.getSession().getAttribute("exPwd");%>
     	<input type="hidden" name="memberPwd" value="<%=exPwd %>"/>
     	<%} %>
     </form>
     </div>
     <%} %>
     
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