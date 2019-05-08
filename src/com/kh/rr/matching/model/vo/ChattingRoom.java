package com.kh.rr.matching.model.vo;

import java.sql.Date;

public class ChattingRoom {
	private int rno;
	private Date pDate;
	private String category;
	private String pTime;
	private int mPerson;
	private int pPerson;
	private String location;
	private String dTime;
	private String status;
	private Date cDate;
	private String pKind;
	private String rTitle;
	
	public ChattingRoom() {}

	public ChattingRoom(int rno, Date pDate, String category, String pTime, int mPerson, int pPerson, String location,
			String dTime, String status, Date cDate, String pKind, String rTitle) {
		super();
		this.rno = rno;
		this.pDate = pDate;
		this.category = category;
		this.pTime = pTime;
		this.mPerson = mPerson;
		this.pPerson = pPerson;
		this.location = location;
		this.dTime = dTime;
		this.status = status;
		this.cDate = cDate;
		this.pKind = pKind;
		this.rTitle = rTitle;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public int getmPerson() {
		return mPerson;
	}

	public void setmPerson(int mPerson) {
		this.mPerson = mPerson;
	}

	public int getpPerson() {
		return pPerson;
	}

	public void setpPerson(int pPerson) {
		this.pPerson = pPerson;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getdTime() {
		return dTime;
	}

	public void setdTime(String dTime) {
		this.dTime = dTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getpKind() {
		return pKind;
	}

	public void setpKind(String pKind) {
		this.pKind = pKind;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	@Override
	public String toString() {
		return "ChattingRoom [rno=" + rno + ", pDate=" + pDate + ", category=" + category + ", pTime=" + pTime
				+ ", mPerson=" + mPerson + ", pPerson=" + pPerson + ", location=" + location + ", dTime=" + dTime
				+ ", status=" + status + ", cDate=" + cDate + ", pKind=" + pKind + ", rTitle=" + rTitle + "]";
	}
	
	
	
}
