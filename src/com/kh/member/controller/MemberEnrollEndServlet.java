package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollEndServlet
 */
@WebServlet("/member/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
		request.setCharacterEncoding("UTF-8");
		
		//2.parameterHandling
		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");
		String name = request.getParameter(	"name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
//		int login_log = Integer.parseInt(request.getParameter("login_log"));
//		String status = request.getParameter("status");
//		String sns_account = request.getParameter("sns_account");
		

		Member m = new Member(memberid, password, name, gender, age, email);
		
		int result = new MemberService().insertMember(m);
		
		//4. view단처리
		//성공한 경우/실패한 경우
		//msg.jsp -> location.href = "변경할 주소"; 
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";

		if(result>0)
			msg = "성공적으로 회원등록했습니다.";
		else 
			msg = "회원등록에 실패했습니다.";	
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
