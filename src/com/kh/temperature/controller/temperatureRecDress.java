package com.kh.temperature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.temperature.model.vo.content;

/**
 * Servlet implementation class temperatureRecDress
 */
@WebServlet("/temperature/recdress.do")
public class temperatureRecDress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = new ArrayList<>();
		String temp = request.getParameter("temp");
		
		
		
		System.out.println("테스트 temp = "+temp);
		
		list.add(new content(5,"겨울 옷(야상, 패딩, 목도리 등등 다)"));
		list.add(new content(6,9,"코트, 가죽자켓"));
		list.add(new content(10,11, "트렌치코트, 간절기 야상, 여러겹 껴입기"));
		list.add(new content(12,16, "자켓, 셔츠, 가디건, 간절기 야상, 살색스타킹"));
		list.add(new content(17,19, "니트, 가디건, 후드티, 맨투맨, 청바지, 면바지, 슬랙스, 원피스"));
		list.add(new content(20,22, "긴팔티, 가디건, 후드티, 면바지, 슬랙스, 스키니"));
		list.add(new content(23,26, "반팔, 얇은 셔츠, 얇은 긴팔, 반바지, 면바지"));
		list.add(new content(27, "나시티, 반바지, 민소매 원피스"));
		
		
		new Gson().toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
