package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*.do")
public class MainController {
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search() {
		return "/search/search";
	}
}