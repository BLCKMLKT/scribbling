package com.company.dto;

import java.util.List;

import lombok.Data;

@Data
public class ScribbleListDto {
	private Integer sno;
	private String sdate;
	private Integer srate;
	private String scontent, fname, fimg;
	private String kname, spublishdate;
	private List<String> tags;
}
