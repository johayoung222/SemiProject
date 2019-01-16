<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css">
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/logo(favicon).png" type="image/png" sizes="128x128">
  <script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
=======
<meta charset="UTF-8">
<title>온도에 따른 추천 의상, 여행지</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/recommendation.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
>>>>>>> 8ddcbfa0204d0142c99eb5dfd3434ac16a5ebd96

<%
	String temp = request.getParameter("temp");
	
	System.out.println("시험하는곳 temp = "+temp);
%>

<style>
div.container{
	float:left;
	width:29%;
	height:300px;
	maring:10px;
	padding:10px;
	text-align:center;
}
table {
	border:1px solid;
	margin:auto;
	border-collapse: collapse;
}
td,th {
	border:1px solid;
}
span#time{
	text-decoration:underline;
	margin: 15px;
    display: block;
}
#order-list{
	width:80%;
	margin-left:50px;
}
#rank-list{
	width:100%;
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



</head>
<body>


<div class="container2">
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
<div class="container2">
	<h2>추천 장소</h2>
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
				var table = $("<table id='cloth'></table>");
				var html = "<tr><th>온도</th><th colspan=2>추천내용</th></tr>";
				
				if(<%=temp%> <= 4){
                    html += "<tr><td>~4˚C</td>";
                    html += "<td>겨울 옷 (패딩, 두꺼운코트, 목도리, 기모제품 )</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/4~.png'/></td></tr>";
                    
                }else if((<%=temp%> > 4)&&(<%=temp%> <= 8)){
                    html += "<tr><td>5˚C~8˚C</td>";
                    html += "<td>코트, 가죽자켓, 히트텍, 니트, 레깅스</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/8~5.png'/></td></tr>";
                    
                }else if((<%=temp%> > 8)&&(<%=temp%> <= 11)){
                    html += "<tr><td>9˚C~11˚C</td>";
                    html += "<td>자켓, 트렌치코트, 야상, 니트, 청.면바지</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/11~9.png'/></td></tr>";
                    
                }else if((<%=temp%> > 11)&&(<%=temp%> <= 16)){
                    html += "<tr><td>12˚C~16˚C</td>";
                    html += "<td>자켓, 가디건, 야상, 청.면바지</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/16~12.png'/></td></tr>";
                    
                }else if((<%=temp%> > 16)&&(<%=temp%> <= 19)){
                    html += "<tr><td>17˚C~19˚C</td>";
                    html += "<td>얇은니트, 맨투맨, 가디너, 청바지</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/19~17.png'/></td></tr>";
                    
                }else if((<%=temp%> > 19)&&(<%=temp%> <= 22)){
                    html += "<tr><td>20˚C~22˚C</td>";
                    html += "<td>얇은 가디건, 긴팔, 청.면바지</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/22~10.png'/></td></tr>";
                    
                }else if((<%=temp%> > 22)&&(<%=temp%> <= 27)){
                    html += "<tr><td>23˚C~27˚C</td>";
                    html += "<td>반팔, 얇은셔츠, 반바지</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/27~23.png'/></td></tr>";
                    
                }else if(<%=temp%> >= 28){
                    html += "<tr><td>28˚C~</td>";
                    html += "<td>민소매, 반팔, 반바지 , 원피스</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/cloth/~28.png'/></td></tr>";
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
					html += "<tr><td>~5˚C</td>";
					html += "<td>실내에서 노시는게 좋을겁니다^^</td></tr>";
				}else if(<%=temp%> > 10)
				{
					html += "<tr><td>~5˚C</td>";
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