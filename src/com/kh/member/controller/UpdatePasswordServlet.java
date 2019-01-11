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
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/member/updatePasswordEnd")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberPwd_new = request.getParameter("memberPwd_new");
		
		
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		
		
		int result  = new MemberService().loginCheck(m);
		
		
		
		String msg = "";
		String loc = "";
		
		if(result == MemberService.LOGIN_OK) {
			
			m.setMemberPwd(memberPwd_new);
			result = new MemberService().updatePassword(m);
			
			if(result>0) {
				msg = "패스워드 변경을 성공했습니다";
				
				String script = "self.close();";
				request.setAttribute("script", script);
				
				
			}else {
				msg = "패스워드 변경에 실패했습니다.";
				loc = "/member/updatePassword?memberid="+memberId;
			}
						
		}else{
			msg = "기존 패스워드를 잘못 입력하셨습니다.";
			loc = "/member/updatePassword?memberid="+memberId;
			
		}
		

		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
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
