<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member memberLoggedIn1 = (Member)session.getAttribute("memberLoggedIn");  

%>
    
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Coiny|Do+Hyeon|Gothic+A1|Nanum+Gothic+Coding|Nanum+Pen+Script|Noto+Sans+KR" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/side.css" />
<script>
  function showPopup(temp) {
	  var windowW = 800;  // 창의 가로 길이
      var windowH = 500;  // 창의 세로 길이
      var left = Math.ceil((window.screen.width - windowW)/2);
      var top = Math.ceil((window.screen.height - windowH)/2);


	  window.open("<%=request.getContextPath() %>/member/recommendation?temp="+temp, "a","l top="+top+", left="+left+", height="+windowH+", width="+windowW); 
	  
	  
  }
  function addfriend(){
	$("#friends").css('display','inline-block');	  
  }
  function close(){
	$("#friends").css('display','none');	  
	  
  }
  

  
  </script>
  


  <script>
  
  window.onload =function(){
	var apiURI = "http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=c95231fca9f07b22a6540efdcce37587";
    $.ajax({
        url: apiURI,
        dataType: "json",
        type: "GET",
        async: "false",
        success: function(resp) {
        	var myDiv = document.getElementById("myDiv"); 
        	var table = $("<table></table>");
			
			
			html = "<br><br>현재온도 : "+(resp.main.temp- 273.15)+"<br>";
			html += "상세날씨 설명 : "+resp.main.humidity+"<br>";
			html += "날씨 : "+resp.weather[0].description+"<br>";
			html += "나라 : "+resp.sys.country+"<br>";
			html +=	"도시 이름 : "+resp.name+"<br>";
			html += "구름 : "+(resp.clouds.all)+"%<br>";
			html += "<input type='button' id='weatherbtn' value='추천 여행,의상 보기' onclick= 'showPopup("+(resp.main.temp- 273.15)+");'/>";
			
			myDiv.innerHTML = html;
			
            //console.log(resp);
            
            
            /* console.log("현재온도 : "+ (resp.main.temp- 273.15) );
            console.log("현재습도 : "+ resp.main.humidity);
            console.log("날씨 : "+ resp.weather[0].main );
            console.log("상세날씨설명 : "+ resp.weather[0].description );
            console.log("날씨 이미지 : "+ resp.weather[0].icon );
            console.log("바람   : "+ resp.wind.speed );
            console.log("나라   : "+ resp.sys.country );
            console.log("도시이름  : "+ resp.name );
            console.log("구름  : "+ (resp.clouds.all) +"%" );   */              
        	}
    	})
	};

</script>



</head>
<body>
	
	<div class="side">
		<br />
		<br />
		<br />
		<br />
		<div id="searchsch">
		<a href="<%=request.getContextPath()%>/member/mainSchedule" class="font">월간 스케줄</a><hr />
		
		<a href="<%=request.getContextPath()%>/schedule/schedulelist" class="font">스케줄 찾기</a><hr />
		
		<% if(memberLoggedIn1 != null && "admin".equals(memberLoggedIn1.getMemberId())){%>
		<a href="<%=request.getContextPath()%>/admin/memberList" class="font">회원리스트</a><br />
		<% } %>
		<!-- <a href="##">년간 달력5</a><br />
		<a href="##">년간 달력6</a><br />
		<a href="##">년간 달력7</a><br /> -->
		</div>
		<div id="myDiv">
	
		</div>
		<div id="friend">
			<p>친구들
			<button id="addfriend" onclick="addfriend();">+</button></p>
			<div id="friendspace">
				
			</div>
		</div>
		<div id="friends">
		<form class="insertFriendFrm" name="insertFriendFrm"
			action="<%=request.getContextPath()%>/friend/insertFriend" 
			method="post">
				<input type="hidden" name="myId" id="myId" value="<%=memberLoggedIn1.getMemberId() %>" />
				<label for="srchId" id="font2">아이디 : </label>
				<input type="text"  name="srchId" id="srchId" autocomplete="off" />
				<button type="submit" id="friendadd">친구 추가</button>
					<ul id="autoComplete">
						<li>1</li>
						<li>2</li>
						<li>3</li>
					</ul>
						
				<hr />
				<div>
				<input type="button"
			  				   onclick="close();"
			  				   value="취소"/>
				
				</div>
		</form>
		</div>
	
	</div>
	
	
<script>

$("#srchId").on("keyup" , function(e){
	console.log(e.key);
	var selected = $(".selected");
	var li = $("#autoComplete li");
	
	if(e.key == "ArrowDown") {
		if(selected.length == 0) {
			$("#autoComplete li:first").addClass("selected");
		} else if(selected.is(li.last())) {
		} else {
			selected.removeClass("selected").next().addClass("selected");
		}
	} else if(e.key == "ArrowUp") {
		if(selected.length == 0) {
		} else if(selected.is(li.first())) {
			selected.removeClass("selected");
		} else {
			selected.removeClass("selected").prev().addClass("selected");
		}
	} else if(e.key == "Enter") {
		$(this).val(selected.text());
		$("#autoComplete").hide().children().remove();
	} else {
		var srchId = $(this).val().trim();
		
		if(srchId.length == 0) {
			return;
		}
		
		$.ajax({
			url: "<%=request.getContextPath()%>/friend/autoComplete.do" ,
			type: "post" ,
			data: {srchId:srchId} ,
			success: function(data) {
				console.log(data);
				
				var idArr = data.split(",");
				var html = "";
				for(var i = 0;i < idArr.length;i++) {
					html += "<li>"+idArr[i].replace(srchId,"<span class='srchVal'>"+srchId+"</span>");
				}
				
				if(data.length != 0) {
					$("#autoComplete").html(html).css("display" , "inline-block");				
				} else {
					$("#autoComplete").hide();
				}

			}
		});
	}
});

$("#autoComplete").on("click" , "li" , function(){
	$("#srchId").val($(this).text());
	$("#autoComplete").hide().children().remove();
});


$("#autoComplete").on("mouseenter" , "li" , function() {
	$(this).siblings().removeClass("selected");
	$(this).addClass("selected");
});
$("#autoComplete").on("mouseleave" , "li" , function() {
	$(this).removeClass("selected");
});

</script>	
</body>
</html>