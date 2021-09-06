package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/scribble/*")
public class ScribbleController {
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write_view() {
		return "/scribble/write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public void write() {
		
	}
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit() {
		return "/scribble/edit";
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail() {
		return "/scribble/detail";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "/scribble/list";
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete() {
		return "/scribble/delete";
	}
}
