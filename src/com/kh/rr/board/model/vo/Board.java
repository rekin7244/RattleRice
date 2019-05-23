package com.kh.rr.board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int bid;	//BID
	private int fbid;	//FBID
	private int nbid;	//NBID
	private int rbid;	//RBID
	private int fbbid;  //FBBID
	private int jbbid;	//JBBID
	private int refBid;	//REF_BID
	private int type;	//type
	private String title;
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

	public Board(int bid, int fbid, int nbid, int rbid, int fbbid, int jbbid, int refBid, int type, String title,
			String writer, String brand, String bType, String bContent, String target, String fCategory, Date bDate,
			int bCount, int grade) {
		super();
		this.bid = bid;
		this.fbid = fbid;
		this.nbid = nbid;
		this.rbid = rbid;
		this.fbbid = fbbid;
		this.jbbid = jbbid;
		this.refBid = refBid;
		this.type = type;
		this.title = title;
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

	public int getFbid() {
		return fbid;
	}

	public int getNbid() {
		return nbid;
	}

	public int getRbid() {
		return rbid;
	}

	public int getFbbid() {
		return fbbid;
	}

	public int getJbbid() {
		return jbbid;
	}

	public int getRefBid() {
		return refBid;
	}

	public int getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getBrand() {
		return brand;
	}

	public String getbType() {
		return bType;
	}

	public String getbContent() {
		return bContent;
	}

	public String getTarget() {
		return target;
	}

	public String getfCategory() {
		return fCategory;
	}

	public Date getbDate() {
		return bDate;
	}

	public int getbCount() {
		return bCount;
	}

	public int getGrade() {
		return grade;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setFbid(int fbid) {
		this.fbid = fbid;
	}

	public void setNbid(int nbid) {
		this.nbid = nbid;
	}

	public void setRbid(int rbid) {
		this.rbid = rbid;
	}

	public void setFbbid(int fbbid) {
		this.fbbid = fbbid;
	}

	public void setJbbid(int jbbid) {
		this.jbbid = jbbid;
	}

	public void setRefBid(int refBid) {
		this.refBid = refBid;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", fbid=" + fbid + ", nbid=" + nbid + ", rbid=" + rbid + ", fbbid=" + fbbid
				+ ", jbbid=" + jbbid + ", refBid=" + refBid + ", type=" + type + ", title=" + title + ", writer="
				+ writer + ", brand=" + brand + ", bType=" + bType + ", bContent=" + bContent + ", target=" + target
				+ ", fCategory=" + fCategory + ", bDate=" + bDate + ", bCount=" + bCount + ", grade=" + grade + "]";
	}
}
