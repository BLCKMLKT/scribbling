package com.company.dto;

import lombok.Data;

@Data
public class UserVO {
	private int uno; // 자동 입력 항목
	private String uemail, upassword, uname, ubirth, upostcode, uaddress, ugender; // 필수 입력 항목
	private String udate, uip; // 자동 입력 항목
	private String uphone, utype, usubs; // 선택 입력 항목
}
