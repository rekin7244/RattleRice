package com.kh.rr.member.model.vo;

public class StoreMenuInfo {
	//menu
	private String menu; //메뉴명
	private int price; //메뉴가격
	private String origin; //원산지
	private int sId;//매장정보 코드
	private int mId; //메뉴코드
	private int sCode; //매장코드
	
	public StoreMenuInfo() {}

	public StoreMenuInfo(String menu, int price, String origin, int sId, int mId, int sCode) {
		super();
		this.menu = menu;
		this.price = price;
		this.origin = origin;
		this.sId = sId;
		this.mId = mId;
		this.sCode = sCode;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
	}

	@Override
	public String toString() {
		return "StoreMenuInfo [menu=" + menu + ", price=" + price + ", origin=" + origin + ", sId=" + sId + ", mId="
				+ mId + ", sCode=" + sCode + "]";
	}

			
}
