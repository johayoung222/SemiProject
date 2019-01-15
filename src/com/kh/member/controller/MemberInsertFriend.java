package com.kh.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertFriend
 */
@WebServlet("/member/insertFriend")
public class MemberInsertFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberInsertFriend ~");
		
		// 친구요청을 보낸 사용자의 아이디
		String selectFriend = (String)request.getParameter("selectFriend");
		// 본인의 아이디
		Member memberLoggedIn = (Member)request.getSession().getAttribute("memberLoggedIn");
		String memberId = memberLoggedIn.getMemberId();
		
		
		int deleteFQcheck = new MemberService().deleteFriendQueue(selectFriend , memberId);// FQ테이블에서 delete를 잘했는지
		int insertFmy = new MemberService().insertFriendMy(memberId , selectFriend);	// F테이블에서 memberId를 기준으로 추가
		int insertFsf = new MemberService().insertFriendSf(selectFriend , memberId);	// F테이블에서 selectFriend를기준으로 추가
		
		List<String> popup = new MemberService().checkFriend(memberLoggedIn.getMemberId());
		
		
		new Gson().toJson(popup, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
