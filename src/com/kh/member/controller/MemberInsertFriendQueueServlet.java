package com.kh.member.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Friend;
import com.kh.member.model.vo.FriendQueue;

/**
 * Servlet implementation class MemberInsertFriendServlet
 */
@WebServlet("/friend/insertFriendQueue")
public class MemberInsertFriendQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertFriendQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srchId = request.getParameter("srchId");
		String myId = request.getParameter("myId");	
		FriendQueue fq = new FriendQueue();
		fq.setMemberId(myId);
		fq.setFriendId(srchId);	
		String msg = "";
		int result = 0;
		int status = 0;
		int srchIdCheck = new MemberService().srchIdCheck(srchId);
		/* 이미 친구인데 친구요청 막기위한 소스코드 */
		int alreadyCheckFriend = new MemberService().alreadyCheckFriend(myId , srchId);
		if(srchId.equals(myId)) {
			msg = "본인에게는 친구추가를 할 수 없습니다.";
			status = 1;
		} else if(!(srchIdCheck > 0)) {
			msg = fq.getFriendId()+"는 존재하지 않는 아이디입니다.";
			status = 2;
		} else if(alreadyCheckFriend > 0) {
			msg = "이미 등록된 친구입니다.";
			status = 5;
		} else {
			try {
				result = new MemberService().insertFriendQueue(fq);
			} catch (SQLIntegrityConstraintViolationException e) {
				if(result > 0) {
					msg = fq.getFriendId()+"님께 친구요청에 성공하셨습니다.";
					status = 3;
				}else {
					msg = "이미 친구요청이 진행중입니다.";
					status = 4;
				}
				
			}
			// exception 발생 안할시 구문
			if(result > 0) {
				msg = fq.getFriendId()+"님께 친구요청에 성공하셨습니다.";
				status = 3;
			}else {
				msg = "이미 친구요청이 진행중입니다.";
				status = 4;
			}
			
		}
			
		request.setAttribute("msg", msg);
		request.setAttribute("status", status);
		request.getRequestDispatcher("/WEB-INF/views/member/checkFriendIdDuplicate.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
