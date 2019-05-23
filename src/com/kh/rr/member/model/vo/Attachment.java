package com.kh.rr.member.model.vo;

import java.sql.Date;

public class Attachment implements java.io.Serializable {
	private int fid;
	private String filePath;
	private String originName;
	private String changeName;
	private Date uploadDate;
	private String status;
	private String type;
	private String userId;

	public Attachment() {
	}

	public Attachment(int fid, String filePath, String originName, String changeName, Date uploadDate, String status,
			String type, String userId) {
		super();
		this.fid = fid;
		this.filePath = filePath;
		this.originName = originName;
		this.changeName = changeName;
		this.uploadDate = uploadDate;
		this.status = status;
		this.type = type;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", filePath=" + filePath + ", originName=" + originName + ", changeName="
				+ changeName + ", uploadDate=" + uploadDate + ", status=" + status + ", type=" + type + ", userId="
				+ userId + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFid() {
		return fid;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getOriginName() {
		return originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public String getUserId() {
		return userId;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}