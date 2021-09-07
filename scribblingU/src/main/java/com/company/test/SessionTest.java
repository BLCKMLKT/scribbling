package com.company.test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTest {
	public SessionTest() {}
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ServletContext memberContext = request.getSession().getServletContext().getContext("/scribbling");
		memberContext.setAttribute("member", "member1");
	}
}
