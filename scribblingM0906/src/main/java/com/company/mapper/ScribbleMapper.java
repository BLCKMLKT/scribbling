package com.company.mapper;

import java.util.HashMap;
import java.util.List;

import com.company.dto.ScribbleVO;
import com.company.dto.SearchVO;

public interface ScribbleMapper {
	public Integer insertScribble(ScribbleVO svo);
	public List<ScribbleVO> listScribble(SearchVO shvo);
	public ScribbleVO detailScribble(Integer uno, Integer sno);
	public void editScribble(ScribbleVO svo);
}
