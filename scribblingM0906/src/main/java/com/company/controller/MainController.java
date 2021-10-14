package com.company.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.BoxOfficeVO;
import com.company.service.ApiService;
import com.company.service.MainService;
import com.google.gson.JsonArray;

@Controller
@RequestMapping("/*.do")
public class MainController {
	@Autowired
	private MainService mservice;
	@Autowired
	private ApiService aservice;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main(HttpServletRequest request) throws Exception {
		Calendar today = Calendar.getInstance(); today.add(Calendar.DATE, -1); // 어제 날짜로 변경
		String targetDt = new SimpleDateFormat("yyyyMMdd").format(today.getTime());
		ArrayList<BoxOfficeVO> boxoffice = mservice.boxoffice(targetDt);
		System.out.println(boxoffice);
		if(boxoffice.isEmpty()) {
			JsonArray boArr = aservice.boxoffice(targetDt);
			boxoffice = aservice.boxOfficeList(boArr, targetDt);
		}
		request.setAttribute("boxoffice", boxoffice);
		return "main";
	}
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search() {
		return "/search/search";
	}
}