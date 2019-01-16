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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/checkidDuplicate.css" />
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/logo(favicon).png" type="image/png" sizes="128x128">
</head>
<body>
	<div id="checkid-container">
		<br /><br />당신에게 온 친구요청입니다.<br />
		<select name="selectFriend" id="selectFriend">
		</select>
		<input type="hidden" id="memberId" name="memberId" value="<%=memberId %>" />
 		<button id="ok">수락</button>
		<button id="no">거절</button><br /><br />
		<button onclick="self.close();">닫기</button>	   
	</div>
<script>
$(function(){
	$.ajax({
		url: "<%=request.getContextPath()%>/friend/selectFriendQueue.do" ,
		type: "get" ,
		success: function(data) {
			console.log(data);
			var select = $("#selectFriend");
			var html;
			for(var i in data) {
				var option = data[i];
				html += "<option value='"+option+"'>"+option+"</option>";
			}
			select.html(html);
		}
	});
});



	/* 거절버튼을 누를시에 FriendQueue table에 delete된다. */
	$("#no").on("click" , function(){
		var con = confirm("정말 친구요청을 수락하시겠습니까?");
		var selectFriend = $("#selectFriend option:selected").val();
		console.log(selectFriend);
		if(con) {
			$.ajax({
				url: "<%=request.getContextPath()%>/member/deleteFriendQueue" ,
				data : {selectFriend:selectFriend} ,
				type: "get" ,
				success: function(data) {
					console.log(data);
					if(data.length == 0) self.close();
					var select = $("#selectFriend");
					var html = "";
					for(var i in data) {
						var option = data[i];
						html += "<option value='"+option+"'>"+option+"</option>";
					}
					select.html(html);
				}
			});
			alert("친구요청 거절 완료!");
		} else {}
	});
	
	/* 수락버튼을 누를시에 Friend table에 insert된다. */
	$("#ok").on("click" , function(){
		var con = confirm("정말 친구요청을 수락하시겠습니까?");
		var selectFriend = $("#selectFriend option:selected").val();
		if(con) {
			$.ajax({
				url: "<%=request.getContextPath()%>/member/insertFriend" ,
				data : {selectFriend:selectFriend} ,
				type: "get" ,
				success: function(data) {
					console.log(data);
					if(data.length == 0) self.close();
					var select = $("#selectFriend");
					var html = "";
					for(var i in data) {
						var option = data[i];
						html += "<option value='"+option+"'>"+option+"</option>";
					}
					select.html(html);
				}
			});
			alert("친구요청 수락 완료!");
		} else {}
	});
</script>
</body>

</html>
