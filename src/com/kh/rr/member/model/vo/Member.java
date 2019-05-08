package com.kh.rr.member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable {

	private String userId;
	private String userPwd;
	private String userName;
	private String memberType;
	private String status;
	
	public Member() {}

	public Member(String userId, String userPwd, String userName, String memberType, String status) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.memberType = memberType;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", memberType="
				+ memberType + ", status=" + status + "]";
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public String getMemberType() {
		return memberType;
	}

	public String getStatus() {
		return status;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
	
	
	

}
