package com.kh.chat.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.chat.model.dao.ChatDao;
import com.kh.chat.model.vo.Chat;

/**
 * Servlet implementation class ChatSubmitServlet
 */
@WebServlet("/ChatListServlet")
public class ChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String fromId = request.getParameter("fromId");
		String toId = request.getParameter("toId");
		String listType = request.getParameter("listType");
		if(fromId == null || fromId.equals("") || toId == null || toId.equals("")) {
			// fromId / toId 중에 하나라도 비어있다면 공백을 write
			response.getWriter().write("");
		} else if(listType.equals("ten")) {
			// ajax의 data로 받아온 listType의 값이 ten이라면 write(getTen메소드를 호출)
			response.getWriter().write(getTen(fromId , toId));
		} else {
			// 위의 조건 둘다 아니라면 write(getId메소드를 호출)
			try {
				response.getWriter().write(getId(fromId , toId , listType));
			} catch(Exception e) {
				response.getWriter().write("");
			}
		}
	}
	
	public String getTen(String fromId , String toId) {
		System.out.println("getTen호출");
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ChatDao chatdao = new ChatDao();
		ArrayList<Chat> chatList = chatdao.getChatListByRecent(fromId, toId, 10);
		if(chatList.size() == 0) {
			return "";
		}
		for(int i = 0;i < chatList.size();i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getFromId() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getToId() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatTime() + "\"}]");
			if(i != chatList.size() - 1) {
				result.append(",");
			}
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatNo() + "\"}");
		return result.toString();
	}
	
	public String getId(String fromId , String toId , String chatId) {
		System.out.println("getId호출");
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ChatDao chatdao = new ChatDao();
		ArrayList<Chat> chatList = chatdao.getChatListByID(fromId, toId, chatId);
		
		if(chatList.size() == 0) {
			return "";
		}
		for(int i = 0;i < chatList.size();i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getFromId() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getToId() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatTime() + "\"}]");
			if(i != chatList.size() - 1) {
				result.append(",");
			}
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatNo() + "\"}");	
		return result.toString();
	}

}
