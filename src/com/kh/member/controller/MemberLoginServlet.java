package com.kh.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//filter로 인코딩
		
		//login business logic
		//test code
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
		
		c.set(Calendar.DATE, 1);
		String start = "";
		switch(c.get(Calendar.DAY_OF_WEEK)) {
		case 1: start = "일"; break;
		case 2: start = "월"; break;
		case 3: start = "화"; break;
		case 4: start = "수"; break;
		case 5: start = "목"; break;
		case 6: start = "금"; break;
		case 7: start = "토"; break;
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=1; i<=12; i++) {
			c.set(Calendar.MONTH, i-1);
			map.put(i, c.getActualMaximum(Calendar.DATE));
		}
		
		request.setAttribute("start", start);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("map", map);
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
