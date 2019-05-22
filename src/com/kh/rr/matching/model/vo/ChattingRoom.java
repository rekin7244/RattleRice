package com.kh.rr.matching.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ChattingRoom implements Serializable{
	private int rno;			//시퀀스
	private String rTitle;		//방제목
	private Date pDate;			//약속날짜
	private String category;	//음식종류
	private String pTime;		//약속시간
	private int mPerson;		//최대인원
	private int pPerson;		//현재인원
	private String location;	//약속장소
	private String brand;		//상호명
	private String dTime;		//마감시간
	private String status;		//상태
	private Date cDate;			//생성날짜
	private String rKind;		//일반or프리미엄
	private int sCode;			//매장정보 코드
	private int sId;			//매장코드
	
	//여기서부터는 프리미엄 방 생성시만 붙는 조건
	private String sRatio; 		//성비
	private String job; 		//직업
	private int age; 			//나이제한
	
	public ChattingRoom() {}

	public ChattingRoom(int rno, String rTitle, Date pDate, String category, String pTime, int mPerson, int pPerson,
			String location, String brand, String dTime, String status, Date cDate, String rKind, int sCode, int sId,
			String sRatio, String job, int age) {
		super();
		this.rno = rno;
		this.rTitle = rTitle;
		this.pDate = pDate;
		this.category = category;
		this.pTime = pTime;
		this.mPerson = mPerson;
		this.pPerson = pPerson;
		this.location = location;
		this.brand = brand;
		this.dTime = dTime;
		this.status = status;
		this.cDate = cDate;
		this.rKind = rKind;
		this.sCode = sCode;
		this.sId = sId;
		this.sRatio = sRatio;
		this.job = job;
		this.age = age;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public int getmPerson() {
		return mPerson;
	}

	public void setmPerson(int mPerson) {
		this.mPerson = mPerson;
	}

	public int getpPerson() {
		return pPerson;
	}

	public void setpPerson(int pPerson) {
		this.pPerson = pPerson;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getdTime() {
		return dTime;
	}

	public void setdTime(String dTime) {
		this.dTime = dTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getrKind() {
		return rKind;
	}

	public void setrKind(String rKind) {
		this.rKind = rKind;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsRatio() {
		return sRatio;
	}

	public void setsRatio(String sRatio) {
		this.sRatio = sRatio;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ChattingRoom [rno=" + rno + ", rTitle=" + rTitle + ", pDate=" + pDate + ", category=" + category
				+ ", pTime=" + pTime + ", mPerson=" + mPerson + ", pPerson=" + pPerson + ", location=" + location
				+ ", brand=" + brand + ", dTime=" + dTime + ", status=" + status + ", cDate=" + cDate + ", rKind="
				+ rKind + ", sCode=" + sCode + ", sId=" + sId + ", sRatio=" + sRatio + ", job=" + job + ", age=" + age
				+ "]";
	}
	
	
}
