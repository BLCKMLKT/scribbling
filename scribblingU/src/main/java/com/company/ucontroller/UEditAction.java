package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UDao;
import com.company.dto.UserDto;

public class UEditAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UDao dao = new UDao(); UserDto dto = new UserDto(); 
		int result = 0; PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int uno = (int) session.getServletContext().getAttribute("uno");
		String ubirth = request.getParameter("useryear") + "/" + request.getParameter("usermonth")
						+ "/" + request.getParameter("userdate");
		String ugender = request.getParameter("usergender");
		String upostcode = request.getParameter("postcode");
		String uaddress = request.getParameter("address1") + "/" + request.getParameter("address2");
		dto.setUno(uno); dto.setUbirth(ubirth); dto.setUgender(ugender);
		dto.setUpostcode(upostcode); dto.setUaddress(uaddress);
		result = dao.edit_userinfo(dto);
		if(result>0) {
			out.println("<script>alert('회원정보 수정에 성공했습니다.'); location.href='"
						+ request.getContextPath() + "/account/info';</script>");
		} else {
			out.println("<script>alert('회원정보 수정에 실패했습니다. 관리자에게 문의해주세요.'); " 
						+ "history.go(-1);</script>");
		}	
	}
}
