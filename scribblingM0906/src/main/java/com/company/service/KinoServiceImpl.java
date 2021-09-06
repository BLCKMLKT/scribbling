package com.company.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.mapper.KinoMapper;
import com.google.gson.Gson;

@Service
public class KinoServiceImpl implements KinoService {
	@Autowired
	private KinoMapper findMapper;
	
	@Override
	public void findKinoProvince(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String kbrand = request.getParameter("kbrand");
		List<String> list = findMapper.findKinoProvince(kbrand);
		String json = new Gson().toJson(list);
		out.println(json);
	}

	@Override
	public void findKinoDistrict(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String kbrand = request.getParameter("kbrand");
		String kprovince = request.getParameter("kprovince");
		List<String> list = findMapper.findKinoDistrict(kbrand, kprovince);
		String json = new Gson().toJson(list);
		out.println(json);
	}
	@Override
	public void findKino(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String kbrand = request.getParameter("kbrand");
		String kprovince = request.getParameter("kprovince");
		String kdistrict = request.getParameter("kdistrict");
		List<String> list = findMapper.findKino(kbrand, kprovince, kdistrict);
		String json = new Gson().toJson(list);
		out.println(json);
	}
}
