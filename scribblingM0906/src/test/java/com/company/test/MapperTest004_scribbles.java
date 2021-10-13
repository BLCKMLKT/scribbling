package com.company.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.ScribbleVO;
import com.company.dto.ScribbleListVO;
import com.company.mapper.ScribbleMapper;
import com.company.mapper.TagMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MapperTest004_scribbles {
	@Autowired
	private ScribbleMapper mapper;
	@Autowired
	private TagMapper tMapper;
	
	@Test
//	public void insertScribble() throws UnknownHostException {
//		ScribbleDto dto = new ScribbleDto();
//		dto.setSdate("2021/09/21");
//		dto.setUno(3);
//		dto.setFcode(3);
//		dto.setKcode(3);
//		dto.setSrate(3);
//		dto.setScontent("test3");
//		dto.setSip(InetAddress.getLocalHost().getHostAddress());
//		mapper.insertScribble(dto);
//		System.out.println("last insert sno : " + dto.getSno());
//	}
	
	public void listScribble() throws Exception {
		List<ScribbleVO> sList = mapper.listScribble(1, 0, 10);
		for(int i=0; i<sList.size(); i++) {
			ScribbleVO temp = sList.get(i);
			List<String> tList = tMapper.listTags(temp.getSno());
		}
	}
}
