package com.mycompany.hello.domain;

import java.util.Date;


import lombok.Data;



@Data
public class MemberVO {
	private int USER_ID;
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONENUM() {
		return PHONENUM;
	}
	public void setPHONENUM(String pHONENUM) {
		PHONENUM = pHONENUM;
	}
	public String getBURTH() {
		return BURTH;
	}
	public void setBURTH(String bURTH) {
		BURTH = bURTH;
	}
	public Date getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}
	public String getDELETE_YN() {
		return DELETE_YN;
	}
	public void setDELETE_YN(String dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}
	public String getUPDAYE_YN() {
		return UPDAYE_YN;
	}
	public void setUPDAYE_YN(String uPDAYE_YN) {
		UPDAYE_YN = uPDAYE_YN;
	}
	public String getDELETE_DATE() {
		return DELETE_DATE;
	}
	public void setDELETE_DATE(String dELETE_DATE) {
		DELETE_DATE = dELETE_DATE;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	public Integer getMEMCNT() {
		return MEMCNT;
	}
	public void setMEMCNT(Integer mEMCNT) {
		MEMCNT = mEMCNT;
	}
	public String getADMIN() {
		return ADMIN;
	}
	public void setADMIN(String aDMIN) {
		ADMIN = aDMIN;
	}
	private String ID;
	private String PASSWORD;
	private String NAME;
	private String EMAIL;
	private String PHONENUM;
	private String BURTH;
	private Date REGDATE;
	private String DELETE_YN;
	private String UPDAYE_YN;
	private String DELETE_DATE;
	private String UPDATE_DATE;
	private Integer MEMCNT;
	private String ADMIN;
	
	
}
