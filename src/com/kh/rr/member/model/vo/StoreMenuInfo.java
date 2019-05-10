package com.kh.rr.member.model.vo;

public class StoreMenuInfo {
	//menu
	private String menu; //메뉴명
	private int price; //메뉴가격
	private String origin; //원산지
	private String mId; //메뉴코드
	private String fId; //이미지 키
	
	public StoreMenuInfo() {}

	public StoreMenuInfo(String menu, int price, String origin, String mId, String fId) {
		super();
		this.menu = menu;
		this.price = price;
		this.origin = origin;
		this.mId = mId;
		this.fId = fId;
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

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	@Override
	public String toString() {
		return "StoreMenuInfo [menu=" + menu + ", price=" + price + ", origin=" + origin + ", mId=" + mId + ", fId="
				+ fId + "]";
	}

	
}
