package com.kh.rr.refund.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Refund implements Serializable{

	private int rId;
	private Date rDate;
	private int rPrice;
	private int rFees;
	private String aId;
	private int tId;
	
	public Refund() {}

	public Refund(int rId, Date rDate, int rPrice, int rFees, String aId, int tId) {
		super();
		this.rId = rId;
		this.rDate = rDate;
		this.rPrice = rPrice;
		this.rFees = rFees;
		this.aId = aId;
		this.tId = tId;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
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

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	@Override
	public String toString() {
		return "Refund [rId=" + rId + ", rDate=" + rDate + ", rPrice=" + rPrice + ", rFees=" + rFees + ", aId=" + aId
				+ ", tId=" + tId + "]";
	}
	
	
	
}
