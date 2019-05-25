package com.kh.rr.admin.model.vo;

import java.sql.Date;

public class SMS implements java.io.Serializable{

	private int sms_id;
	private Date date;
	private String content;
	private String aid;
	private String mid;
	private String phone;
	
	
	public SMS() {}


	public SMS(int sms_id, Date date, String content, String aid, String mid, String phone) {
		super();
		this.sms_id = sms_id;
		this.date = date;
		this.content = content;
		this.aid = aid;
		this.mid = mid;
		this.phone = phone;
	}


	public int getSms_id() {
		return sms_id;
	}


	public void setSms_id(int sms_id) {
		this.sms_id = sms_id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "SMS [sms_id=" + sms_id + ", date=" + date + ", content=" + content + ", aid=" + aid + ", mid=" + mid
				+ ", phone=" + phone + "]";
	}


	



	
	
}
