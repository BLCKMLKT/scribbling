package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UDao;
import com.company.dto.UserDto;

public class ULoginAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String main = request.getRequestURL()+"";
		main = main.replace(request.getRequestURI(), "/scribbling");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UserDto dto = new UserDto(); UDao dao = new UDao();
		
		String uemail = request.getParameter("login_email");
		String remember = request.getParameter("remember");
		String upassword = request.getParameter("login_pw");
		dto.setUemail(uemail); dto.setUpassword(upassword);
		UserDto user = dao.login(dto);
		if(remember!=null) {
			Cookie idCookie = new Cookie("uemail", uemail);
			Cookie rCookie = new Cookie("remember", "checked");
			response.addCookie(idCookie); response.addCookie(rCookie);
		} else {
			String cookie = request.getHeader("Cookie");
			if(cookie!=null) {
				Cookie[] cookies = request.getCookies();
				for(int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().equals("remember")||cookies[i].getName().equals("uemail")) {
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				} // 쿠키 삭제
			}
		}
		
		if(user!=null) {
			session.getServletContext().setAttribute("uno", user.getUno());
			session.getServletContext().setAttribute("uname", user.getUname());
			out.println("<script>location.href='" + main + "/main.do'</script>");
		} else {
			out.println("<script>alert('로그인에 실패했습니다. 관리자에게 문의해주세요.');" 
						+ " history.go(-1);</script>");
		}
	}
}
