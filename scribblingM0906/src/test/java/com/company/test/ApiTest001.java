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
import com.google.gson.JsonParser;

public class ApiTest001 {
	@Test
	public void jsonTest() throws Exception {
		// get 방식 요청 연결
		String param = "?key=" + URLEncoder.encode("dabd87756e9bed1f64e135108b92f184", "UTF-8");
		param = param + "&itemPerPage=" +  URLEncoder.encode("10", "UTF-8");
		param = param + "&movieNm=" + URLEncoder.encode("아이언맨", "UTF-8");
		
		URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json" + param);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 옵션
		conn.setDoInput(true); conn.setDoOutput(true); conn.setRequestMethod("GET");
		// 연결 및 데이터 받아오기 + 끊기
		if(conn.getResponseCode() == 200) {
			StringBuilder sbuilder = new StringBuilder();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			while( (line = bReader.readLine()) != null ) { sbuilder.append(line); }
			
			JsonObject json = new Gson().fromJson(sbuilder.toString(), JsonObject.class);
			JsonArray json1 = json.get("movieListResult").getAsJsonObject().get("movieList").getAsJsonArray();
			JsonArray related = new JsonArray();
			JsonArray notRelated = new JsonArray();
			for(int i=0; i<json1.size(); i++) {
				JsonObject temp = json1.get(i).getAsJsonObject();
				String name = temp.get("movieNm").getAsString();
				if(name.startsWith("아이언맨")) { related.add(temp); }
				else { notRelated.add(temp); }
			}
//			System.out.println(sbuilder.toString());
			bReader.close();
			conn.disconnect();
		}
	}
}
