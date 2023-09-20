package com.mycompany.hello.domain;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class BoardVO {
	private int BNO;
	private String TITLE;
	private String CONTENT;
	private String WRITER;

	public int getBNO() {
		return BNO;
	}

	public void setBNO(int bNO) {
		BNO = bNO;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getWRITER() {
		return WRITER;
	}

	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}

	public String getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(String rEGDATE) {
		REGDATE = rEGDATE;
	}

	public String getVIEWCNT() {
		return VIEWCNT;
	}

	public void setVIEWCNT(String vIEWCNT) {
		VIEWCNT = vIEWCNT;
	}

	private String REGDATE;
	private DATE DELETE_BOARD;

	public DATE getDELETE_BOARD() {
		return DELETE_BOARD;
	}

	public void setDELETE_BOARD(DATE dELETE_BOARD) {
		DELETE_BOARD = dELETE_BOARD;
	}

	private String VIEWCNT;
}
