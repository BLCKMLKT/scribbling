package com.company.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;
import com.company.dto.ScribbleListDto;

public interface ScribbleService {
	public Integer insertScribble(HttpServletRequest request) throws Exception;
	public List<ScribbleListDto> scribbleList(HttpServletRequest request) throws Exception;
}
