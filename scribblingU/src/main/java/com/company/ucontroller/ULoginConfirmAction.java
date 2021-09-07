package com.company.ucontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.UDao;
import com.company.dto.UserDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ULoginConfirmAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); UserDto user = null;
		UserDto dto = new UserDto(); UDao dao = new UDao(); 
		JsonObject jobj = new JsonObject(); String json = null;
		dto.setUemail(request.getParameter("login_email"));
		int uno = dao.user_search(dto);
		if(uno>0) { // 일치하는 이메일 있을 때, 비밀번호 검사
			jobj.addProperty("uemail", "found");
			dto.setUpassword(request.getParameter("login_pw"));
			user = dao.login(dto);
		} else { // 이메일 불일치
			jobj.addProperty("uemail", "notFound");
		}
		if(user!=null) { // 일치하는 유저 있을 때, 로그인 가능
			jobj.addProperty("upassword", "match");
		} else { // 비밀번호 불일치
			jobj.addProperty("upassword", "notMatch");
		}
		json = new Gson().toJson(jobj);
		out.println(json);
	}
}
