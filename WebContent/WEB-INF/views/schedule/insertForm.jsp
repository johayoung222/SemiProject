<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/side.jsp"%>
<%
	int year = (int) request.getAttribute("year");
	int month = (int) request.getAttribute("month");
	int day = (int) request.getAttribute("day");
	int time = (int)request.getAttribute("time");
	Member user = (Member) request.getAttribute("user");
	String writeDay = year+"-"+month+"-"+day;
%>

<style>
.content {
	padding-left: 140px;
}

#scheduleDday-container {
	display: none;
}
#scheduleIcon-container{
	margin-top: 20px;
}


.img{
	width: 60px;
	height: 60px;
	border:1px solid #cbcbcb;
}
.selected-icon{
	width:60px;
	height:60px;
	border:1px solid #cbcbcb;
}
#selected-icon{
	display: inline-block;	
}
.imgcon{
	display: inline-block;
	
}
.moreimg{

	position:relative;
	display: inline-block;
    width: 60px;
    height: 60px;
	top:-25px;
    border: 1px solid #cbcbcb;
    background-color: #f9f9f9;
    text-align: center;
    cursor: pointer;
}
.moreimg span{
	font-weight: bold;
    color: #999;
}

/*라벨위치*/
.ltitle{
	margin-right:35px;
}
.licon{
	position:relative;
	top: -20px;
	margin-right:20px;
}
.ltext{
	position:relative;
	top: -35px;
	margin-right:35px;
}
.ltime{
	margin-right:35px;
}
.lfile{
	margin-right:35px;
}

#scheduleTitle{
	width:500px;
}
#scheduleContent{
	width:500px;
}
.content{
	/*display: inline-block;*/
	position:relative;
	left:70px;
	
}
#scheduleDday-container{
	position:absolute;
	top:420px;
	right:650px;
	
	
	
}
/*체크박스 크기설정*/
#scheduleDdayCheck{
	position: relative;
	top:-10px;
	left:25px;
	-ms-transform: scale(1.5); /* IE */
  -moz-transform: scale(1.5); /* FF */
  -webkit-transform: scale(1.5); /* Safari and Chrome */
  -o-transform: scale(1.5); /* Opera */
  padding: 5px;
}
/*파일넣기 버튼(진짜)*/
.inputfile{
	cursor: pointer;
    margin: 0;
    padding: 0;
    width: 100px;
    height:30px;
    position: absolute;
    height: 28px;
    filter: alpha(opacity=0);
    opacity: 0;
    font-size: 12px;
}
/*파일 넣기 버튼(가짜)*/
.fakefile{
	width:100px;
	height: 30px;
	color: #222;
    letter-spacing: 0;
    vertical-align: middle;
    padding: 3px 6px 2px;
    overflow: visible;
    cursor: pointer;
    border: 1px solid #cbcbcb;
    line-height: 20px;
    text-decoration: none!important;
    -webkit-appearance: none;
    background: #f8f8f8;
	border-radius: 2px;
}
/*저장버튼*/
.submit{
	height:30px;
	color: #222;
    letter-spacing: 0;
    vertical-align: middle;
    padding: 3px 6px 2px;
    overflow: visible;
    cursor: pointer;
    border: 1px solid #cbcbcb;
    line-height: 20px;
    text-decoration: none!important;
    -webkit-appearance: none;
    background: #f8f8f8;
    border-radius: 2px;
}
</style>



