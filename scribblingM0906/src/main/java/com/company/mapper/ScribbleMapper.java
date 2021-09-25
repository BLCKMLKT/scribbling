package com.company.mapper;

import java.util.List;

import com.company.dto.ScribbleDto;
import com.company.dto.ScribbleListDto;

public interface ScribbleMapper {
	public Integer insertScribble(ScribbleDto sdto);
	public List<ScribbleListDto> listScribble(Integer uno, int startNum, int pageLmt);
}
