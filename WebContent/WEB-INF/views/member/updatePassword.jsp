<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = request.getParameter("memberId");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 비밀번호 변경</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/css?family=Fredericka+the+Great%7C Rochester| Alfa+Slab+One| Staatliches| Noto+Sans+KR| Abril+Fatface" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/UpdatePassword.css">

</head>
<body>
	<div id="updatePassword-container">
		<form action="<%=request.getContextPath()%>/member/updatePasswordEnd"
			  name="updatePasswordFrm"
			  method="post">
			  <!-- table>(tr>th+td>input:password)*3 -->
			  <input type="hidden" 
			  		 name="memberId"
			  		 value="<%= memberId %>"  />
			  <table>
			  	<tr>
			  		<th>현재 비밀번호:</th>
			  		<td>
			  			<input type="password" 
			  				   name="memberPwd" 
			  				   id="password" 
			  				   required/>
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>새 비밀번호:</th>
			  		<td>
			  			<input type="password" 
			  				   name="memberPwd_new" 
			  				   id="password_new" 
			  				   required/>
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>새 비밀번호 확인:</th>
			  		<td>
						<input type="password" 
			  				   id="password_check" 
			  				   required/>
					</td>
			  	</tr>
			  	<tr>
			  		<td colspan="2">
			  			<input type="submit"
			  				   onclick="return passwordValidate();"
			  				   value="변경"/>
			  				   <br />
			  			
			  				   
			  			
			  			<input type="button"
			  				   onclick="self.close();"
			  				   value="취소"/>
			  		</td>
			  	</tr>
			  </table>
		</form>
	
	
	</div>



<script>

function passwordValidate(){
	
	var password = document.getElementById('password');
	var password1 = document.getElementById('password_new');
	var password2 = document.getElementById('password_check');
	
	
	if(!chk(/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,15}$/,password1,"패스워드는 숫자/문자/특수포함8~15자리"))
        
        return false;
    if(password1.value!=password2.value){

       alert("새 비밀번호 확인이 일치하지 않습니다.");
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






</script>








</body>
</html>