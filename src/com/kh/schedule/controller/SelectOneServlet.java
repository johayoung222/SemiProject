package com.kh.schedule.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;

/**
 * Servlet implementation class SelectOneServlet
 */
@WebServlet("/schedule/selectOne")
public class SelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
		
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("memberLoggedIn");
		
		if(m == null) {
			request.setAttribute("msg", "잘못된 경로의 접근입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String memberId = m.getMemberId();
		
		Schedule s = new ScheduleService().selectOneSchedule(scheduleNo, memberId);
		request.setAttribute("schedule", s);
		request.getRequestDispatcher("/WEB-INF/views/schedule/scheduleInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
