package com.BS.domain;

public class Life_JD {
	int eleId;
	String eleName;
	String eleKind;
	String eleExp;
	float elePrice;
	String contact;
	public Life_JD(){
		
	}
	public Life_JD(String eleName, String eleKind, String eleExp,
			float elePrice, String contact) {
		super();
		this.eleName = eleName;
		this.eleKind = eleKind;
		this.eleExp = eleExp;
		this.elePrice = elePrice;
		this.contact = contact;
	}
	public int getEleId() {
		return eleId;
	}
	public void setEleId(int eleId) {
		this.eleId = eleId;
	}
	public String getEleName() {
		return eleName;
	}
	public void setEleName(String eleName) {
		this.eleName = eleName;
	}
	public String getEleKind() {
		return eleKind;
	}
	public void setEleKind(String eleKind) {
		this.eleKind = eleKind;
	}
	public String getEleExp() {
		return eleExp;
	}
	public void setEleExp(String eleExp) {
		this.eleExp = eleExp;
	}
	public float getElePrice() {
		return elePrice;
	}
	public void setElePrice(float elePrice) {
		this.elePrice = elePrice;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
