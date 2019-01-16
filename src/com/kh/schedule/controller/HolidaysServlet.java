package com.kh.schedule.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class HolidaysServlet
 */
@WebServlet("/schedule/holidays.do")
public class HolidaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cYear = Integer.parseInt(request.getParameter("cYear"));
		int cMonth = Integer.parseInt(request.getParameter("cMonth"));
		
		BufferedReader br = null;
		String result = "";
        try{       
        	String urlstr = "";
        	if(cMonth <10) 
        		urlstr = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?serviceKey=oUf3aVLm2NBqcaC81ewNogplxmyyutJ6PVlQJ6ReGcJYAQDF%2BgJZsdfmFULOo3%2FXAXTMxaCN46ECovjdLgnCWA%3D%3D&solYear="+cYear+"&solMonth=0"+cMonth+"&_type=json";
        	else 
        		urlstr = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?serviceKey=oUf3aVLm2NBqcaC81ewNogplxmyyutJ6PVlQJ6ReGcJYAQDF%2BgJZsdfmFULOo3%2FXAXTMxaCN46ECovjdLgnCWA%3D%3D&solYear="+cYear+"&solMonth="+cMonth+"&_type=json";
        		
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
            result = "";
            String line;
           
            while((line = br.readLine()) != null) {
            	
                result = result + line + "\n";
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		String jsonStr = gson.toJson(result);
		response.getWriter().println(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
