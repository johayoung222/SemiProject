package com.kh.schedule.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, cMonth);
		c.roll(Calendar.MONTH, -1);
		c.set(Calendar.YEAR, cYear);
		if(cMonth == 0) {
			c.roll(Calendar.YEAR, -1);
		}
		
		int start = c.get(Calendar.DAY_OF_WEEK);
		int last = c.getActualMaximum(Calendar.DATE);
		int prevYear = c.get(Calendar.YEAR);
		int prevMonth = c.get(Calendar.MONTH);
		int[] date = {prevYear, prevMonth, start, last};
		
		new Gson().toJson(date,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
