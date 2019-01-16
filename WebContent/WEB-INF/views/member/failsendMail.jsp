<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload = function () {
	 alert("일치하는 회원정보가 없습니다.");
	 opener.$('#userId_').val('');
	 opener.$('#email__').val('');
	 self.close();
	}
</script>
</head>
<body>
	
</body>
</html>