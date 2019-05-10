package com.kh.rr.member.model.vo;

import java.sql.Date;

public class StoreInfo {
	//store
	private String sCode; //매장코드
	private String brand; //상호명
	private String cotact; //연락처
	private String location; //위치
	private String opening_hore; //영업시작 시간
	private String close_hore; //영업 종료 시간
	private String intro; //간단한 소개
	private Date uDate;//업데이트한 일시
	
	public StoreInfo() {}

	public StoreInfo(String sCode, String brand, String cotact, String location, String opening_hore, String close_hore,
			String intro, Date uDate) {
		super();
		this.sCode = sCode;
		this.brand = brand;
		this.cotact = cotact;
		this.location = location;
		this.opening_hore = opening_hore;
		this.close_hore = close_hore;
		this.intro = intro;
		this.uDate = uDate;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getClose_hore() {
		return close_hore;
	}

	public void setClose_hore(String close_hore) {
		this.close_hore = close_hore;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	@Override
	public String toString() {
		return "StoreInfo [sCode=" + sCode + ", brand=" + brand + ", cotact=" + cotact + ", location=" + location
				+ ", opening_hore=" + opening_hore + ", close_hore=" + close_hore + ", intro=" + intro + ", uDate="
				+ uDate + "]";
	}
	
	

}
