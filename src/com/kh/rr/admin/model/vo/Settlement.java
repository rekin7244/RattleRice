package com.kh.rr.admin.model.vo;

import java.sql.Date;

public class Settlement implements java.io.Serializable {
	private int tid;	//TID
	private Date tDate;	//TDATE
	private int tPrice;	//TPRICE
	private String mId;	//M_ID
	
	public Settlement() {}

	public Settlement(int tid, Date tDate, int tPrice, String mId) {
		super();
		this.tid = tid;
		this.tDate = tDate;
		this.tPrice = tPrice;
		this.mId = mId;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public int gettPrice() {
		return tPrice;
	}

	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "Settlement [tid=" + tid + ", tDate=" + tDate + ", tPrice=" + tPrice + ", mId=" + mId + "]";
	}
	
}
