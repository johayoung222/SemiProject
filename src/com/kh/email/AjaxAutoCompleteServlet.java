package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxAutoCompleteServlet
 */
@WebServlet("/friend/autoComplete.do")
public class AjaxAutoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAutoCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/csv; charset=utf-8");

		String srchId = request.getParameter("srchId");
		System.out.println(srchId);
		
		List<String> list = new MemberService().selectById(srchId);
		String csv = "";
		
		if(!list.isEmpty()) {
			for(int i = 0; i < list.size();i++) {
				if(i != 0) {
					csv += ",";
				}
				csv += list.get(i);
			}
		}
		
		PrintWriter out = response.getWriter();
		out.append(csv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
