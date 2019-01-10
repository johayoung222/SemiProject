package com.kh.schedule.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;

/**
 * Servlet implementation class PrevMonthServlet
 */
@WebServlet("/schedule/prevMonth.do")
public class PrevMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cYear = Integer.parseInt(request.getParameter("cYear"));
		int cMonth = Integer.parseInt(request.getParameter("cMonth"));
		String memberId = request.getParameter("memberId");
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, (cMonth-1));
		c.roll(Calendar.MONTH, -1);
		c.set(Calendar.YEAR, cYear);
		if(cMonth == 1) {
			c.roll(Calendar.YEAR, -1);
		}
		c.set(Calendar.DATE, 1);
		
		//여기부터 전월 데이터 만들기
		String scMonth = "";
		String spMonth = "";
		
		scMonth = String.valueOf(cMonth);
		if(cMonth < 10) {
			scMonth = "0"+scMonth;
		}
		
		String second = cYear+scMonth;
		
		if(cMonth == 1) {
			cYear -= 1;
			cMonth = 12;
		}
		System.out.println("cMonth:"+cMonth);
		
		cMonth -= 1;
		spMonth = String.valueOf(cMonth);
		if(cMonth < 10) {
			spMonth = "0"+spMonth;
		}
		String first = cYear+spMonth;
		
		System.out.println(scMonth+"<-/->"+spMonth);
		
		List<Schedule> list = new ScheduleService().selectScheduleByMonth(memberId, first, second);
		
		int start = c.get(Calendar.DAY_OF_WEEK);
		int last = c.getActualMaximum(Calendar.DATE);
		int prevYear = c.get(Calendar.YEAR);
		int prevMonth = c.get(Calendar.MONTH);
		Map<Integer, Object> map = new HashMap<>();
		map.put(1, prevYear);
		map.put(2, prevMonth);
		map.put(3, start);
		map.put(4, last);
		map.put(5, list);
		
		new Gson().toJson(map,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
