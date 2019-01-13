package com.kh.schedule.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.schedule.model.service.ScheduleService;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/schedule/deleteScheduleEnd")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 핸들링
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
//		String up_file = request.getParameter("up_file");
		
		int result = new ScheduleService().deleteSchedule(scheduleNo);
		
		
		response.sendRedirect(request.getContextPath()+"/member/login");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
