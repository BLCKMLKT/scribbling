package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;

public interface ScribbleService {
	public Integer insertScribble(HttpServletRequest request) throws Exception;
}
