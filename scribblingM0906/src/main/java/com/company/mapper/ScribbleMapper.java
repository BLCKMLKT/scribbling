package com.company.mapper;

import java.util.List;

import com.company.dto.ScribbleVO;

public interface ScribbleMapper {
	public Integer insertScribble(ScribbleVO sdto);
	public List<ScribbleVO> listScribble(Integer uno, int startNum, int pageLmt);
	public ScribbleVO detailScribble(Integer uno, Integer sno);
}
