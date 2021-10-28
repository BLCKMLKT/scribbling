package com.company.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.company.dto.ScribbleVO;

public interface ScribbleService {
	public Integer scribbleInsert(HttpServletRequest request) throws Exception;
	public List<ScribbleVO> scribbleList(HttpServletRequest request) throws Exception;
	public ScribbleVO scribbleDetail(HttpServletRequest request) throws Exception;
	public int scribbleEdit(HttpServletRequest request) throws Exception;
}
