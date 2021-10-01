package com.company.mapper;

import com.company.dto.FilmVO;

public interface FilmMapper {
	public Integer searchFilm(FilmVO fdto);
	public Integer insertFilm(FilmVO fdto);
}
