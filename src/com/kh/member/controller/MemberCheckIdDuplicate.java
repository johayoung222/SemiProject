package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;



/**
 * Servlet implementation class MemberCheckIdDuplicate
 */
@WebServlet("/member/checkIdDuplicate")
public class MemberCheckIdDuplicate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
				request.setCharacterEncoding("utf-8");
				
				
				String memberId = request.getParameter("memberId");
				
			
				Member m = new MemberService().memberOne(memberId);
				
				
				boolean isUsable = m==null?true:false;
				
				//view단 jsp에서 사용할 데이터를 request의 속성값으로 보관
				request.setAttribute("isUsable", isUsable);
				request.setAttribute("memberId", memberId);
				
				//4.view
				//checkIdDuplicate.jsp
				request.getRequestDispatcher("/WEB-INF/views/member/checkIdDuplicate.jsp")
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
