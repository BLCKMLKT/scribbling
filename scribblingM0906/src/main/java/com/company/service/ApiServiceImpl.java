package com.company.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService {
	@Override
	public void findFilm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String stitle = request.getParameter("stitle");
		//// get방식요청 연결
		String clientId = "hU3W8GvTOMbmPfieldbB"; // 클라이언트아이디값
		String clientSecret = "D6PDEau1RQ"; // 클라이언트시크릿값
		String param = "?query=" + URLEncoder.encode(stitle , "UTF-8");
		URL url = new URL("https://openapi.naver.com/v1/search/movie.json"+ param);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//// 옵션
		conn.setRequestProperty("X-Naver-Client-Id", clientId);
		conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		conn.setDoInput(true); conn.setDoOutput(true); conn.setRequestMethod("GET");
		//// 연결 및 데이터 받아오기 + 끊기
		if(conn.getResponseCode() == 200){
			StringBuilder sbuilder = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line ="";
			while( (line = br.readLine()) != null){ sbuilder.append(line); }
			String result = sbuilder.toString().replaceAll("<b>", "").replaceAll("</b>", "").replaceAll("amp;", "");
			out.println(result);
			br.close();
			conn.disconnect();
		}
	}
}