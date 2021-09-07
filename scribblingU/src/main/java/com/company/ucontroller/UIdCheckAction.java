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

public class UIdCheckAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		UserDto dto = new UserDto(); UDao dao = new UDao(); 
		JsonObject jobj = new JsonObject(); String json = null;
		dto.setUemail(request.getParameter("useremail"));
		int uno = dao.user_search(dto);
		if(uno>0) { // 일치하는 이메일 있을 때, 비밀번호 검사
			jobj.addProperty("result", "dupl");
		} else { // 이메일 불일치
			jobj.addProperty("result", "notDupl");
		}
		json = new Gson().toJson(jobj);
		out.println(json);
	}
}
