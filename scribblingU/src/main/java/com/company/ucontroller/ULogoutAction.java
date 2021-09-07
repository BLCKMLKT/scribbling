package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ULogoutAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String main = request.getRequestURL()+"";
		main = main.replace(request.getRequestURI(), "/scribbling"); // 메인 주소
		
		session.getServletContext().removeAttribute("uno");
		out.println("<script>location.href='" + main + "/main.do';</script>");
	}
}