<div class="content">
	<h2><%=year%>년
		<%=month%>월
		<%=day%>일
		<%=user.getMemberName() %>님의 일정등록
	</h2>
	<section>



		<form class="insertFrm" name="insertform"
			action="<%=request.getContextPath()%>/schedule/insertScheduleEnd" 
			method="post"
			enctype="multipart/form-data">

			<div class="schedule_box">
				<span>Scheduler</span> 
				<br /> 
				<br />
				<label for="scheduleTitle" class="ltitle">제목</label>

				<input type="text" name="scheduleTitle" id="scheduleTitle" required="required" >
				<br />
				<br />
				<label for="scheduleStartDay" class="ltime">일시</label>

				<input type="date" name="scheduleStartDay" id="scheduleStartDay"
					data-placeholder="스케줄 시작날을 설정하세요." required aria-required="true">
				&nbsp; - &nbsp;
				<input type="date" name="scheduleEndDay" id="scheduleEndDay"
					data-placeholder="스케줄 끝날을 설정하세요." required aria-required="true">
				<input type="checkbox" id="scheduleRepeatCheck" name="scheduleRepeatCheck" />
				<label for="scheduleRepeatCheck">스케줄 반복여부 설정</label>
				
				<div id="scheduleIcon-container">
				
					<label for="icon" class="licon">아이콘</label>

						<!-- input 여기에 넘겨줄 이모티콘의 이미지 이름을 넣는다. ex) img.PNG -->
						<input type="hidden" id="iconAlt" name="iconAlt" />
						<div id="selected-icon">
							<!-- 사용자가 선택한 icon이 이곳에 들어와야 한다. -->
							<img src="<%=request.getContextPath() %>/images/none.png" class="selected-icon" alt="none.png" />
						</div>
						<div class="imgcon">
						<!-- 아무것도 없는 이미지 -->						
						<img src="<%=request.getContextPath() %>/images/test.png" class="img" alt="test.png" />
						<img src="<%=request.getContextPath() %>/images/family.png" class="img" alt="family.png" />
						<img src="<%=request.getContextPath() %>/images/like.png" class="img" alt="like.png" />
						<img src="<%=request.getContextPath() %>/images/soju&beer.png" class="img" alt="soju&beer.png" />
												
						<a href="#" id="iconOpen">더보기</a>
						</div>
					<div id="divicon"><!-- 더보기 div 버튼 클릭시 나타난다. none -->
						<table id="tableicon">
							<tr>
								<td><img src="<%=request.getContextPath() %>/images/none.png" class="img" alt="none.png" /></td>
								<td><img src="<%=request.getContextPath() %>/images/baseball.png" class="img" alt="baseball.png"  ></td>
								<td><img src="<%=request.getContextPath() %>/images/birthday.png" class="img" alt="birthday.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/bowling.png" class="img" alt="bowling.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/family.png" class="img" alt="family.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/hospital.png" class="img" alt="hospital.png"></td>
							</tr>	
							<tr>				
								<td><img src="<%=request.getContextPath() %>/images/like.png" class="img" alt="like.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/marry.png" class="img" alt="marry.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/shopping.png" class="img" alt="shopping.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/soju&beer.png" class="img" alt="soju&beer.png"></td>
								<td><img src="<%=request.getContextPath() %>/images/test.png" class="img" alt="test.png"></td>
								<td><a href="#" id="iconClose">닫기</a></td>
							</tr>										
						</table>						
					</div>
				</div>
				<label for="" class="ltext">내용</label> 
				<textarea name="scheduleContent" id="scheduleContent" rows="5" cols="50" placeholder="내용을 작성해주세요." style="resize: none;"></textarea>
				<br /><br />
				<label for="up_file" class="lfile">파일</label>
				<input type="file" name="up_file" placeholder="이미지/파일선택" class="inputfile">
				<input type="button" value="파일 첨부" class="fakefile "/>
				<br /><br />
				<!-- 글쓴날짜 -->
				<input type="hidden" name="writeDay" id="writeDay" value="<%=writeDay %>" />
				
				<label for="scheduleDdayCheck" class="lcheck">디데이<br/>&nbsp;&nbsp;설정</label>
				<input type="checkbox" id="scheduleDdayCheck" name="scheduleDdayCheck" />
			<div id="scheduleDday-container">
				<!--  <label for="scheduleDday" class="ldday">디데이 설정</label>-->
				<input type="date" name="scheduleDday" id="scheduleDday"
					data-placeholder="설정할 디데이를 체크해주세요." required aria-required="true">
					<br /><br />
			</div>	
				<br /><br />
				
				
				


			<label for="scheduleTimeline" class="ltline">타임라인 배치컬럼</label>
			<select name="scheduleTimeline">
			<% if(time == 100){ %>
				<option value="100" hidden="hidden">시간을 선택해주세요.</option>
				<%}else{ %>
				<option value="<%=time %>" selected><%=time %>시</option>
				<%} %>
				<option value="00">00시</option>
				<option value="01">01시</option>
				<option value="02">02시</option>
				<option value="03">03시</option>
				<option value="04">04시</option>
				<option value="05">05시</option>
				<option value="06">06시</option>
				<option value="07">07시</option>
				<option value="08">08시</option>
				<option value="09">09시</option>
				<option value="10">10시</option>
				<option value="11">11시</option>
				<option value="12">12시</option>
				<option value="13">13시</option>
				<option value="14">14시</option>
				<option value="15">15시</option>
				<option value="16">16시</option>
				<option value="17">17시</option>
				<option value="18">18시</option>
				<option value="19">19시</option>
				<option value="20">20시</option>
				<option value="21">21시</option>
				<option value="22">22시</option>
				<option value="23">23시</option>
			</select>
			<br /><br />
				
				<input type="hidden" value="<%=memberLoggedIn.getMemberId() %>" name="memberId" />
				<input type="hidden" name="theDay" value="<%=day %>" />
				
					<br /><br />


					<input type="submit" value="일정 등록" onclick="return validate();" class="submit">
			</div>


		</form>
	</section>
</div>


</body>
<script>
/* 스케줄 시작일 초기값 설정 */
document.getElementById('scheduleStartDay').valueAsDate = new Date();
/* 스케줄 끝일 */
document.getElementById('scheduleEndDay').valueAsDate = new Date();
/* 디데이가 없는 경우 초기값 설정 */
document.getElementById('scheduleDday').valueAsDate = new Date();

/* 디데이 체크박스 여부 true / false를 리턴한다. */
$(document).ready(function() { 
	
	$("#scheduleDdayCheck").on('click', function() { 
		if ( $(this).prop('checked') ) { 
			$("#scheduleDday-container").show();
		} else { 
			$("#scheduleDday-container").hide();
		} 
	}); 
});

/* 일정 등록 유효성 검사 */
function validate(){
	var content = $("[name=scheduleContent]").val();
	if(content.trim().length == 0){
		alert("내용을 입력하세요.");
		return false;
	}
	return true;

}

/* 지금할일 이미지를 클릭했을때 그 이미지를 사용자가 선택한 icon에 뿌려주고
그 icon에대한 값을 attr로 뽑아내서 그 전송할 input에 담아주면 된다. */

$(".img").on("click" , function(){
	var selectedSrc = $(this).attr("src");
	console.log(selectedSrc);
	$(".selected-icon").attr("src" , selectedSrc);
	
	/* 전송할 alt추려내기 */
	var selectedAlt = $(this).attr("alt");
	$("#iconAlt").attr("value" , selectedAlt);
	
	$(".img").css("");
	
});

$("#iconOpen").on('click',function(){
	$("#divicon").show();
});

$("#iconClose").on('click',function(){
	$("#divicon").hide();
});



</script>
<style>
#divicon{
	display:none;
	margin-left: 70px;
}

	
}

</style>
</html>