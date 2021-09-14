package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.ScribbleDto;

public interface TagService {
	public void findTag(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void insertTag(HttpServletRequest request, ScribbleDto sdto) throws Exception;
}
