package com.company.dto;

public class UserDto {
	private int uno; // 자동 입력 항목
	private String uemail, upassword, uname, ubirth, upostcode, uaddress, ugender; // 필수 입력 항목
	private String udate, uip; // 자동 입력 항목
	private String uphone, utype, usubs; // 선택 입력 항목
	public UserDto() { super(); }
	public UserDto(String uemail, String upassword, String uname, String ubirth, String ugender, String upostcode, String uaddress, String uip) {
		super();
		this.uemail = uemail;
		this.upassword = upassword;
		this.uname = uname;
		this.ubirth = ubirth;
		this.ugender = ugender;
		this.upostcode = upostcode;
		this.uaddress = uaddress;
		this.uip = uip;
	} // 필수 항목 (uno와 udate는 db에서 자동으로 등록)
	public UserDto(int uno, String uemail, String uname, String ubirth, String ugender, String uphone, String upostcode,
				   String uaddress, String utype, String usubs) { super();
		this.uno = uno; this.uemail = uemail; this.uname = uname; this.ubirth = ubirth; this.upostcode = upostcode;
		this.uaddress = uaddress; this.ugender = ugender; this.uphone = uphone; this.usubs = usubs; this.utype = utype;
	} // 유저 정보 항목
	public UserDto(int uno, String uemail, String upassword, String uname, String ubirth, String ugender,
			String uphone, String upostcode, String uaddress, String utype, String usubs, String udate, String uip) {
		super(); this.uno = uno; this.uemail = uemail; this.upassword = upassword; this.uname = uname; 
		this.ubirth = ubirth; this.upostcode = upostcode; this.uaddress = uaddress; this.udate = udate; this.uip = uip;
		this.ugender = ugender; this.uphone = uphone; this.utype = utype; this.usubs = usubs;
	} // 모든 항목
	public int getUno() { return uno; }
	public void setUno(int uno) { this.uno = uno; }
	public String getUemail() { return uemail; }
	public void setUemail(String uemail) { this.uemail = uemail; }
	public String getUpassword() { return upassword; }
	public void setUpassword(String upassword) { this.upassword = upassword; }
	public String getUname() { return uname; }
	public void setUname(String uname) { this.uname = uname; }
	public String getUbirth() { return ubirth; }
	public void setUbirth(String ubirth) { this.ubirth = ubirth; }
	public String getUgender() { return ugender; }
	public void setUgender(String ugender) { this.ugender = ugender; }
	public String getUphone() { return uphone; }
	public void setUphone(String uphone) { this.uphone = uphone; }
	public String getUpostcode() { return upostcode; }
	public void setUpostcode(String upostcode) { this.upostcode = upostcode; }
	public String getUaddress() { return uaddress; }
	public void setUaddress(String uaddress) { this.uaddress = uaddress; }
	public String getUtype() { return utype; }
	public void setUtype(String utype) { this.utype = utype; }
	public String getUsubs() { return usubs; }
	public void setUsubs(String usubs) { this.usubs = usubs; }
	public String getUdate() { return udate; }
	public void setUdate(String udate) { this.udate = udate; }
	public String getUip() { return uip; }
	public void setUip(String uip) { this.uip = uip; }
	@Override
	public String toString() {
		return "UserDto [uno=" + uno + ", uemail=" + uemail + ", upassword=" + upassword + ", uname=" + uname
				+ ", ubirth=" + ubirth + ", upostcode=" + upostcode + ", uaddress=" + uaddress + ", udate=" + udate
				+ ", uip=" + uip + ", ugender=" + ugender + ", uphone=" + uphone + ", utype=" + utype + ", usubs="
				+ usubs + "]";
	}
}
