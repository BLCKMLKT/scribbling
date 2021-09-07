package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;
import com.company.service.FilmService;
import com.company.service.KinoService;
import com.company.service.ScribbleService;

@Controller
@RequestMapping("/scribble/*")
public class ScribbleController {
	@Autowired
	private FilmService fservice;
	@Autowired
	private KinoService kservice;
	@Autowired
	private ScribbleService sservice;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write_view() {
		return "/scribble/write";
	}
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public void write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FilmDto fdto = fservice.searchFilm(request);
		if(fdto.getFcode()==null) { fdto = fservice.insertFilm(request, fdto); }
		Integer kcode = kservice.searchKino(request);
		ScribbleDto sdto = sservice.insertScribble(request, fdto, kcode);
		
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
