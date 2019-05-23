package com.kh.rr.admin.model.vo;

import java.sql.Date;

public class Settlement implements java.io.Serializable {
	private int rid;		//RID
	private int tid;		//TID
	private Date tDate;		//TDATE
	private Date rDate;		//RDATE
	private int rPrice;		//RPRICE
	private int rFees;		//RFEES
	private String mId;		//TRANSACTION테이블과 조인후 M_ID
	private String aId;		//A_ID
	private String status;	//STATUS
	
	public Settlement() {}

	public Settlement(int rid, int tid, Date tDate, Date rDate, int rPrice, int rFees, String mId, String aId,
			String status) {
		super();
		this.rid = rid;
		this.tid = tid;
		this.tDate = tDate;
		this.rDate = rDate;
		this.rPrice = rPrice;
		this.rFees = rFees;
		this.mId = mId;
		this.aId = aId;
		this.status = status;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getrPrice() {
		return rPrice;
	}

	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}

	public int getrFees() {
		return rFees;
	}

	public void setrFees(int rFees) {
		this.rFees = rFees;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Settlement [rid=" + rid + ", tid=" + tid + ", tDate=" + tDate + ", rDate=" + rDate + ", rPrice="
				+ rPrice + ", rFees=" + rFees + ", mId=" + mId + ", aId=" + aId + ", status=" + status + "]";
	}

}
