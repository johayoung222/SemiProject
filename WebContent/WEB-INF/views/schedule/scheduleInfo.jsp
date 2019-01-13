<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.schedule.model.vo.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%
	Schedule s = (Schedule)request.getAttribute("schedule");
	String icon = s.getScheduleIcon();
	System.out.println("s.getScheduleRepeatcheck()"+s.getScheduleRepeatcheck());

%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/scheduleinfo.css" />
<div id="scheduleInfo-container">
	<h3>Scheduler 수정</h3>
	<form class="updateScheduleFrm" name="updateSchedulefrm"
			action="<%=request.getContextPath()%>/schedule/updateScheduleEnd" 
			method="post"
			enctype="multipart/form-data" >
		<input type="hidden" name="scheduleNo" id="scheduleNo" value="<%=s.getScheduleNo()%>" />
	    <div id="updateSchedule_div" class="updateSchedule_div">
	        <input type="hidden" id="scheduleDdaycheck1" value="<%=s.getScheduleDdaycheck()%>" />
	        <input type="hidden" id="scheduleDday1" value="<%=s.getScheduleDday()%>" />
	        <input type="hidden" id="scheduleRepeatcheck1" value="<%=s.getScheduleRepeatcheck()%>" />
	        
	        <label for="title">제목</label>
	        <input type="text" id="scheduleTitle" name="scheduleTitle" value="<%=s.getScheduleTitle() %>">
	       
	        <div id="scheduleIcon-container" class="scheduleIcon-container">				
				<label for="icon" class="icon">아이콘</label>
				<input type="hidden" id="iconAlt" name="iconAlt" />
				<div id="selected-icon" class="selected-icon">
					<img src="<%=request.getContextPath() %>/images/<%=s.getScheduleIcon()%>" class="selected-icon" alt="<%=s.getScheduleIcon()%>" />
				</div>
				<div id="imgcon" class="imgcon">
				<img src="<%=request.getContextPath() %>/images/test.png" class="img" alt="test.png" />
				<img src="<%=request.getContextPath() %>/images/family.png" class="img" alt="family.png" />
				<img src="<%=request.getContextPath() %>/images/like.png" class="img" alt="like.png" />
				<img src="<%=request.getContextPath() %>/images/soju&beer.png" class="img" alt="soju&beer.png" />
				<a href="#" id="iconOpen">더보기+</a>
				</div>
			</div>
			<div id="divicon" class="divicon"><!-- 더보기 div 버튼 클릭시 나타난다. none -->
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
			
			<div class="scheduleContent" id="scheduleContent">           
	            <label for="scheduleContent">스케줄 내용:</label>
	            <textarea name="scheduleContent" id="scheduleContent" cols="50" rows="15"><%=s.getScheduleContent() %></textarea>
	        </div>
	       
	     	<label for="scheduleDdayCheck" class="lcheck">디데이<br/>&nbsp;&nbsp;설정</label>
			<input type="checkbox" id="scheduleDdayCheck" name="scheduleDdayCheck" />
			<div id="scheduleDday-container">
				<input type="date" name="scheduleDday" id="scheduleDday"
					data-placeholder="설정할 디데이를 체크해주세요." required aria-required="true" value="<%=s.getScheduleDday()%>">
				<br /><br />
			</div>
				
			<div id="scheduleRepeatCheck">        
			<label for="scheduleRepeatCheck">스케줄 반복여부 설정</label>
			<input type="checkbox" id="scheduleRepeatCheck" name="scheduleRepeatCheck" />
	        </div>	
	        
	        <label for="scheduleTimeline" class="ltline">타임라인 배치컬럼</label>
			<select name="scheduleTimeline">
			<% if(s.getScheduleTimeline() == 100){ %>
				<option value="100" hidden="hidden">시간을 선택해주세요.</option>
				<%}else{ %>
				<option value="<%=s.getScheduleTimeline() %>" selected><%=s.getScheduleTimeline() %>시</option>
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
			
	        <div class="schedule_renamedFile">
	            <label for="up_file">파일</label>
					<input type="file" name="up_file" placeholder="이미지/파일선택" id="file">
	            <div class="filelist">
	            <%if(s.getScheduleOriginalfilename() != null){ %>
	            	<img src="<%=request.getContextPath() %>/images/file.png" width="20px" height="20px"/>
	            <%} %>
	            	<span><%=s.getScheduleOriginalfilename()!=null?s.getScheduleOriginalfilename():""%></span>
	            </div>
	        </div>	
	        
	        
	      </div>
   		 <div class="updateSchedule">
	           <input type="submit" value="일정수정" onclick="return validate();" >
	           <input type="button" id="delete" value="일정 삭제" onclick="deleteSchedule();">
	     </div> 
    </form>
    <form action="<%=request.getContextPath()%>/schedule/deleteScheduleEnd" name="deleteScheduleFrm" method="post">
		<input type="hidden" name="scheduleNo" id="scheduleNo" value="<%=s.getScheduleNo()%>" />
		<input type="hidden" name="scheduleRenamefilename" id="scheduleRenamefilename" value="<%=s.getScheduleRenamefilename()%>" />
	</form>
</div>
<script>

function deleteSchedule(){
	  
	  var bool = confirm("정말로 삭제하시겠습니까?");
		if(bool){
			var frm = document.deleteScheduleFrm;
			frm.submit();			
		}	  
}

/* 디데이가 없는 경우 초기값 설정 */
document.getElementById('scheduleDday').valueAsDate = new Date();

/* 디데이 체크박스 여부 true / false를 리턴한다. */
$(document).ready(function() { 
	var scheduleDdaycheck1 = $("#scheduleDdaycheck1").val();
	var scheduleDday1 = $("#scheduleDday1").val();
	var scheduleRepeatcheck1 =  $("scheduleRepeatcheck1").val();
	
	if(scheduleDdaycheck1 == 'Y'){
		$("#scheduleDdayCheck").prop("checked", true);
		$("#scheduleDday").val(scheduleDday1);
		$("#scheduleDday-container").show();
	}
	
	if(scheduleRepeatcheck1 == 'Y'){
		$("#scheduleRepeatcheck").prop("checked", true);
	}
	
	
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
</body>
</html>