package com.company.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.BoxOfficeVO;
import com.company.service.MainService;

@Controller
@RequestMapping("/*.do")
public class MainController {
	@Autowired
	private MainService mservice;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main() throws Exception {
		Calendar today = Calendar.getInstance(); today.add(Calendar.DATE, -1); // 어제 날짜로 변경
		String targetDt = new SimpleDateFormat("yyyyddmm").format(today.getTime());
		ArrayList<BoxOfficeVO> boxoffice = mservice.boxoffice(targetDt);
		return "main";
	}
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search() {
		return "/search/search";
	}
}