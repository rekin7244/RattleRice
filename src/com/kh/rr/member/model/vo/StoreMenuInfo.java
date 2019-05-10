package com.kh.rr.member.model.vo;

public class StoreMenuInfo {
	//menu
	private String menu; //메뉴명
	private int price; //메뉴가격
	private String origin; //원산지
	private String sId;//매장정보 코드
	private String mId; //메뉴코드
	private String sCode; //매장코드
	
	public StoreMenuInfo() {}

	public StoreMenuInfo(String menu, int price, String origin, String sId, String mId, String sCode) {
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

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	@Override
	public String toString() {
		return "StoreMenuInfo [menu=" + menu + ", price=" + price + ", origin=" + origin + ", sId=" + sId + ", mId="
				+ mId + ", sCode=" + sCode + "]";
	}

		
}
