package com.kh.rr.admin.model.vo;

import java.sql.Date;

public class SMS implements java.io.Serializable{
	
	final String URL = "https://api.coolsms.co.kr";
	private String sms_url = URL + "/sms/1.5";
	private String senderid_url = URL + "/senderid/1.1/";
	private String api_key;
	private String api_secret;
	private String timestamp;
	
	//sms table
	private int smsId;
	private Date smsDate;
	private String content;
	private String aid;			//관리자아이디
	private String mid;			//사용자아이디
	
	public SMS() {}

	public SMS(String sms_url, String senderid_url, String api_key, String api_secret, String timestamp, int smsId,
			Date smsDate, String content, String aid, String mid) {
		super();
		this.sms_url = sms_url;
		this.senderid_url = senderid_url;
		this.api_key = api_key;
		this.api_secret = api_secret;
		this.timestamp = timestamp;
		this.smsId = smsId;
		this.smsDate = smsDate;
		this.content = content;
		this.aid = aid;
		this.mid = mid;
	}

	public String getSms_url() {
		return sms_url;
	}

	public void setSms_url(String sms_url) {
		this.sms_url = sms_url;
	}

	public String getSenderid_url() {
		return senderid_url;
	}

	public void setSenderid_url(String senderid_url) {
		this.senderid_url = senderid_url;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getApi_secret() {
		return api_secret;
	}

	public void setApi_secret(String api_secret) {
		this.api_secret = api_secret;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getSmsId() {
		return smsId;
	}

	public void setSmsId(int smsId) {
		this.smsId = smsId;
	}

	public Date getSmsDate() {
		return smsDate;
	}

	public void setSmsDate(Date smsDate) {
		this.smsDate = smsDate;
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

	public String getURL() {
		return URL;
	}

	@Override
	public String toString() {
		return "SMS [URL=" + URL + ", sms_url=" + sms_url + ", senderid_url=" + senderid_url + ", api_key=" + api_key
				+ ", api_secret=" + api_secret + ", timestamp=" + timestamp + ", smsId=" + smsId + ", smsDate="
				+ smsDate + ", content=" + content + ", aid=" + aid + ", mid=" + mid + "]";
	}
	
	
	
	

	
}
