package com.company.dto;

import lombok.Data;

@Data
public class ScribbleDto {
	private int sno;
	private String sdate;
	private int uno, fcode, kcode, srate;
	private String scontent, sip, spublishdate;
}
