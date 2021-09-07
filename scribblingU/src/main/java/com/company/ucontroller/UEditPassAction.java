package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UDao;
import com.company.dto.UserDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UEditPassAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); int result = 0;
		HttpSession session = request.getSession();
		String main = request.getRequestURL()+"";
		main = main.replace(request.getRequestURI(), "/scribbling"); // 메인 주소
		UserDto dto = new UserDto(); UDao dao = new UDao(); 
		JsonObject jobj = new JsonObject(); String json = null;
		String upassword_new = request.getParameter("upassword_new");
		String upassword_conf = request.getParameter("upassword_conf");
		
		if(session.getAttribute("uno")!=null) { // 마이페이지 - 비밀번호 변경
			dto.setUno((int) session.getAttribute("uno")); // 로그인한 유저 식별번호
			String upassword = dao.upassword_search(dto); // 유저 비밀번호
			String upassword_orig = request.getParameter("upassword_orig"); // 기존 비밀번호 입력
			if(!upassword_orig.equals(upassword)) { // 비밀번호 불일치
				jobj.addProperty("result", "fail");
				jobj.addProperty("message", "기존 비밀번호가 일치하지 않습니다.");
			} else if(!upassword_new.equals(upassword_conf)) { // 새 비밀번호 확인 불일치
				jobj.addProperty("result", "fail");
				jobj.addProperty("message", "새 비밀번호 확인이 일치하지 않습니다."); // **(수정)프론트 페이지로 넘기기
			} else { // 비밀번호 변경
				dto.setUpassword(upassword_conf);
				result = dao.upassword_change(dto);
				if(result>0) { jobj.addProperty("result", "success"); }
				else { jobj.addProperty("result", "fail"); }
			}
			json = new Gson().toJson(jobj);
			out.println(json);
		} else if(session.getAttribute("vemail")!=null) { // 비밀번호 찾기 - 비밀번호 변경
			dto.setUemail((String) session.getAttribute("vemail")); // 비밀번호 찾기 실행한 유저 이메일
			dto.setUno(dao.user_search(dto)); // 유저 번호 찾기
			dto.setUpassword(upassword_conf);
			result = dao.upassword_change(dto);
			if(result>0) { 
				session.invalidate(); 
				out.println("<script>alert('비밀번호 변경에 성공했습니다.'); location.href='" 
				+ request.getContextPath() + "/account/login_page';</script>"); 
			} else { out.println("<script>alert('문제가 발생했습니다.\n관리자에게 문의 바랍니다.'); location.href='" + main + "/main.do';</script>"); }
		}
	}
}
