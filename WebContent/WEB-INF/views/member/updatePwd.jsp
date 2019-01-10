<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css">
  <title>아이디/비밀번호 찾기</title>
  <script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<style>
.header{
	padding-bottom:67px;
}
 #table1{
 	border: 1px solid black;
 	text-align:center;
 	width:100%;
 	height:245px;
 }
</style>
<script>
function passwordValidate(){
	
}
</script>
</head>

<body>
<nav class="header">
    <div class="logo">
      <img src="<%=request.getContextPath() %>/images/logo.png" width="50px" height="50px" >
      <span class="logofont">7' Scheduler
      </span>
    </div>  
</nav>
	<div id="updatePwd">
	<form action="<%=request.getContextPath()%>/member/updatePwd"
			name="updatePwd_" method="post">
			<table id="table1" style="float: left">
				<tr>
					<th class="newPwd">새 비밀번호 변경</th>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="MemberName" id="MemberName_" placeholder="아이디를 입력해주세요." required /></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" name="updatePwd" id="updatePwd_" placeholder="변경할 비밀번호를 입력해주세요." required /></td>
				</tr>
				
				 <tr>
                  	<td colspan="2" id="button1">
                  		<input type="button" value="변경" onclick="passwordValidate();" />
                  		<input type="button" onclick="self.close();" value="취소"  />
                  	</td>
                  </tr>
			</table>
			</form>
			

	</div>
</body>
</html>