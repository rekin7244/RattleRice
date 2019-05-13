package com.kh.rr.member.model.vo;

import java.sql.Date;

public class StoreInfo {
	//store
	private String cotact; //연락처
	private String location; //위치
	private String opening_hore; //영업시작 시간
	private String intro; //간단한 소개
	private String brand; //상호명
	private String bId;	//사업자ID
	private int sId;	//매장정보 코드
	private String status;
	private int sCode; //매장코드
	private String close_hore; //영업 종료 시간
	
	
	public StoreInfo() {}


	public StoreInfo(String cotact, String location, String opening_hore, String intro, String brand, String bId,
			int sId, String status, int sCode, String close_hore) {
		super();
		this.cotact = cotact;
		this.location = location;
		this.opening_hore = opening_hore;
		this.intro = intro;
		this.brand = brand;
		this.bId = bId;
		this.sId = sId;
		this.status = status;
		this.sCode = sCode;
		this.close_hore = close_hore;
	}


	public String getCotact() {
		return cotact;
	}


	public void setCotact(String cotact) {
		this.cotact = cotact;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getOpening_hore() {
		return opening_hore;
	}


	public void setOpening_hore(String opening_hore) {
		this.opening_hore = opening_hore;
	}


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getbId() {
		return bId;
	}


	public void setbId(String bId) {
		this.bId = bId;
	}


	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getsCode() {
		return sCode;
	}


	public void setsCode(int sCode) {
		this.sCode = sCode;
	}


	public String getClose_hore() {
		return close_hore;
	}


	public void setClose_hore(String close_hore) {
		this.close_hore = close_hore;
	}


	@Override
	public String toString() {
		return "StoreInfo [cotact=" + cotact + ", location=" + location + ", opening_hore=" + opening_hore + ", intro="
				+ intro + ", brand=" + brand + ", bId=" + bId + ", sId=" + sId + ", status=" + status + ", sCode="
				+ sCode + ", close_hore=" + close_hore + "]";
	}


		
}
