package com.company.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mapper.KinoMapper;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MapperTest003_kino {
	@Autowired
	private KinoMapper mapper;
	@Test
	public void test() {
		List<String> result = mapper.findKinoProvince("CGV");
		System.out.println(result);
	}
//	public void test() {
//		List<String> list = mapper.findKinoDistrict("CGV", "강원도");
//		String json = new Gson().toJson(list);
//		System.out.println(json);
//	}
//	public void test1() {
//		List<String> list = mapper.findKino("CGV", "강원도", "강릉시");
//		String json = new Gson().toJson(list);
//		System.out.println(json);
//	}
}
