package com.company.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.FilmDto;
import com.company.mapper.FilmMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MapperTest001_film {
	@Autowired
	private FilmMapper fMapper;
	
//	@Test
//	public void searchFilm() {
//		FilmDto dto = new FilmDto();
//		dto.setFname("test"); dto.setFrelease(2021);
//		fMapper.searchFilm(dto);
//	}
	
	@Test
	public void insertFilm() {
		FilmDto dto = new FilmDto();
		dto.setFname("test1"); dto.setFrelease(2021);
		dto.setFdirector("test1"); dto.setFcast("test1|test1");
		fMapper.insertFilm(dto); 
	}
}
