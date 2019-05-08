package com.kh.rr.member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable {

	private String userId;
	private String userPwd;
	private String userName;
	private String memberKind;
	private String status;
	
	public Member() {}

	public Member(String userId, String userPwd, String userName, String memberKind, String status) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.memberKind = memberKind;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", memberKind="
				+ memberKind + ", status=" + status + "]";
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

	public String getMemberKind() {
		return memberKind;
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

	public void setMemberKind(String memberKind) {
		this.memberKind = memberKind;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
	
	
	

}
