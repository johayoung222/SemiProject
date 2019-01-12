package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class SearchIdPwdServlet
 */
@WebServlet("/member/searchIdPwd")
public class SearchIdPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberName = request.getParameter("pname");
		
		String memberEmail = request.getParameter("pemail");
		
		String memberId = request.getParameter("pid");
		
		
		Member member = new Member();
		
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		member.setMemberId(memberId);
		
		Member result = new MemberService().MemberId(member);
		
		String view ="/WEB-INF/views/member/searchIdPwd.jsp";
		
		RequestDispatcher reqDispatcher
		= request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
		
		
		new Gson().toJson(result, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
