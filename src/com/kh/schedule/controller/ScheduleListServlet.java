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

@WebServlet("/schedule/schedulelist")
public class ScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public ScheduleListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		String memberId = memberLoggedIn.getMemberId();
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch(NumberFormatException e) {
			numPerPage = 15;
		}
		
		//System.out.printf("[cPage=%s, numPerPage=%s]\n", cPage, numPerPage,memberId);				
		
		List<Schedule> list= new ScheduleService().selectScheduleList(cPage, numPerPage, memberId);
		int totalContent = new ScheduleService().selectScheduleCount(memberId);
		//System.out.printf("[totalContent=%s]\n", totalContent);				
		
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		//System.out.printf("[totalPage=%s]\n",totalPage);
		
		String pageBar = "";		
		int pageBarSize = 15;		
		int startPage = ((cPage-1)/pageBarSize) * pageBarSize + 1;
		int endPage = startPage + pageBarSize - 1;
		//System.out.printf("[start=%s, end=%s]\n", startPage, endPage);
		
		int pageNo = startPage;
			
		if(pageNo == 1) {
			
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+
								 "/schedule/schedulelist?"+
								 "cPage="+(pageNo-1)+
								 "&numPerPage="+numPerPage+"'>[이전]</a>";
		}
				
		while(pageNo<=endPage && pageNo<=totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span class='cPage'>"+pageNo+"</span>";
			}
			else {
				pageBar += "<a href='"+request.getContextPath()+
						   "/schedule/schedulelist?"+
						   "cPage="+pageNo+
						   "&numPerPage="+numPerPage+"'>"+
						   pageNo+"</a>";
			}
			pageNo++;
		}		
		
		if(pageNo > totalPage) {
			
		} 
		else {
			pageBar += "<a href='"+request.getContextPath()+
					   "/schedule/schedulelist?"+
					   "cPage="+pageNo+
					   "&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("list", list);				
		request.getRequestDispatcher("/WEB-INF/views/schedule/scheduleList.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
