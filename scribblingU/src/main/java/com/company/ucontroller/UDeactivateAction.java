package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UDao;
import com.company.dto.UserDto;

public class UDeactivateAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String main = request.getRequestURL()+"";
		main = main.replace(request.getRequestURI(), "/scribbling"); // 메인 주소
		UDao dao = new UDao(); UserDto dto = new UserDto(); int result = 0;
		String upassword = request.getParameter("upassword");
		dto.setUno((int) session.getServletContext().getAttribute("uno"));
		dto = dao.userinfo(dto);
		if(upassword.equals(dto.getUpassword())) {
			result = dao.deactivate(dto);
		}
		if(result>0) {
			session.getServletContext().removeAttribute("uno"); // 세션 종료
			out.println("<script>alert('회원탈퇴에 성공했습니다.'); location.href='"
					+ main + "/main.do';</script>");
		} else {
			out.println("<script>alert('회원탈퇴에 실패했습니다. 관리자에게 문의해주세요.'); " 
					+ "history.go(-1);</script>");
		}
	}
}
