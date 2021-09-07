package com.company.ucontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UDao;
import com.company.dto.UserDto;

public class UEditInfoAction implements UAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UDao dao = new UDao(); UserDto dto = new UserDto();
		HttpSession session = request.getSession();
		dto.setUno((int) session.getServletContext().getAttribute("uno"));
		UserDto temp = dao.userinfo(dto);
		request.setAttribute("dto", temp);
		String[] birth = temp.getUbirth().split("/");
		String[] address = temp.getUaddress().split("/");
		request.setAttribute("birth", birth);
		request.setAttribute("address", address);
	}
}
