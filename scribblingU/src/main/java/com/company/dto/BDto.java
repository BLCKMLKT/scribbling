package com.company.dto;

public class BDto {
	private int bno, bhit;
	private String bname, bpass, btitle, bdate, bcontent, bip, bimg;
	public BDto() { super(); }
	public BDto(int bno, String bname, String bpass, String btitle, String bcontent, String bdate, int bhit, String bip) {
		super(); this.bno = bno; this.bhit = bhit; this.bname = bname; this.bpass = bpass;
		this.btitle = btitle; this.bdate = bdate; this.bcontent = bcontent; this.bip = bip;
	}
	public BDto(int bno, String bname, String bpass, String btitle, String bcontent, String bdate, int bhit, String bip,
			String bimg) {
		super(); this.bno = bno; this.bhit = bhit; this.bname = bname; this.bpass = bpass;
		this.btitle = btitle; this.bdate = bdate; this.bcontent = bcontent; this.bip = bip; this.bimg = bimg;
	}
	public int getBno() { return bno; }
	public void setBno(int bno) { this.bno = bno; }
	public int getBhit() { return bhit; }
	public void setBhit(int bhit) { this.bhit = bhit; }
	public String getBname() { return bname; }
	public void setBname(String bname) { this.bname = bname; }
	public String getBpass() { return bpass; }
	public void setBpass(String bpass) { this.bpass = bpass; }
	public String getBtitle() { return btitle; }
	public void setBtitle(String btitle) { this.btitle = btitle; }
	public String getBdate() { return bdate; }
	public void setBdate(String bdate) { this.bdate = bdate; }
	public String getBcontent() { return bcontent; }
	public void setBcontent(String bcontent) { this.bcontent = bcontent; }
	public String getBip() { return bip; }
	public void setBip(String bip) { this.bip = bip; }
	public String getBimg() { return bimg; }
	public void setBimg(String bimg) { this.bimg = bimg; }
	@Override
	public String toString() {
		return "BDto [bno=" + bno + ", bhit=" + bhit + ", bname=" + bname + ", bpass=" + bpass + ", btitle=" + btitle
				+ ", bdate=" + bdate + ", bcontent=" + bcontent + ", bip=" + bip + ", bimg=" + bimg + "]";
	}
}
