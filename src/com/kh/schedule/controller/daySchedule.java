package com.kh.schedule.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;


/**
 * Servlet implementation class daySchedule
 */
@WebServlet("/schedule/daySchedule.do")
public class daySchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		List<Schedule> list = new ArrayList();
		
		list = new ScheduleService().daySchedule(memberId);
		
		Schedule emp = new Schedule();
		
		if(list.size() == 0) {
			emp.setScheduleTitle("당일 등록된 스케쥴이 없습니다.");
			list.add(emp);
			new Gson().toJson(list, response.getWriter());
		}else {
			new Gson().toJson(list, response.getWriter());
			
		}
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
