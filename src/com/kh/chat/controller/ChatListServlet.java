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
		System.out.println("ChatListServlet@" + fromId + " , "+toId + " , " + listType);
		
		
		
		
		if(fromId == null || fromId.equals("") || toId == null || toId.equals("")) {
			response.getWriter().write("");
			System.out.println(1);
		} else if(listType.equals("ten")) {
			response.getWriter().write(getTen(fromId , toId));
			System.out.println(2);
		} else {
			try {
				response.getWriter().write(getId(fromId , toId , listType));
			} catch(Exception e) {
				response.getWriter().write("");
			}
		}
	}
	
	public String getTen(String fromId , String toId) {
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
		System.out.println("55"+result.toString());
		return result.toString();
	}
	
	public String getId(String fromId , String toId , String chatId) {
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
		System.out.println("66"+result.toString());
		
		return result.toString();
	}

}
