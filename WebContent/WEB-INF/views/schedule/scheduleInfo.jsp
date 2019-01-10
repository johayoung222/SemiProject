<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.schedule.model.vo.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/side.jsp" %>
<%
	Schedule s = (Schedule)request.getAttribute("schedule");
%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/scheduleInfo.css" />
<div id="scheduleInfo-container">
	<form class="insertFrm" name="insertform"
			action="<%=request.getContextPath()%>/schedule/insertScheduleEnd" 
			method="post"
			enctype="multipart/form-data">
    <div id="inner-container">
        <label for="title">스케줄 제목</label>
        <input type="text" id="title" value="<%=s.getScheduleTitle() %>">
        
        <div class="func">
            <label for="dday">D-day</label>
            <input type="checkbox" name="dday" id="dday">
            <label for="scheduleStartDay">일시</label>
				<input type="date" name="scheduleStartDay" id="scheduleStartDay"
					data-placeholder="스케줄 시작날을 설정하세요." required aria-required="true">
				&nbsp; - &nbsp;
				<input type="date" name="scheduleEndDay" id="scheduleEndDay"
					data-placeholder="스케줄 끝날을 설정하세요." required aria-required="true">
				
				<input type="checkbox" id="scheduleRepeatCheck" name="scheduleRepeatCheck" />
				<label for="scheduleRepeatCheck">스케줄 반복여부 설정</label>
        </div>
        
        <div class="content">
            <label for="content">스케줄 내용</label>
            <textarea name="content" id="content" cols="70" rows="30"><%=s.getScheduleContent() %></textarea>
        </div>
        
        <div class="addfile">
            <label for="up_file">파일</label>
				<input type="file" name="up_file" placeholder="이미지/파일선택" id="file">
            <div class="filelist">
            	<span><%=s.getScheduleOriginalfilename() %></span>
            	<img src="<%=request.getContextPath() %>/upload/schedule/<%=s.getScheduleRenamefilename() %>" width="20px" height="20px"/>
            </div>
        </div>
    </div>
    </form>
</div>

</body>
</html>