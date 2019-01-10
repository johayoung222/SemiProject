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
 * Servlet implementation class NextMonthServlet
 */
@WebServlet("/schedule/nextMonth.do")
public class NextMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cYear = Integer.parseInt(request.getParameter("cYear"));
		int cMonth = Integer.parseInt(request.getParameter("cMonth"));
		String memberId = request.getParameter("memberId");
		System.out.println("cYear"+cYear+"cMonth"+cMonth+"memberID"+memberId);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, cYear);
		c.set(Calendar.MONTH, cMonth-1);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 1);
		
		if(cMonth >= 12) {
			cYear += 1;
			cMonth = 0;
		}
		System.out.println(cMonth);
		
		String scMonth = "";
		String snMonth = "";
		
		cMonth += 1;
		scMonth = String.valueOf(cMonth);
		if(cMonth < 10) {
			scMonth = "0"+scMonth;
		}
		
		if(cMonth == 12) {
			cYear += 1;
			cMonth = 0;
		}
		
		cMonth += 1;
		snMonth = String.valueOf(cMonth);
		if(cMonth < 10) {
			snMonth = "0"+snMonth;
		}
		
		System.out.println(scMonth+"<-/->"+snMonth);
		
		
		String first = cYear+scMonth;
		String second = cYear+snMonth;
		
		List<Schedule> list = new ScheduleService().selectScheduleByMonth(memberId, first, second);
		
		
		int start = c.get(Calendar.DAY_OF_WEEK);
		int last = c.getActualMaximum(Calendar.DATE);
		int nextYear = c.get(Calendar.YEAR);
		int nextMonth = c.get(Calendar.MONTH);
		int[] date = {nextYear, nextMonth, start, last};
		Map<Integer, Object> map = new HashMap<>();
		map.put(1, nextYear);
		map.put(2, nextMonth);
		map.put(3, start);
		map.put(4, last);
		map.put(5, list);
		
		new Gson().toJson(map, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
