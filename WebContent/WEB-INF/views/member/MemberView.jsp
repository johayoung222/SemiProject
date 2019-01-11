<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
         Member m = (Member)request.getAttribute("member");
         
		 String memberId_ = m.getMemberId();
		 String memberPwd = m.getMemberPwd();
		 String memberName = m.getMemberName();
		 int memberDate = m.getMemberAge();
		 String memberemail = m.getMemberEmail();
		 String gender = m.getMemberGender();





%>
<!doctype html>
<html>

<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- 폰트추가(폼상단) -->
 <link href="https://fonts.googleapis.com/css?family=Fredericka+the+Great%7C Rochester| Alfa+Slab+One| Staatliches| Noto+Sans+KR| Abril+Fatface" rel="stylesheet">

 <!-- 파비콘 적용링크 -->
 <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/logo(favicon).png" type="image/png" sizes="128x128">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberView.css">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/side.css">
 <link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
 <script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
 
 <title>7 Scheduler(MemberView)</title>



</head>

<body>
 
 <div class="content">
   <section>
   <h2>내 정보</h2>
   <form class="updateFrm" action="<%=request.getContextPath()%>/member/memberUpdateEnd"
	  method="post"
	  name="memberUpdateform"
	  onsubmit="return saveMember();">
	
       <div class="update_box">
           <span>7's Scheduler 회원 정보</span>
         <div class="input_login">
         	<label for="memberId">아이디:</label>
           <input type="text" name="memberId" id="memberId_"  value="<%=memberId_%>" required readonly />
         </div>
         <div class="input_login">
             <label for="memberName">이름:</label>
             <input type="text" name="memberName" id="memberName"  value="<%=memberName %>" required  />
         </div>
         <div class="input_login">
           <label for="memberEmail">이 메일:</label>
           <input type="email" name="memberEmail" id="memberEmail" value="<%=memberemail%>" readonly />
           &nbsp;&nbsp;
         </div>
         <div class="input_login">
           <label for="memberDate">생년 월일:</label>
           <input type="number" name="memberDate" id="memberDate" value="<%=memberDate%>" readonly />
           &nbsp;&nbsp;
         </div>
       
         <br />
         <div class="gender">
                   <input type="radio" 
		  				   name="gender" 
		  				   id="gender0"
		  				   value="M"
		  				   <%="M".equals(gender)?"checked":"" %>/>
		  			<label for="gender0">남</label>
		  			<input type="radio" 
		  				   name="gender" 
		  				   id="gender1"
		  				   value="F"
		  				   <%="F".equals(gender)?"checked":"" %>/>
		  			<label for="gender1">여</label>
         </div>
         
         
         <br>
         <br />
         <br />
         <div class="login">
           <input type="submit" value="회원정보 수정" >
         </div>
         <br />
        
         <div class="update">
           <input type="button" value="패스워드수정" onclick="updatePassword();" >
         </div>
       
         <br />
         <div class="delete">
           <input type="button" value="회원탈퇴" onclick="deleteMember();" >
         </div>
       </div>
      
       
     </form>
   </section>
 </div>

<script>
 
 
 
  function saveMember(){
      //아이디 유효성 검사
     var memberId = document.getElementById('memberId_');
     var password = document.getElementById('memberPwd');
     var password1 = document.getElementById('memberpwdcheck');
     var memberName = document.getElementById('memberName');
     var email = document.getElementById('memberEmail');


     if(!chk(/^[a-z][a-z\d]{4,12}$/, memberId, "아이디는  숫자 포함 영대소문자, 4~12자 입력할것!"))
         return false;

   
      if(!chk(/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,15}$/,password,"패스워드는 숫자/문자/특수포함8~15자리"))
          
          return false;
      if(password.value!=password1.value){

         alert("비밀번호가 일치하지 않습니다.");
         return false;
      }
      
      if(!chk( /^[가-힣]{2,4}$/,memberName,"한글 2글자 이상"))
          return false;
      
      if(!chk(/^[0-9a-zA-Z]([\-.\w]*[0-9a-zA-Z\-_+])*@([0-9a-zA-Z][\-\w]*[0-9a-zA-Z]\.)+[a-zA-Z]{2,9}$/i,email,"이메일형식을 입력하세요." ))
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
    return true;
  }

  function deleteMember(){
	  
	  var bool = confirm("정말로 탈퇴하시겠습니까?");
		if(bool){
			var frm = document.memberUpdateform;
			frm.action = "<%=request.getContextPath()%>/member/memberDelete";
			frm.submit();
			
		}
	  
	  
  }
  function updatePassword(){
	  var memberId_ = document.getElementById('memberId_');
	  var url = "<%=request.getContextPath()%>/member/updatePassword?memberId=<%=memberId_%>";
	  var title = "udatePassword";
	  var status = "left=500px, top=200px, width=500px, height=350px";
	  open(url, title, status);
	  
	  
  }


</script>




</body>

</html>