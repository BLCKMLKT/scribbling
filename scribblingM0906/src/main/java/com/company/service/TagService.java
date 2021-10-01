package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.ScribbleVO;

public interface TagService {
	public void findTag(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
