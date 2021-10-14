package com.company.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.BoxOfficeVO;
import com.company.mapper.BoxOfficeMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class ApiServiceImpl implements ApiService {
	@Autowired
	private BoxOfficeMapper bomapper;
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
	@Override
	public JsonArray boxoffice(String targetDt) throws Exception {
		String param = "?key=" + URLEncoder.encode("dabd87756e9bed1f64e135108b92f184" , "UTF-8");
		param = param + "&targetDt=" + URLEncoder.encode(targetDt, "UTF-8");
		URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"+ param);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		JsonArray list = null;
		if(conn.getResponseCode() == 200){
			StringBuilder sbuilder = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line ="";
			while( (line = br.readLine()) != null){ sbuilder.append(line); }
			JsonObject json = new Gson().fromJson(sbuilder.toString(), JsonObject.class);
			list = json.getAsJsonObject("boxOfficeResult").get("dailyBoxOfficeList").getAsJsonArray();
			br.close();
			conn.disconnect();
		}
		return list;
	}
	@Override
	public ArrayList<BoxOfficeVO> boxOfficeList(JsonArray list, String targetDt) throws Exception {
		ArrayList<BoxOfficeVO> boxOfficeList = new ArrayList<>();
		
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // 최대크기로
		options.addArguments("--headless"); // Browser를 띄우지 않음
		options.addArguments("--disable-gpu"); // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
		options.addArguments("--no-sandbox"); // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
 
    	ChromeDriver driver = new ChromeDriver(options);
    	for(int i=0; i<list.size(); i++) {
    		BoxOfficeVO temp = new BoxOfficeVO();
    		JsonObject tempj = list.get(i).getAsJsonObject();
    		temp.setBrank(i); temp.setBdate(targetDt); // 영화 순위 / 박스오피스 날짜
    		temp.setFname(tempj.get("movieNm").getAsString()); // 영화 제목 가져오기
    		String movieCd = tempj.get("movieCd").getAsString(); // 영진위 영화 코드 가져오기
    		driver.get("https://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do?dtTp=movie&dtCd=" + movieCd); // 영화 코드로 영진위 영화 정보 검색
    		WebElement poster = driver.findElement(By.cssSelector("a.fl.thumb > img"));
    		String posterUrl = poster.getAttribute("src"); // 포스터 이미지 추출
    		temp.setFimg(posterUrl);
    		bomapper.insert(temp); // DB에 입력
    	}
    	driver.quit();
		return boxOfficeList;
	}
}