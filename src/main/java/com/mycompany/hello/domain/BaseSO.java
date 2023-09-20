package com.mycompany.hello.domain;

import lombok.Data;

@Data
public class BaseSO{
	public Integer getCur_page() {
		return cur_page;
	}
	public void setCur_page(Integer cur_page) {
		this.cur_page = cur_page;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getStartindex() {
		return startindex;
	}
	public void setStartindex(Integer startindex) {
		this.startindex = startindex;
	}
	public Integer getEndindex() {
		return endindex;
	}
	public void setEndindex(Integer endindex) {
		this.endindex = endindex;
	}
	private Integer cur_page;
	private Integer row;
	private Integer startindex;
	private Integer endindex;

}
