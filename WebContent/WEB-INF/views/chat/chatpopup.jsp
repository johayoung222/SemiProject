<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String fromId = (String) request.getAttribute("fromId");
	String toId = (String) request.getAttribute("toId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>chat</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/chatpopup.css" />
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/logo(favicon).png"
	type="image/png" sizes="128x128">

<style>

</style>

</head>
<body>
	<div id="checkid-container">
		<div class="row">
			<h4>
				<i class="fa fa-circle text-green"></i>실시간 채팅창
			</h4>
			<div id="chatlist" class="portlet-body chat-widget"
				style="overflow-y: auto; width: auto; height: 350px;"></div>
			<div class="row">
				<div class="row" style="height: 40px;">
					<!-- <textarea style="height: 15px; resize:none;" id="chatContent" 
						class="form-control" placeholder="메세지를 입력하세요." maxlength="100"></textarea> -->
					<input type="text" id="chatContent" placeholder="메세지를 입력하세요." />
					<button type="button"
						onclick="submitFunction();">전송</button>
				</div>
			</div>
		</div>
		<button onclick="self.close();">닫기</button>
	</div>
	<script>

$(function(){
	chatListFunction('ten');
	getInfiniteChat();
});

function submitFunction() {
	var fromId = "<%=fromId%>";
	var chatContent = $("#chatContent").val();
	var toId = "<%=toId%>";
	console.log("submitFunction에서 toId1 = "+toId);
	
	$.ajax({
		type: "POST" ,
		url: "<%=request.getContextPath()%>/ChatSubmitServlet" ,
		data: {
			fromId: encodeURIComponent(fromId) ,
			toId: encodeURIComponent(toId) ,
			chatContent: encodeURIComponent(chatContent)
			
		} ,
		success: function(result) {
			if(result == 1) {
				alert("메세지 전송에 성공했습니다.");
			} else if(result == 0) {
				alert("내용이 입력되지 않았습니다.");
			} else {
				alert("데이터베이스 오류가 발생했습니다.");
			}
		}
		
	});
	$("#chatContent").val("");
}

var lastId = 0;

function chatListFunction(type) {
	var fromId = "<%=fromId%>";
	var toId = "<%=toId%>";
	$.ajax({
		type: "POST" ,
		url: "<%=request.getContextPath()%>/ChatListServlet",
				data : {
					fromId : encodeURIComponent(fromId),
					toId : encodeURIComponent(toId),
					listType : type
				},
				success : function(data) {
					if (data == "") {
						console.log("데이타가 비어있니?");
						return;
					}
					var parsed = JSON.parse(data);
					var result = parsed.result;
					for (var i = 0; i < result.length; i++) {
						console.log("11111111여기는 들어오니?");
						addChat(result[i][0].value, result[i][2].value,
								result[i][3].value);
					}
					lastId = Number(parsed.last);
				}
			});
		}

		function addChat(chatName, chatContent, chatTime) {
			console.log("addChat에 들어왔습니다.");
			$('#chatlist').append(
					'<div class="row">' + '<div class="col-lg-12">'
							+ '<div class="media">'
							+ '<a class="pull-left" href="#"' + '</a>'
							+ '<div class="media-body">'
							+ '<h4 class="media-heading">' + '아이디 : ' + chatName
							+ '<span class="small pull-right">' + '<br>현재시간 : ' + chatTime
							+ '</span>' + '</h4>' + '<p>' + chatContent
							+ '</p>' + '</div>' + '</div>' + '</div>'
							+ '</div>' + '<hr>');
			$('#chatlist').scrollTop($('#chatlist')[0].scrollHeight);

		}

		function getInfiniteChat() {
			setInterval(function() {
				chatListFunction(lastId);
			}, 3000);
		}
	</script>
</body>

</html>
