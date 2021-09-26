package com.company.mapper;

import java.util.List;

import com.company.dto.TagDto;

public interface TagMapper {
	public List<String> findTag(String tname);
	public Integer searchTaglib(TagDto tdto);
	public Integer insertTaglib(TagDto tdto);
	
	public int insertTag(TagDto tdto);
	public List<String> listTags(Integer sno);
}
