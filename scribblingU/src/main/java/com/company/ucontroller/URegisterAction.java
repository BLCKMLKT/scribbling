package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.UDao;
import com.company.dto.UserDto;

public class URegisterAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UDao dao = new UDao(); UserDto dto = new UserDto(); 
		int result = 0; PrintWriter out = response.getWriter();
		String main = request.getRequestURL()+"";
		main = main.replace(request.getRequestURI(), "/scribbling"); // 메인 주소
		String uemail = request.getParameter("useremail");
		String upassword = request.getParameter("userpw1");
		String uname = request.getParameter("username");
		String ubirth = request.getParameter("useryear") + "/" + request.getParameter("usermonth")
						+ "/" + request.getParameter("userdate");
		String ugender = request.getParameter("usergender");
		String upostcode = request.getParameter("postcode");
		String uaddress = request.getParameter("address1") + "/" + request.getParameter("address2");
		String uip = InetAddress.getLocalHost().getHostAddress();
		dto.setUemail(uemail); dto.setUpassword(upassword); dto.setUname(uname);
		dto.setUbirth(ubirth); dto.setUgender(ugender); dto.setUpostcode(upostcode);
		dto.setUaddress(uaddress); dto.setUip(uip);
		result = dao.join(dto);
		if(result>0) {
			out.println("<script>alert('회원가입에 성공했습니다.'); location.href='"
						+ main + "/main.do';</script>");
		} else {
			out.println("<script>alert('회원가입에 실패했습니다. 관리자에게 문의해주세요.'); " 
						+ "history.go(-1);</script>");
		}
	}
}
