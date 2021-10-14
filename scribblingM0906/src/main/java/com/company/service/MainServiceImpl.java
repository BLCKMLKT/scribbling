package com.company.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.BoxOfficeVO;
import com.company.mapper.BoxOfficeMapper;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private BoxOfficeMapper bomapper;
	
	@Override
	public ArrayList<BoxOfficeVO> boxoffice(String targetDt) throws Exception {
		ArrayList<BoxOfficeVO> list = bomapper.list(targetDt);
		return list;
	}
}
