package com.company.dto;

import lombok.Data;

@Data
public class ScribbleDto {
	private Integer sno;
	private String sdate;
	private Integer uno, fcode, kcode, srate;
	private String scontent, sip, spublishdate;
}
