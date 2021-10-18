package com.company.dto;

import lombok.Data;

@Data
public class SearchVO {
	private Integer uno;
	private String order;
	private Integer startNum, pageLmt;
	private String option, keyword;
}
