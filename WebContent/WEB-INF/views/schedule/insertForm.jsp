<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/side.jsp"%>
<%
	int year = (int) request.getAttribute("year");
	int month = (int) request.getAttribute("month");
	int day = (int) request.getAttribute("day");
	String user = (String) request.getAttribute("user");
%>

<style>
.content {
	padding-left: 140px;
}
</style>



<div class="content">
	<h2><%=year%>년
		<%=month%>월
		<%=day%>일
		<%=user%>님의 일정등록
	</h2>
	<section>



		<form class="insertFrm" name="insertform"
			action="<%=request.getContextPath()%>/schedule/insert" method="post"
			onsubmit="return saveMember();">

			<div class="schedule_box">
				<span>Scheduler</span> 
				<br /> 
				<label for="scheduleTitle">제목</label>
				<input type="text" name="scheduleTitle" id="scheduleTitle">
				<br /><br />
				<label for="">내용</label> 
				<textarea name="scheduleContent" id="scheduleContent" rows="5" cols="50" placeholder="내용을 작성해주세요."></textarea>
				
				<br />
				
				<label for="up_file">파일</label>
				<input type="file" name="up_file" placeholder="이미지/파일선택">
				
				<div id="checkPwd">동일한 암호를 입력하세요</div>


				<input type="text" name="memberName" id="memberName"
					placeholder="이름을 입력하세요(두글자 이상)"> <input type="email"
					name="memberEmail" id="memberEmail" placeholder="이메일을 입력하세요">
				&nbsp;&nbsp; <input type="button" id="emailclear" value="인증하기">


				<input type="date" name="memberDate" id="memberDate"
					data-placeholder="생년월일을 입력하세요" required aria-required="true">


				<label for="male" id="man">남자</label> <input type="radio"
					name="gender" id="gender" value="M" checked> &nbsp;&nbsp; <label
					for="female">여자</label> <input type="radio" name="gender"
					id="gender" value="F"> <br> <input type="submit"
					value="회원가입">
			</div>


			<div class="login_box">
				<span>계정이 있으신가요?<a
					href="<%=request.getContextPath()%>/index.jsp">로그인</a></span>
			</div>
		</form>
	</section>
</div>


</body>
</html>