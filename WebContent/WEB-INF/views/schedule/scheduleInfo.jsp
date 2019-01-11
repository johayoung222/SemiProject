<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.schedule.model.vo.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%
	Schedule s = (Schedule)request.getAttribute("schedule");
%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/scheduleinfo.css" />
<div id="scheduleInfo-container">
	<h3>오늘의 할일</h3>
	<form class="insertFrm" name="updateScheduleform"
			action="<%=request.getContextPath()%>/schedule/updateScheduleEnd" 
			method="post"
			enctype="multipart/form-data">
    <div id="inner-container">
        <label for="title">스케줄 제목:</label>
        <input type="text" id="title" name="title" value="<%=s.getScheduleTitle() %>">
        <div class="func">
            <label for="dday">D-day</label>
            <input type="checkbox" name="dday" id="dday">
            <span></span>
            <br />
            <label for="scheduleStartDay">일시:</label>
				<input type="date" name="scheduleStartDay" id="scheduleStartDay"
					data-placeholder="스케줄 시작날을 설정하세요." required aria-required="true">
			
				<input type="date" name="scheduleEndDay" id="scheduleEndDay"
					data-placeholder="스케줄 끝날을 설정하세요." required aria-required="true">
				
				<input type="checkbox" id="scheduleRepeatCheck" name="scheduleRepeatCheck" />
				<label for="scheduleRepeatCheck">스케줄 반복여부 설정</label>
        </div>
        
        <div class="content">
           
            <label for="content">스케줄 내용:</label>
            <br />
            <textarea name="content" id="content" cols="70" rows="15"><%=s.getScheduleContent() %></textarea>
        </div>
        
        <div class="addfile">
            <label for="up_file">파일</label>
				<input type="file" name="up_file" placeholder="이미지/파일선택" id="file">
            <div class="filelist">
            	<span><%=s.getScheduleOriginalfilename() %></span>
            	<img src="<%=request.getContextPath() %>/upload/schedule/<%=s.getScheduleRenamefilename() %>" width="20px" height="20px"/>
            </div>
        </div>
        <div class="updateSchedule">
           <input type="submit" value="일정수정" >
           <input type="button" id="delete" value="일정 삭제" onclick="deleteSchedule();">
         </div>
   
        
    </div>
    </form>
</div>
<script>
function deleteSchedule(){
	  
	  var bool = confirm("정말로 삭제하시겠습니까?");
		if(bool){
			var frm = document.updateScheduleform;
			frm.action = "<%=request.getContextPath()%>/schedule/deleteScheduleEnd";
			frm.submit();
			
		}
	  
	  
}




</script>
</body>
</html>