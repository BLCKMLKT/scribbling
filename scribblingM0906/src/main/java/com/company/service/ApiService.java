package com.company.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.FilmVO;
import com.google.gson.JsonArray;

public interface ApiService {
	public void findFilm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public JsonArray boxoffice(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ArrayList<FilmVO> boxOfficeList(HttpServletRequest request, JsonArray list) throws Exception;
}
