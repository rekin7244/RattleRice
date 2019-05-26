package com.kh.rr.board.model.vo;

import java.sql.Date;

public class BoardReply implements java.io.Serializable{
	private int reid; //REID
	private int bid; //BID
	private String rWriter; //RWRITER
	private String rContent; //RCONTENT
	private Date rDate; //RDATE
	
	public BoardReply() {}

	public BoardReply(int reid, int bid, String rWriter, String rContent, Date rDate) {
		super();
		this.reid = reid;
		this.bid = bid;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rDate = rDate;
	}

	public int getReid() {
		return reid;
	}

	public void setReid(int reid) {
		this.reid = reid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	@Override
	public String toString() {
		return "BoardReply [reid=" + reid + ", bid=" + bid + ", rWriter=" + rWriter + ", rContent=" + rContent
				+ ", rDate=" + rDate + "]";
	}
}