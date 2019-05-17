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
	private String phone;
	private String email;
	private int point;
	private int bell;

	public UserInfo() {
	}

	public UserInfo(String gender, Date birthday, int age, String job, String nickName, String msg, String grade,
			String userId, String account, String bCode, String holder, String phone, String email, int point,
			int bell) {
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
		this.email = email;
		this.point = point;
		this.bell = bell;
	}

	@Override
	public String toString() {
		return "UserInfo [gender=" + gender + ", birthday=" + birthday + ", age=" + age + ", job=" + job + ", nickName="
				+ nickName + ", msg=" + msg + ", grade=" + grade + ", userId=" + userId + ", account=" + account
				+ ", bCode=" + bCode + ", holder=" + holder + ", phone=" + phone + ", email=" + email + ", point="
				+ point + ", bell=" + bell + "]";
	}

	public String getGender() {
		return gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public int getAge() {
		return age;
	}

	public String getJob() {
		return job;
	}

	public String getNickName() {
		return nickName;
	}

	public String getMsg() {
		return msg;
	}

	public String getGrade() {
		return grade;
	}

	public String getUserId() {
		return userId;
	}

	public String getAccount() {
		return account;
	}

	public String getbCode() {
		return bCode;
	}

	public String getHolder() {
		return holder;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public int getPoint() {
		return point;
	}

	public int getBell() {
		return bell;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setBell(int bell) {
		this.bell = bell;
	}

	
}
