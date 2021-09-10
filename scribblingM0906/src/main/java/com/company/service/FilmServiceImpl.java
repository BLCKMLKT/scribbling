package com.company.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.FilmDto;
import com.company.mapper.FilmMapper;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmMapper fmapper;
	@Override
	public FilmDto searchFilm(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		// films 테이블에서 fcode 찾기
		FilmDto fdto = new FilmDto();
		String param = request.getParameter("stitle");
		String fname = param.substring(0, param.length()-6); // 개봉연도 제거
		fdto.setFname(fname);
		fdto.setFrelease(Integer.parseInt(request.getParameter("srelease")));
		fdto.setFdirector(request.getParameter("sdirector"));
		fdto.setFcast(request.getParameter("scast"));
		fdto = fmapper.searchFilm(fdto);
		return fdto;
	}
	@Override
	public FilmDto insertFilm(HttpServletRequest request, FilmDto fdto) throws Exception {
		request.setCharacterEncoding("UTF-8");
		// films 테이블에 새로 등록하기
		fdto = fmapper.insertFilm(fdto);
		return fdto;
	}
}
