package com.company.mapper;

import com.company.dto.FilmDto;

public interface FilmMapper {
	public Integer searchFilm(FilmDto fdto);
	public Integer insertFilm(FilmDto fdto);
}
