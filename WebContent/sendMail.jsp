
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="com.kh.email.SMTPAuthenticatior"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String email = request.getParameter("memberEmail");
String from = "qkrqh0212@gmail.com";
String to = "soads1@naver.com";//사용자 이메일

String subject = "7's Scheduler 인증 확인 메일";
String content = "인증번호 : ["+((int) (Math.random() * 999999)+100000)+"]";
System.out.println(email);

Properties p = new Properties(); // 정보를 담을 객체

p.put("mail.smtp.host","smtp.gmail.com"); // 네이버 SMTP
 
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
    msg.setSubject(subject); // 제목
     
    Address fromAddr = new InternetAddress(from);
    msg.setFrom(fromAddr); // 보내는 사람
    System.out.println(fromAddr);
     
    Address toAddr = new InternetAddress(email);
    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
    System.out.println(toAddr); 
    
    msg.setContent(content, "text/html; charset=UTF-8"); // 내용과 인코딩
     
    Transport.send(msg); // 전송
} catch(Exception e){
    e.printStackTrace();
    out.println("<script>alert('Send Mail Failed..');history.back();</script>");
    // 오류 발생시 뒤로 돌아가도록
    return;
}
 
out.println("<script>alert('Send Mail Success!!');</script>");//location.href='mailForm.html';
// 성공 시
%>
<scrpit>
$(function(){
	var popup = open("", target, "left=300px, top=100px, height=200px, width=300px");
});
</scrpit>