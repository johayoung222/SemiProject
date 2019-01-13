package com.kh.schedule.controller;


import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.josephoconnell.html.HTMLInputFilter;
import com.kh.common.MyFileRenamePolicy;
import com.kh.schedule.model.service.ScheduleService;
import com.kh.schedule.model.vo.Schedule;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/schedule/updateScheduleEnd")
public class ScheduleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ScheduleUpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "일정수정 오류!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}

		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload" + File.separator + "schedule";

		int maxPostSize = 1024 * 1024 * 10;

		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8",
				new MyFileRenamePolicy());

		String scheduleTitle = multiReq.getParameter("scheduleTitle");
		String scheduleContent = multiReq.getParameter("scheduleContent");
		String scheduleDdayCheck = multiReq.getParameter("scheduleDdayCheck");
		int scheduleTimeline = Integer.parseInt(multiReq.getParameter("scheduleTimeline"));
		System.out.println("scheduleTimeline : "+scheduleTimeline);

		scheduleTitle = new HTMLInputFilter().filter(scheduleTitle);
		scheduleContent = new HTMLInputFilter().filter(scheduleContent);
				
		
		if(scheduleDdayCheck == null) {
			scheduleDdayCheck = "N";
		} else {
			scheduleDdayCheck = "Y";
		}
		
		java.sql.Date dateDday = null;
		
		if (scheduleDdayCheck == "Y") {
			String scheduleDday = multiReq.getParameter("scheduleDday");
			dateDday = java.sql.Date.valueOf(scheduleDday);
		}

		scheduleContent = new HTMLInputFilter().filter(scheduleContent);
		
		String scheduleRepeatCheck = multiReq.getParameter("scheduleRepeatCheck");		
		if(scheduleRepeatCheck == null) {
			scheduleRepeatCheck = "N";
		} else {
			scheduleRepeatCheck = "Y";
		}		
		
		String scheduleOriginalfilename = multiReq.getOriginalFileName("up_file");
		String scheduleRenamefilename = multiReq.getFilesystemName("up_file");
		String iconAlt = multiReq.getParameter("iconAlt");
		int scheduleNo = Integer.parseInt(multiReq.getParameter("scheduleNo"));
		
		Schedule s = new Schedule(); 
		s.setScheduleNo(scheduleNo);
		s.setScheduleTitle(scheduleTitle); 
		s.setScheduleContent(scheduleContent);
		s.setScheduleOriginalfilename(scheduleOriginalfilename);
		s.setScheduleRenamefilename(scheduleRenamefilename);
		s.setScheduleDdaycheck(scheduleDdayCheck);
		s.setScheduleRepeatcheck(scheduleRepeatCheck);
		s.setScheduleTimeline(scheduleTimeline);
		s.setScheduleDday(dateDday);
		s.setScheduleIcon(iconAlt);	
		
		/*System.out.println("타이틀 : "+scheduleTitle +", 내용:" +scheduleContent+ ", 디데이체크:"+scheduleDdayCheck );
		System.out.println("아이콘 : "+iconAlt);
		System.out.println("반복설정 : "+scheduleRepeatCheck);
		System.out.println("파일이름 : "+scheduleOriginalfilename + " , "+ scheduleRenamefilename);
		System.out.println("Servlet Schedule:"+s.toString());
		*/
		int result = new ScheduleService().updateSchedule(s);
		
		//4.view단 처리 
		String view = "/WEB-INF/views/common/msg.jsp"; 
		String msg = "";
		String loc = "";
		
		if(result > 0) { 
			msg = "일정 수정 성공!";
			
		} 
		else{ 
			msg = "일정 수정 실패!"; 
		}
		
		request.setAttribute("msg", msg); 
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view) .forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
