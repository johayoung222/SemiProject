<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온도에 따른 추천 의상, 여행지</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

<%
	String temp = request.getParameter("temp");
	
	System.out.println("시험하는곳 temp = "+temp);
%>

<style>
div.container{
	float: left;
	width: 29%;
	height:300px;
    margin: 10px;
    padding: 10px;
	background:lightgrey;
	text-align:center;
}
table {
	border:1px solid;
	margin:auto;
}
td,th {
	border:1px solid;
}
span#time{
	text-decoration:underline;
	margin: 15px;
    display: block;
}
</style>
</head>
<body>
<h1>온도에 따른 추천 의상, 여행지 </h1>



<div class="container">
	<h2>추천 의상</h2>
	<div id="order-list"></div>
	
	
</div>
<script>

function printTime() {
      var time = document.getElementById("time");            // 출력할 장소 선택
      var now = new Date();                                                  // 현재시간
      var nowTime = now.getFullYear() + "년 " + (now.getMonth()+1) + "월 " + now.getDate() + "일 " + now.getHours() + "시 " + now.getMinutes() + "분 " + now.getSeconds() + "초";

      time.innerHTML = nowTime;           // 현재시간을 출력

      setTimeout("printTime()",1000);         // setTimeout(“실행할함수”,시간) 시간은1초의 경우 1000
}



</script>
<div class="container">
	<h2>추천 여행지</h2>
	<h4 id="time"></h4>
	<div id="rank-list"></div>
</div>
	   
	<script>
	window.onload =function(){
		$.ajax({
			url: "<%=request.getContextPath()%>/temperature/recdress.do",
			type: "get",
			dataType: "json",
			data: "temp="+<%=temp%>,
			success: function (data) {
				
				console.log(data); //data는 이미 javascript배열객체
				//json <----> javascript
				//	   <--- JSON.stringgify()
				//	  	---> JSON.parse()
				var table = $("<table></table>");
				var html = "<tr><th>온도</th><th>추천내용</th></tr>";
				
				if(<%=temp%> <= 5){
					html += "<tr><td>~5도C</td>";
					html += "<td>겨울 옷 (야상, 패딩, 목도리 등등 다)</td></tr>";
				}else if((<%=temp%> > 5)&&(<%=temp%> <= 9)){
					html += "<tr><td>6도C~9도C</td>";
					html += "<td>코트, 가죽자켓</td></tr>";
				}else if((<%=temp%> > 9)&&(<%=temp%> <= 11)){
					html += "<tr><td>10도C~11도C</td>";
					html += "<td>트렌치코트, 간절기 야상, 여러겹 껴입기</td></tr>";
				}else if((<%=temp%> > 11)&&(<%=temp%> <= 16)){
					html += "<tr><td>12도C~16도C</td>";
					html += "<td>자켓,셔츠,가디건,간절기 야상</td></tr>";
				}else if((<%=temp%> > 16)&&(<%=temp%> <= 19)){
					html += "<tr><td>17도C~19도C</td>";
					html += "<td>니트,가디건,후드티,면바지,슬랙스,스키니</td></tr>";
				}else if((<%=temp%> > 19)&&(<%=temp%> <= 22)){
					html += "<tr><td>20도C~22도C</td>";
					html += "<td>긴팔티, 가디건, 후드티, 면바지, 슬랙스</td></tr>";
				}else if(<%=temp%> > 22){
					html += "<tr><td>10도C~11도C</td>";
					html += "<td>반팔,얇은셔츠,얇은긴팔,반바지</td></tr>";
				}
				
				
				table.append(html);
				
				$("#order-list").html(table);
				
				
				
			},
			error: function (jqxhr, textStatus, errorThrown) {
				console.log("ajax처리실패!");
				console.log(jqxhr);
				console.log(textStatus);
				console.log(errorThrown);
			}
			
		});
		
		$.ajax({
			url: "<%=request.getContextPath()%>/temperature/rectour.do",
			type: "get",
			dataType: "json",
			data: "temp="+<%=temp%>,
			success: function (data) {
				
				console.log(data); //data는 이미 javascript배열객체
				//json <----> javascript
				//	   <--- JSON.stringgify()
				//	  	---> JSON.parse()
				var table = $("<table></table>");
				var html = "<tr><th>온도</th><th>추천내용</th></tr>";
				
				if(<%=temp%> <= 10){
					html += "<tr><td>~5도C</td>";
					html += "<td>실내에서 노시는게 좋을겁니다^^</td></tr>";
				}else if(<%=temp%> > 10)
				{
					html += "<tr><td>~5도C</td>";
					html += "<td>밖에서 노시죠^^</td></tr>";
				}
				
				table.append(html);
				
				$("#rank-list").html(table);
				
				
				
			},
			error: function (jqxhr, textStatus, errorThrown) {
				console.log("ajax처리실패!");
				console.log(jqxhr);
				console.log(textStatus);
				console.log(errorThrown);
			}
			
		});
		
		
	}
	
	</script>
	
	
	


</body>
</html>