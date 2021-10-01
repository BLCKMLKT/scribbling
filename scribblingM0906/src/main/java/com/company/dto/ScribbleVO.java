package com.company.dto;

import java.util.List;

import lombok.Data;

@Data
public class ScribbleVO {
	private Integer sno;
	private String sdate;
	private Integer uno, srate;
	private String scontent, sip, spublishdate;
	private FilmVO fvo;
	private KinoVO kvo;
	private List<TagVO> tags;
}
