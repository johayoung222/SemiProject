package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class PwdPermuteServlet
 */
@WebServlet("/member/pwdPermute")
public class PwdPermuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdPermuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberEmail = request.getParameter("memberEmail");
		System.out.println("pwd memberEmail =="+memberEmail);
		String new_password = request.getParameter("new_Password");
		System.out.println("pwd new_password =="+new_password);
		
		Member m = new Member();
		
		m.setMemberEmail(memberEmail);
		m.setMemberPwd(new_password);
		
		int result = new MemberService().pwdPermute(m);
		System.out.println("servlet result =="+result);
		
		
		new Gson().toJson(result, response.getWriter());
		/*String msg = "";
		String loc = "";
		
		if(result > 0) {
			msg = "패스워드 변결을 성공하였습니다";
		}else {
			msg = "패스워드 변경에 실패했습니다.";
		}*/
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
