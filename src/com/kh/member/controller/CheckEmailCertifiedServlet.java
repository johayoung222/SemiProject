package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.email.SMTPAuthenticatior;

/**
 * Servlet implementation class CheckEmailCertifiedServlet
 */
@WebServlet("/member/checkEmailCertified")
public class CheckEmailCertifiedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param session2 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
       
		//받는사람(사용자입력)
		String email = request.getParameter("memberEmail");
		System.out.println("servlet Email=="+email);
		
		
		//보내는 사람
		String from = "7sscheduler@gmail.com";
		
		//제목
		String subject = "7's Scheduler 인증 확인 메일";
		
		//내용(인증번호)
		int certified = ((int) (Math.random() * 899999)+100000);
		request.setAttribute("certified", certified);
		String content = "인증번호 : ["+certified+"]";
		
		// 정보를 담을 객체
		Properties p = new Properties();

		p.put("mail.smtp.host","smtp.gmail.com"); // 구글 SMTP
		 
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들
		 
		try{
		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, auth);
		     
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    // 제목
		    msg.setSubject(subject);
		     
		    // 보내는 사람
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr);
		     
		    // 받는 사람
		    Address toAddr = new InternetAddress(email);
		    msg.addRecipient(Message.RecipientType.TO, toAddr);
		    
		    // 내용과 인코딩
		    msg.setContent(content, "text/html; charset=UTF-8");
		     
		    Transport.send(msg); // 전송
		} catch(Exception e){
		    e.printStackTrace();
		    return;
		}
		 
		request.getRequestDispatcher("/WEB-INF/views/member/sendMailpopup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
