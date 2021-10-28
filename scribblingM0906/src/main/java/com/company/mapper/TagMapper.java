package com.company.mapper;

import java.util.List;

import com.company.dto.TagVO;

public interface TagMapper {
	public List<String> findTag(String tname);
	public Integer searchTaglib(TagVO tvo);
	public Integer insertTaglib(TagVO tvo);
	
	public int insertTag(TagVO tvo);
	public List<String> listTags(Integer sno);
	public int deleteTag(TagVO tvo);
}
