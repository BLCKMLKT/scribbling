package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.service.ApiService;
import com.company.service.KinoService;
import com.company.service.TagService;

@Controller
@RequestMapping("/find/*")
public class FindController {
	@Autowired
	private ApiService apiService;
	@Autowired
	private KinoService kinoService;
	@Autowired
	private TagService tagService;
	
	@RequestMapping(value = "/film", method = RequestMethod.GET)
	public void find_film(HttpServletRequest request, HttpServletResponse response) throws Exception {
		apiService.findFilm(request, response);
	}
	@RequestMapping(value = "/kinoProvince", method = RequestMethod.GET)
	public void find_kinoProvince(HttpServletRequest request, HttpServletResponse response) throws Exception {
		kinoService.findKinoProvince(request, response);
	}
	@RequestMapping(value = "/kinoDistrict", method = RequestMethod.GET)
	public void find_kinoDistrict(HttpServletRequest request, HttpServletResponse response) throws Exception {
		kinoService.findKinoDistrict(request, response);
	}
	@RequestMapping(value = "/kino", method = RequestMethod.GET)
	public void find_kino(HttpServletRequest request, HttpServletResponse response) throws Exception {
		kinoService.findKino(request, response);
	}
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public void find_tag(HttpServletRequest request, HttpServletResponse response) throws Exception {
		tagService.findTag(request, response);
	}
}
