package com.kh.schedule.controller;

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
 * Servlet implementation class MonthOfYearServlet
 */
@WebServlet("/schedule/monthOfYear")
public class MonthOfYearServlet extends HttpServlet {
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
		
		int selectMonth = Integer.parseInt(request.getParameter("month"));
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, selectMonth-1);
		
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
		}else {
			scMonth = String.valueOf(cMonth);
		}
		
		cMonth += 1;
		if(cMonth == 13) {
			cYear += 1;
			cMonth = 1;
		}
		if(cMonth < 10) {
			snMonth = "0"+cMonth;
		}else {
			snMonth = String.valueOf(cMonth);
		}
		
		String first = year+scMonth;
		String second = cYear+snMonth;
		
		List<Schedule> list = new ScheduleService().selectScheduleByMonth(memberId, first, second);
		
		if(list == null) {
			list = new ArrayList<>();
		}
		
		List<Schedule> dayList = null;
		HashMap<Integer,List<Schedule>> map = new HashMap<>();
		
		
		//년월일에 맞게 데이터 삽입해줘야 함
		Calendar c2 = Calendar.getInstance();
		for(int i=1; i<=31; i++) {
			dayList = new ArrayList<>();
			for(Schedule s : list) {
				Date date = s.getScheduleDate();
				c2.setTime(date);
				if(i == c2.get(Calendar.DATE)) {
					dayList.add(s);
				}
			}
			map.put(i, dayList);
		}
		
		System.out.printf("start:%d last:%d year:%d month:%d\n",start,last,year,month);
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
