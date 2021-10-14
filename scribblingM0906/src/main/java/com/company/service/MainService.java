package com.company.service;

import java.util.ArrayList;

import com.company.dto.BoxOfficeVO;

public interface MainService {
	public ArrayList<BoxOfficeVO> boxoffice(String targetDt) throws Exception;
}
