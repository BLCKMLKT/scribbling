package com.company.mapper;

import java.util.ArrayList;

import com.company.dto.BoxOfficeVO;

public interface BoxOfficeMapper {
	public ArrayList<BoxOfficeVO> list(String bdate);
	public void insert(BoxOfficeVO bovo);
}
