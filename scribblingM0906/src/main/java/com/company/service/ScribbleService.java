package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;

public interface ScribbleService {
	public ScribbleDto insertScribble(HttpServletRequest request, FilmDto fdto, Integer kcode) throws Exception;
}
