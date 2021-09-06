package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ApiService {
	public void findFilm(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
