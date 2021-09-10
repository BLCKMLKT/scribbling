package com.company.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.FilmDto;

public interface FilmService {
	public FilmDto searchFilm(HttpServletRequest request) throws Exception;
	public FilmDto insertFilm(HttpServletRequest request, FilmDto fdto) throws Exception;
}
