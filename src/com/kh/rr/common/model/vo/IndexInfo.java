package com.kh.rr.common.model.vo;

public class IndexInfo implements java.io.Serializable {
	private String sInfo;		//SINFO (사이트 소개)
	private String sService;	//SSERVICE (서비스 소개)
	private String terms;		//TERMS	(소비자 약관)
	private String contact;		//CONTACT (연락처)
	
	public IndexInfo() {}

	public IndexInfo(String sInfo, String sService, String terms, String contact) {
		super();
		this.sInfo = sInfo;
		this.sService = sService;
		this.terms = terms;
		this.contact = contact;
	}

	public String getsInfo() {
		return sInfo;
	}

	public void setsInfo(String sInfo) {
		this.sInfo = sInfo;
	}

	public String getsService() {
		return sService;
	}

	public void setsService(String sService) {
		this.sService = sService;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "IndexInfo [sInfo=" + sInfo + ", sService=" + sService + ", terms=" + terms + "]";
	}
	

}
