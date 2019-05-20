package com.kh.rr.member.model.vo;

import java.sql.Date;

public class BusinessMan implements java.io.Serializable{
	//사업자
	private String account; //계좌번호
	private String bankcode; //은행코드
	private String holder; //예금주
	private String bCode; //사업자 등록번호
	private String bId; //사업자 아이디
	private int revenue; // 수익
	
	public BusinessMan() {}

	public BusinessMan(String account, String bankcode, String holder, String bCode, String bId, int revenue) {
		super();
		this.account = account;
		this.bankcode = bankcode;
		this.holder = holder;
		this.bCode = bCode;
		this.bId = bId;
		this.revenue = revenue;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	@Override
	public String toString() {
		return "BusinessMan [account=" + account + ", bankcode=" + bankcode + ", holder=" + holder + ", bCode=" + bCode
				+ ", bId=" + bId + ", revenue=" + revenue + "]";
	}

		
	
}































