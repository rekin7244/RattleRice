package com.kh.rr.member.model.vo;

public class Reservation implements java.io.Serializable{
	private String mid; //사용자 아이디
	private int price;	//가격
	private String sId; //매장정보코드
	private String sCode; //매장코드
	private String rTime; //예약시감
	private String status;	//status
	private String mType;	//회원구분
	private int mCount; //예약자 수
	private String userName;
	
	public Reservation() {}

	public Reservation(String mid, int price, String sId, String sCode, String rTime, String status, String mType,
			int mCount, String userName) {
		super();
		this.mid = mid;
		this.price = price;
		this.sId = sId;
		this.sCode = sCode;
		this.rTime = rTime;
		this.status = status;
		this.mType = mType;
		this.mCount = mCount;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Reservation [mid=" + mid + ", price=" + price + ", sId=" + sId + ", sCode=" + sCode + ", rTime=" + rTime
				+ ", status=" + status + ", mType=" + mType + ", mCount=" + mCount + ", userName=" + userName + "]";
	}

	public String getMid() {
		return mid;
	}

	public int getPrice() {
		return price;
	}

	public String getsId() {
		return sId;
	}

	public String getsCode() {
		return sCode;
	}

	public String getrTime() {
		return rTime;
	}

	public String getStatus() {
		return status;
	}

	public String getmType() {
		return mType;
	}

	public int getmCount() {
		return mCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public void setrTime(String rTime) {
		this.rTime = rTime;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
