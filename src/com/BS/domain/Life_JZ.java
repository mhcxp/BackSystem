package com.BS.domain;

public class Life_JZ {
	int serId;
	String serName;
	String serKind;
	String serExp;
	float serPrice;
	String contact;
	
	public Life_JZ(){
		
	}
	public Life_JZ(String serName, String serKind, String serExp,
			float serPrice, String contact) {
		this.serName = serName;
		this.serKind = serKind;
		this.serExp = serExp;
		this.serPrice = serPrice;
		this.contact = contact;
	}
	public int getSerId() {
		return serId;
	}
	public void setSerId(int serId) {
		this.serId = serId;
	}
	public String getSerName() {
		return serName;
	}
	public void setSerName(String serName) {
		this.serName = serName;
	}
	public String getSerKind() {
		return serKind;
	}
	public void setSerKind(String serKind) {
		this.serKind = serKind;
	}
	public String getSerExp() {
		return serExp;
	}
	public void setSerExp(String serExp) {
		this.serExp = serExp;
	}
	public float getSerPrice() {
		return serPrice;
	}
	public void setSerPrice(float serPrice) {
		this.serPrice = serPrice;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
