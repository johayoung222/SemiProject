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

/**
 * Servlet implementation class memberListSearchServlet
 */
@WebServlet("/admin/memberList")
public class memberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		System.out.println(memberLoggedIn.getMemberId());
		System.out.println(memberLoggedIn.toString());
		if(memberLoggedIn == null || !("admin".equals(memberLoggedIn.getMemberId()))) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
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
			numPerPage = 7;
		}		
	
		List<Member> list= new AdminService().memberList(cPage, numPerPage);
		int totalContent = new AdminService().memberListCount();
		
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		
		String pageBar = "";		
		int pageBarSize = 7;		
		int startPage = ((cPage-1)/pageBarSize) * pageBarSize + 1;
		int endPage = startPage + pageBarSize - 1;		
		int pageNo = startPage;		
		
		if(pageNo == 1) {
			
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+
								 "/admin/memberList?"+
								 "cPage="+(pageNo-1)+
								 "&numPerPage="+numPerPage+"'>[이전]</a>";
		}
				
		while(pageNo<=endPage && pageNo<=totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span class='cPage'>"+pageNo+"</span>";
			}
			else {
				pageBar += "<a href='"+request.getContextPath()+
						   "/admin/memberList?"+
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
					   "/admin/memberList?"+
					   "cPage="+pageNo+
					   "&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("list", list);				
		request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
