package com.company.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.FilmDto;
import com.company.mapper.FilmMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
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
		FilmDto fdto = new FilmDto();
		fdto.setFname("테스트2");
		fdto.setFrelease(2021);
		fdto.setFdirector("테스트-감독2");
		fdto.setFcast("테스트-출연진2");
		fdto.setFimg("테스트-포스터2");
		FilmDto temp = fMapper.searchFilm(fdto); // fcode 찾아오기
		log.info("...........temp : " + temp);
		log.info("...........before fdto : " + fdto);
		if(temp==null) { fdto.setFcode(fMapper.insertFilm(fdto)); } // 등록하기
		else { fdto.setFcode(temp.getFcode()); }
		log.info("...........after fdto : " + fdto);
	}
}
