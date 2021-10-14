package com.company.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApiTest002 {
//	@Test
//	public void test1() throws Exception { // 네이버 영화 api 테스트
//		//// get방식요청 연결
//		String clientId = "hU3W8GvTOMbmPfieldbB"; // 클라이언트아이디값
//		String clientSecret = "D6PDEau1RQ"; // 클라이언트시크릿값
//		String param = "?query=" + URLEncoder.encode("아이언맨" , "UTF-8");
//		URL url = new URL("https://openapi.naver.com/v1/search/movie.json"+ param);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		//// 옵션
//		conn.setRequestProperty("X-Naver-Client-Id", clientId);
//		conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//		conn.setDoInput(true); conn.setDoOutput(true); conn.setRequestMethod("GET");
//		//// 연결 및 데이터 받아오기 + 끊기
//		if(conn.getResponseCode() == 200){
//			StringBuilder sbuilder = new StringBuilder();
//			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line ="";
//			while( (line = br.readLine()) != null){ sbuilder.append(line); }
//			JsonObject json = new Gson().fromJson(sbuilder.toString(), JsonObject.class);
//			JsonArray list = json.get("items").getAsJsonArray();
//			System.out.println(list);
//			String replace = sbuilder.toString().replaceAll("<b>", "");
//			replace = replace.replaceAll("</b>", "");
//			System.out.println(replace);
//			br.close();
//			conn.disconnect();
//		}
//	}
	@Test
	public void test2() throws Exception {
		Calendar today = Calendar.getInstance(); today.add(Calendar.DATE, -1); // 어제 날짜로 변경
		String targetDt = new SimpleDateFormat("YYYYMMdd").format(today.getTime());
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
		System.out.println(list);
	}
	
//    @Test
//    public void test3(){ // 셀레니움 동적 페이지 스크래핑 테스트
//    	WebDriverManager.chromedriver().setup(); 
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized"); // 최대크기로
//		options.addArguments("--headless"); // Browser를 띄우지 않음
//		options.addArguments("--disable-gpu"); // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
//		options.addArguments("--no-sandbox"); // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
// 
//    	ChromeDriver driver = new ChromeDriver(options);
//        driver.get("https://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do?dtTp=movie&dtCd=20112443"); // URL로 접속하기
//        WebElement poster = driver.findElement(By.cssSelector("a.fl.thumb > img"));
//        String posterUrl = poster.getAttribute("src");
//        System.out.println(posterUrl);
//    }
}
