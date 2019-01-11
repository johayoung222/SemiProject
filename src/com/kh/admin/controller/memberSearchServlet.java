package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;
import com.kh.member.model.vo.Member;

@WebServlet("/admin/memberSearch")
public class memberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
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
				
		List<Member> list = null;
		switch (searchType) {
		case "memberId"	:list = new AdminService().selectMemberByMemberId(searchKeyword, cPage, numPerPage);break;
		case "memberName"	:list = new AdminService().selectMemberByMemberName(searchKeyword, cPage, numPerPage);break;
		case "memberLoginlog"	:list = new AdminService().selectMemberByMemberLoginlog(cPage, numPerPage);break;
		}		
		
		int totalMember = 0;
		switch (searchType) {
		case "memberId"	:totalMember = new AdminService().selectMemberCountByMemberId(searchKeyword);break;
		case "memberName"	:totalMember = new AdminService().selectMemberCountByMemberName(searchKeyword);break;
		case "memberLoginlog"	:totalMember = new AdminService().selectMemberCountByMemberLoginlog();break;
		}
		
		int totalPage = (int)Math.ceil((double)totalMember/numPerPage);				
		int pageBarSize = 7;		
		int pageStart = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		int pageEnd = pageStart+pageBarSize-1;		
		int pageNo = pageStart;		
				
		String pageBar = "";		
		if(pageNo == 1 ){
		
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+
					"/admin/memberSearch?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+(pageNo-pageBarSize)+"&numPerPage="+numPerPage+"'>[이전]</a> ";
		}
		while(!(pageNo > pageEnd || pageNo > totalPage)){
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+
						"/admin/memberSearch?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		
		if(pageNo > totalPage){
		
		} else {
			pageBar += "<a href='"+request.getContextPath()+
					"/admin/memberSearch?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}		
		
		request.setAttribute("list", list);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("cPage",cPage);
		request.setAttribute("pageBar",pageBar);
		request.setAttribute("numPerPage", numPerPage);
		request.getRequestDispatcher("/WEB-INF/views//admin/memberSearch.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
