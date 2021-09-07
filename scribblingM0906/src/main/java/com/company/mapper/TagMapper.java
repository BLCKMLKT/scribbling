package com.company.mapper;

import java.util.List;

import com.company.dto.TagDto;

public interface TagMapper {
	public List<String> findTag(String tname);
	public Integer searchTaglib(String tname);
	public Integer insertTaglib(String tname);
	
	public int insertTag(TagDto tdto);
}
