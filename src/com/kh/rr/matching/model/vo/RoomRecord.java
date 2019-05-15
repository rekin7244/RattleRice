package com.kh.rr.matching.model.vo;

import java.io.Serializable;

public class RoomRecord implements Serializable{
	private int rno;
	private String type;
	private String mId;
	
	public RoomRecord() {}

	public RoomRecord(int rno, String type, String mId) {
		super();
		this.rno = rno;
		this.type = type;
		this.mId = mId;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "RoomRecord [rno=" + rno + ", type=" + type + ", mId=" + mId + "]";
	}
	
	
}
