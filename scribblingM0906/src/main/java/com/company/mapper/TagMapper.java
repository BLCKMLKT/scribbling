package com.company.mapper;

import java.util.List;

import com.company.dto.TagVO;

public interface TagMapper {
	public List<String> findTag(String tname);
	public Integer searchTaglib(TagVO tdto);
	public Integer insertTaglib(TagVO tdto);
	
	public int insertTag(TagVO tdto);
	public List<String> listTags(Integer sno);
}
