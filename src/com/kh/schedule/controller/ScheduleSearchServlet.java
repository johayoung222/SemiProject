package com.kh.schedule.controller;

import java.io.IOException;
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
 * Servlet implementation class ScheduleSearchServlet
 */
@WebServlet("/schedule/scheduleSearch")
public class ScheduleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScheduleSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		
		String memberId = memberLoggedIn.getMemberId();
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		System.out.printf("[%s : %s]\n", searchType, searchKeyword);
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));			
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));			
		}catch(NumberFormatException e) {
			numPerPage = 7;
		}
		System.out.printf("[searchType=%s, searchKeyword=%s, cPage=%s, numPerPage=%s]\n",searchType, searchKeyword, cPage, numPerPage);
				
		List<Schedule> list = null;
		switch (searchType) {
		case "scheduleTitle"	:list = new ScheduleService().selectScheduleByTitle(searchKeyword, cPage, numPerPage, memberId);break;
		case "scheduleContent"	:list = new ScheduleService().selectScheduleByContent(searchKeyword, cPage, numPerPage, memberId);break;
		case "scheduleIcon"	:list = new ScheduleService().selectScheduleByIcon(searchKeyword, cPage, numPerPage, memberId);break;
		}
		
		System.out.println("list="+list);
		
		int totalMember = 0;
		switch (searchType) {
		case "scheduleTitle"	:totalMember = new ScheduleService().selectScheduleCountByTitle(searchKeyword, memberId);break;
		case "scheduleContent" :totalMember = new ScheduleService().selectScheduleCountByContent(searchKeyword, memberId);break;
		case "scheduleIcon"	:totalMember = new ScheduleService().selectScheduleCountByIcon(searchKeyword, memberId);break;
		}
		
		int totalPage = (int)Math.ceil((double)totalMember/numPerPage);
		System.out.println("totalMember="+totalMember+", totalPage="+totalPage);
		
		
		int pageBarSize = 7;		
		int pageStart = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		int pageEnd = pageStart+pageBarSize-1;		
		int pageNo = pageStart;
		
		//System.out.printf("[totalPage=%s]\n", totalPage);
		//System.out.printf("[pageStart=%s, pageEnd=%s]\n", pageStart, pageEnd);
				
		String pageBar = "";		
		
		if(pageNo == 1 ){
		
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+
					"/schedule/scheduleSearch?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+(pageNo-pageBarSize)+"&numPerPage="+numPerPage+"'>[이전]</a> ";
		}
		while(!(pageNo > pageEnd || pageNo > totalPage)){
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+
						"/schedule/scheduleSearch?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		
		if(pageNo > totalPage){
		
		} else {
			pageBar += "<a href='"+request.getContextPath()+
					"/schedule/scheduleSearch?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		System.out.printf("[pageBar=%s]\n", pageBar);

		request.setAttribute("list", list);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("cPage",cPage);
		request.setAttribute("pageBar",pageBar);
		request.setAttribute("numPerPage", numPerPage);
		request.getRequestDispatcher("/WEB-INF/views/schedule/scheduleSearch.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
