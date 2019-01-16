package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;

/**
 * Servlet implementation class MoveSchedulerServlet
 */
@WebServlet("/member/mainSchedule")
public class MoveSchedulerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = (Member)request.getSession().getAttribute("memberLoggedIn");
		
		if(m == null) {
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/").forward(request, response);
		}
		
		String memberId = m.getMemberId();
		
		//login business logic
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		
		c.set(Calendar.DATE, 1);
		int start = c.get(Calendar.DAY_OF_WEEK)-1;
		int last = c.getActualMaximum(Calendar.DATE);
		
		String scMonth = "";
		String snMonth = "";
		int cMonth = month + 1;
		int cYear = year;
		
		if(cMonth < 10) {
			scMonth = "0"+cMonth;
		}
		
		cMonth += 1;
		if(cMonth == 13) {
			cYear += 1;
			cMonth = 1;
		}
		if(cMonth < 10) {
			snMonth = "0"+cMonth;
		}
		
		String first = year+scMonth;
		String second = cYear+snMonth;
		
		List<Schedule> list = new ScheduleService().selectScheduleByMonth(memberId, first, second);
		
		c = Calendar.getInstance();
		long time = 0;
		long cTime = c.getTimeInMillis();
		for(Schedule s : list) {
			if("Y".equals(s.getScheduleDdaycheck())) {
				if(s.getScheduleDday() instanceof Date) {
					System.out.println("Date type ok:"+s.getScheduleDday());
					time = s.getScheduleDday().getTime();
					System.out.println(((time-cTime)/1000/60/60/24)+1);
					int dday = (int) (((time-cTime)/1000/60/60/24)+1);
					s.setdDay(dday);
				}
			}
		}
		
		List<Schedule> dayList = null;
		HashMap<Integer,List<Schedule>> map = new HashMap<>();
		
		
		//년월일에 맞게 데이터 삽입해줘야 함
		for(int i=1; i<=31; i++) {
			dayList = new ArrayList<>();
			for(Schedule s : list) {
				Date date = s.getScheduleDate();
				c.setTime(date);
				if(i == c.get(Calendar.DATE)) {
					dayList.add(s);
				}
			}
			map.put(i, dayList);
		}
		
		request.setAttribute("start", start);
		request.setAttribute("last", last);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		request.setAttribute("memberLoggedIn", m);
		request.getRequestDispatcher("/WEB-INF/views/member/monthlySchedule.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
