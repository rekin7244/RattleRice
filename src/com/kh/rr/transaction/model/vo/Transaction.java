package com.kh.rr.transaction.model.vo;

import java.sql.Date;

public class Transaction {
	private int tId;
	private Date tDate;
	private int tPrice;
	private String type;
	private String unit;
	private String userId;
	
	public Transaction() {}

	public Transaction(int tId, Date tDate, int tPrice, String type, String unit, String userId) {
		super();
		this.tId = tId;
		this.tDate = tDate;
		this.tPrice = tPrice;
		this.type = type;
		this.unit = unit;
		this.userId = userId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", tDate=" + tDate + ", tPrice=" + tPrice + ", type=" + type + ", unit="
				+ unit + ", userId=" + userId + "]";
	}

	
}
