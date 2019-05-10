package com.kh.rr.member.model.vo;

import java.sql.Date;

//직렬화
public class Attachment/*첨부파일*/ implements java.io.Serializable{
	private int fid;
	private String filePath;
	private String originName;
	private String changeName;
	private Date uploadDate;
	private String status;
	
	//기본생성자
	public Attachment() {}

	public Attachment(int fid, String filePath, String originName, String changeName, Date uploadDate, String status) {
		super();
		this.fid = fid;
		this.filePath = filePath;
		this.originName = originName;
		this.changeName = changeName;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", filePath=" + filePath + ", originName=" + originName + ", changeName="
				+ changeName + ", uploadDate=" + uploadDate + ", status=" + status + "]";
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


}