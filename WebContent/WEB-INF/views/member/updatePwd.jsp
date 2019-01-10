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
					<th>현재 비밀번호</th>
					<td><input type="password" name="nowPwd" id="nowPwd_" placeholder="" required /></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" name="updatePwd" id="updatePwd_" placeholder="" required /></td>
				</tr>
				<tr>
					<th>새 비밀번호 확인</th>
					<td><input type="password" name="checkPwd" id="checkPwd_" placeholder="" required /></td>
				</tr>
				 <tr>
                  	<td colspan="2" id="button1">
                  		<input type="button" value="변경" onclick="return passwordValidate();" />
                  		<input type="button" onclick="self.close();" value="취소"  />
                  	</td>
                  </tr>
			</table>
			</form>
			

	</div>
</body>
</html>