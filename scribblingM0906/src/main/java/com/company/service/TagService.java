package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TagService {
	public void findTag(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void insertTag(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
