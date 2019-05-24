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
	
	public Reservation() {}

	public Reservation(String mid, int price, String sId, String sCode, String rTime, String status, String mType,
			int mCount) {
		super();
		this.mid = mid;
		this.price = price;
		this.sId = sId;
		this.sCode = sCode;
		this.rTime = rTime;
		this.status = status;
		this.mType = mType;
		this.mCount = mCount;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getrTime() {
		return rTime;
	}

	public void setrTime(String rTime) {
		this.rTime = rTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	@Override
	public String toString() {
		return "Reservation [mid=" + mid + ", price=" + price + ", sId=" + sId + ", sCode=" + sCode + ", rTime=" + rTime
				+ ", status=" + status + ", mType=" + mType + ", mCount=" + mCount + "]";
	}

		
	
}
