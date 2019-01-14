<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
	// String[] popupArr = (String[])request.getAttribute("popupArr");
	String memberId = (String)request.getAttribute("memberId");
	List<String> popup = (List<String>)session.getAttribute("popup"); 
	System.out.println("checkFriend.jsp@popup/memberId : "+popup+", "+memberId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 받을꺼야 말꺼야</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
</head>
<body>
	<div id="checkid-container">

		<br /><br />
		<form action=""
			  method="post"
			  name="checkFriendFrm"
			  id="checkFriendFrm">
		<select name="selectFriend" id="selectFriend">
		<%for(int i = 0;i < popup.size();i++) { %>
		<option value="<%=popup.get(i)%>"><%=popup.get(i) %></option>
		<% } %>
		</select>
		<input type="hidden" id="memberId" name="memberId" value="<%=memberId %>" />
		<button type="submit" id="ok">수락</button>
		<button type="submit" id="no">거절</button>
		<br /><br />
		<button onclick="self.close();">닫기</button>	   
	</form>
		
	</div>
</body>
<script>
	$("#ok").on("click" , function(){
		/* 수락버튼을 누를시에 Friend table에 insert된다. */
		$("#checkFriendFrm").attr("action" , "<%=request.getContextPath()%>/member/insertFriend");
	});
	
	$("#no").on("click" , function(){
		var con = confirm("정말 친구요청을 거절하시겠습니까?");
		if(con) {
			/* 거절버튼을 누를시에 FriendQueue table에 delete된다. */
			// alert($("#memberId").val());
			// alert($("#selectFriend").val());
			$("#checkFriendFrm").attr("action" , "<%=request.getContextPath()%>/member/deleteFriendQueue");					
		} else {
			// alert("거절취소");
		}
	});
</script>
</html>
