package com.kh.rr.common.model.vo;

import java.sql.Date;

public class Reservation implements java.io.Serializable{
	private String mId;		//M_ID
	private String brand;	//STORE와 조인후 BRAND
	private String menus;	//STORE와 MENU와 조인후 MENU
	private int price;		//PRICE
	private Date rTime;		//R_TIME
	private String M_TYPE;	//M_TYPE
	private String status;	//STATUS
	
	public Reservation() {}

	public Reservation(String mId, String brand, String menus, int price, Date rTime, String m_TYPE, String status) {
		super();
		this.mId = mId;
		this.brand = brand;
		this.menus = menus;
		this.price = price;
		this.rTime = rTime;
		M_TYPE = m_TYPE;
		this.status = status;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getrTime() {
		return rTime;
	}

	public void setrTime(Date rTime) {
		this.rTime = rTime;
	}

	public String getM_TYPE() {
		return M_TYPE;
	}

	public void setM_TYPE(String m_TYPE) {
		M_TYPE = m_TYPE;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation [mId=" + mId + ", brand=" + brand + ", menus=" + menus + ", price=" + price + ", rTime="
				+ rTime + ", M_TYPE=" + M_TYPE + ", status=" + status + "]";
	}
	
	
}
