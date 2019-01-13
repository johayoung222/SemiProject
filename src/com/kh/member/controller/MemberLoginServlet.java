package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;


/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(urlPatterns="/member/login", name="MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		//System.out.printf("[%s, %s]\n", memberId, memberPwd);
		
		// return 1 : 로그인성공
		// return 0 : 패스워드 틀림
		// return -1 : 존재하지 않는 아이디.
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);		
		
		int result = new MemberService().loginCheck(m);
//		int result = 1;
		//System.out.println("[로그인결과 : "+result+"]");		
		
		String view = "";		
		String msg = "";
		String loc = "/";
		
			
		String referer = request.getHeader("Referer");
		String origin = request.getHeader("Origin");
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();		
		
		//referer =http://localhost:9090/scheduler/index.jsp
		//origin =http://localhost:9090
		//url =http://localhost:9090/scheduler/member/login
		//uri =/scheduler/member/login
		
		//크롬 외 브라우져용
		if(origin == null)
		{
			origin = url.replace(uri, "");
		}
		//1.로그인 성공한 경우		
			if(result == MemberService.LOGIN_OK) {
			
		
			Member memberLoggedIn = new MemberService().memberOne(memberId);
			
			int log = new MemberService().updateMemberLog(memberId);
			if(log == 1) {
				System.out.println("log up success!!");
			}

//			Set<Integer> set =  map.keySet();
//			for(int key : set) {
//				System.out.println(key+":"+map.get(key));
//			}
												
			HttpSession session = request.getSession(true);		
			String exPwd = (String)request.getAttribute("exPwd");
			
			session.setAttribute("memberLoggedIn", memberLoggedIn);	
			session.setAttribute("exPwd", exPwd);
			request.setAttribute("memberLoggedIn", memberLoggedIn);
			request.getRequestDispatcher("/").forward(request, response);
			
		//2.로그인 실패한 경우
			}else {
			view = "/WEB-INF/views/common/msg.jsp";
			
			if(result == MemberService.WRONG_PASSWORD) {
				msg = "패스워드를 잘못 입력하셨습니다.";
			}
			else if(result == MemberService.ID_NOT_EXIST) {
				msg = "존재하지 않는 아이디 입니다.";
			}
			
			//속성에 값 보관
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			System.out.println(request);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
			reqDispatcher.forward(request, response);
		}
		
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
