package com.kh.member.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.member.model.vo.Member;


/**
 * Servlet implementation class CheckFriendServlet
 */
@WebServlet("/member/checkFriend")
public class CheckFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// String[] popupArr = (String[]) request.getAttribute("popupArr");
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		System.out.println("CheckFriendSerlvet@memberId"+memberLoggedIn.getMemberId());
		

		
		// request.setAttribute("popupArr", popupArr);
		request.setAttribute("memberId", memberLoggedIn.getMemberId());
		
		
		//checkFriend.jsp
		request.getRequestDispatcher("/WEB-INF/views/member/checkFriend.jsp")
			   .forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
