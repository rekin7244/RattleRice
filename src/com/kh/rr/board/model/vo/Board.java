package com.kh.rr.board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int bid;	//BID
	private int fbid;	//FBID
	private int nbid;	//NBID
	private int rbid;	//RBID
	private int refBid;	//REF_BID
	private int type;	//type
	private String writer;	//MEMBER와 조인 후 M_NAME
	private String brand;	//STORE와 조인 후 BRAND
	private String bType;	//BTYPE
	private String bContent;//BCONTENT
	private String target;	//TARGET
	private String fCategory;	//F_CATEGORY FAQ 상담유형
	private Date bDate;		//BDATE
	private int bCount;		//BCOUNT
	private int grade;		//GRADE
	
	public Board() {}

	public Board(int bid, int fbid, int nbid, int rbid, int refBid, int type, String writer, String brand, String bType,
			String bContent, String target, String fCategory, Date bDate, int bCount, int grade) {
		super();
		this.bid = bid;
		this.fbid = fbid;
		this.nbid = nbid;
		this.rbid = rbid;
		this.refBid = refBid;
		this.type = type;
		this.writer = writer;
		this.brand = brand;
		this.bType = bType;
		this.bContent = bContent;
		this.target = target;
		this.fCategory = fCategory;
		this.bDate = bDate;
		this.bCount = bCount;
		this.grade = grade;
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

	public int getRbid() {
		return rbid;
	}

	public void setRbid(int rbid) {
		this.rbid = rbid;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getfCategory() {
		return fCategory;
	}

	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", fbid=" + fbid + ", nbid=" + nbid + ", rbid=" + rbid + ", refBid=" + refBid
				+ ", type=" + type + ", writer=" + writer + ", brand=" + brand + ", bType=" + bType + ", bContent="
				+ bContent + ", target=" + target + ", fCategory=" + fCategory + ", bDate=" + bDate + ", bCount="
				+ bCount + ", grade=" + grade + "]";
	}


}
