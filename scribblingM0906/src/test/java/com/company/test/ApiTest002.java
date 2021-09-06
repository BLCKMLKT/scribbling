package com.company.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ApiTest002 {
	@Test
	public void test() throws Exception {
		//// get방식요청 연결
		String clientId = "hU3W8GvTOMbmPfieldbB"; // 클라이언트아이디값
		String clientSecret = "D6PDEau1RQ"; // 클라이언트시크릿값
		String param = "?query=" + URLEncoder.encode("아이언맨" , "UTF-8");
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
			JsonObject json = new Gson().fromJson(sbuilder.toString(), JsonObject.class);
			JsonArray list = json.get("items").getAsJsonArray();
			System.out.println(list);
//			
//			String replace = sbuilder.toString().replaceAll("<b>", "");
//			replace = replace.replaceAll("</b>", "");
//			
//			
//			
//			
//			System.out.println(replace);
			br.close();
			conn.disconnect();
		}
	}
}
