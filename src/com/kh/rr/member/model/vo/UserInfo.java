package com.kh.rr.member.model.vo;

import java.sql.Date;

public class UserInfo implements java.io.Serializable {
	private String gender;
	private Date birthday;
	private int age;
	private String job;
	private String nickName;
	private String msg;
	private String grade;
	private String userId;
	private String account;
	private String bCode;
	private String holder;
	private int phone;
	private int fid;

	public UserInfo() {
	}

	public UserInfo(String gender, Date birthday, int age, String job, String nickName, String msg, String grade,
			String userId, String account, String bCode, String holder, int phone, int fid) {
		super();
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.job = job;
		this.nickName = nickName;
		this.msg = msg;
		this.grade = grade;
		this.userId = userId;
		this.account = account;
		this.bCode = bCode;
		this.holder = holder;
		this.phone = phone;
		this.fid = fid;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	@Override
	public String toString() {
		return "UserInfo [gender=" + gender + ", birthday=" + birthday + ", age=" + age + ", job=" + job + ", nickName="
				+ nickName + ", msg=" + msg + ", grade=" + grade + ", userId=" + userId + ", account=" + account
				+ ", bCode=" + bCode + ", holder=" + holder + ", phone=" + phone + ", fid=" + fid + "]";
	}

	

}
