package com.company.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.BoxOfficeVO;
import com.company.dto.FilmVO;
import com.google.gson.JsonArray;

public interface ApiService {
	public void findFilm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public JsonArray boxoffice(String targetDt) throws Exception;
	public ArrayList<BoxOfficeVO> boxOfficeList(JsonArray list, String targetDt) throws Exception;
}
