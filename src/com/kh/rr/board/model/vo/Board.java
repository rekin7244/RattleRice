package com.kh.rr.board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int bid;	//BID
	private int fbid;	//FBID
	private int nbid;	//BNID
	private int refBid;	//REF_BID
	private int type;	//type
	private String writer;	//MEMBER와 조인 후 M_NAME
	private String bType;	//BTYPE
	private String bContent;//BCONTENT
	private Date bDate;		//BDATE;
	private int bCount;		//BCOUNT
	
	public Board() {}

	public Board(int bid, int fbid, int nbid, int refBid, int type, String writer, String bType, String bContent,
			Date bDate, int bCount) {
		super();
		this.bid = bid;
		this.fbid = fbid;
		this.nbid = nbid;
		this.refBid = refBid;
		this.type = type;
		this.writer = writer;
		this.bType = bType;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bCount = bCount;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getFbid() {
		return fbid;
	}

	public void setFbid(int fbid) {
		this.fbid = fbid;
	}

	public int getNbid() {
		return nbid;
	}

	public void setNbid(int nbid) {
		this.nbid = nbid;
	}

	public int getRefBid() {
		return refBid;
	}

	public void setRefBid(int refBid) {
		this.refBid = refBid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", fbid=" + fbid + ", nbid=" + nbid + ", refBid=" + refBid + ", type=" + type
				+ ", writer=" + writer + ", bType=" + bType + ", bContent=" + bContent + ", bDate=" + bDate
				+ ", bCount=" + bCount + "]";
	}
	
}
