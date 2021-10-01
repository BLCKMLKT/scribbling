package com.company.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.TagVO;
import com.company.mapper.TagMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MapperTest002_tag {
	@Autowired
	private TagMapper tmapper;
	
	@Test
//	public void findTag()	{
//		List<String> list = tmapper.findTag("사극");
//		String json = new Gson().toJson(list);
//		System.out.println(json);
//	}
//	public void searchTaglib() {
//		String tid = tmapper.searchTaglib("사극");
//		String tid1 = tmapper.searchTaglib("정극");
//		System.out.println(tid + " / " + tid1);
//	}
	public void insertTag() {
		TagVO dto = new TagVO();
		dto.setTid(1); dto.setSno(1); dto.setFcode(1);
		tmapper.insertTag(dto);
	}
}
