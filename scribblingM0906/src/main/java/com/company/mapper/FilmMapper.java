package com.company.mapper;

import com.company.dto.FilmDto;

public interface FilmMapper {
	public FilmDto searchFilm(FilmDto fdto);
	public Integer insertFilm(FilmDto fdto);
}
