package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UDao;
import com.company.dto.UserDto;

public class UForgotPass implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String recipient = request.getParameter("uemail"); // 수신자
		String host = "LNscribbling@gmail.com", pw = "mkl990802"; // 발신자
		HttpSession session = request.getSession();
		UserDto dto = new UserDto(); UDao dao = new UDao();
		dto.setUemail(recipient); 
		int result = dao.user_search(dto);
		if(result>0) {
			int vcode = new Random().nextInt(999999); // 6자리 랜덤 숫자 인증번호 생성
			request.setAttribute("vcode", vcode); // 인증번호 parse
			session.setAttribute("vemail", recipient); // 세션에 이메일 저장
			// property 셋업
			Properties prop = System.getProperties(); 
			prop.put("mail.smtp.starttls.enable", "true"); // gmail은 무조건 true 고정
			// prop.put("mail.smtp.host", "smtp.gmail.com");  // smtp 서버 주소
			prop.put("mail.smtp.auth","true");             // gmail은 무조건 true 고정
			prop.put("mail.smtp.port", "587");             // gmail 포트
			prop.put("mail.transport.protocol","smtp"); // 전송 방식
			prop.put("mail.smtp.ssl.trust","smtp.gmail.com"); // ssl 보안 설정
			prop.put("mail.smtp.ssl.protocols","TLSv1.2");
			// 메일 세션
			Session mailSession = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(host, pw);
				}
			}); // 보안 접근
			// 수신자 설정
			MimeMessage msg = new MimeMessage(mailSession); 
			try {
				msg.setFrom(new InternetAddress(host));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
				// msg.addRecipient(Message.RecipientType.CC, new InternetAddress()); // 참조
				// 제목 설정
				String emailsbj = "Scribbling - 비밀번호를 변경해주세요.";
				msg.setSubject(emailsbj); 
				// 내용 설정
				String emailBody = "인증 페이지에서 아래 인증번호를 입력해주세요." + "<br><br>" + vcode; 
				msg.setContent(emailBody, "text/html; charset=euc-kr"); 
				// 발신
				Transport transport = mailSession.getTransport("smtp"); 
				transport.connect("smtp.gmail.com", host, pw); 
				transport.sendMessage(msg, msg.getAllRecipients()); 
				transport.close();
			} catch (Exception e) { e.printStackTrace(); }
			request.getRequestDispatcher("/account/verify_code").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('계정 정보를 찾을 수 없습니다.'); history.go(-1);</script>");
		}
	}
}
