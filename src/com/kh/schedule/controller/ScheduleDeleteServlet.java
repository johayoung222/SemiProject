package com.kh.schedule.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;

@WebServlet("/schedule/deleteScheduleEnd")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ScheduleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member m = (Member) request.getSession().getAttribute("memberLoggedIn");
		
		if(m == null) {
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/").forward(request, response);
		}
		
		String memberId = m.getMemberId();
		
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
		String scheduleRenamefilename = request.getParameter("scheduleRenamefilename");
		
		Schedule s = new ScheduleService().selectOneSchedule(scheduleNo, memberId);
		Date start = s.getScheduleStartday();
		Date end = s.getScheduleEndday();
	
		int result = 0;
		System.out.println(s.getScheduleStartday());
		System.out.println(s.getScheduleEndday());
		System.out.println(memberId);
		if("N".equals(s.getScheduleRepeatcheck())) {
			result = new ScheduleService().deleteSchedule(scheduleNo);
		}else {
			result = new ScheduleService().deleteRepeatSchedule(start, end, memberId);
		}

		//첨부파일 삭제
		if(result >0 && !"".equals(scheduleRenamefilename)) {
			String saveDirectory = getServletContext().getRealPath("/upload/schedule/");
			File delFile = new File(saveDirectory+scheduleRenamefilename);
							
			//파일이동
			String delDirectory = getServletContext().getRealPath("/deleteFiles/schedule/");
			File delFile_ = new File(delDirectory+scheduleRenamefilename);
			delFile.renameTo(delFile_);
		}		

		String view= "/WEB-INF/views/common/msg.jsp";
		String msg="";
		String loc="/member/mainSchedule";

		
		if(result >0) {
			msg = "일정 삭제 성공!";
		}else {
			msg = "일정 삭제 실패!";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request,response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
