package com.BS.domain;

public class Life_SC {
	int vegId;
	String vegName;
	String vegKind;
	String vegExp;
	String vegAdd;
	float vegPrice;
	String dispactTime1;
	String dispactTime2;
	String contact;
	
	public Life_SC(){
		
	}
	public Life_SC(String vegName, String vegKind, String vegExp,
			String vegAdd, float vegPrice, String dispactTime1,
			String dispactTime2, String contact) {
		super();
		this.vegName = vegName;
		this.vegKind = vegKind;
		this.vegExp = vegExp;
		this.vegAdd = vegAdd;
		this.vegPrice = vegPrice;
		this.dispactTime1 = dispactTime1;
		this.dispactTime2 = dispactTime2;
		this.contact = contact;
	}
	public int getVegId() {
		return vegId;
	}
	public void setVegId(int vegId) {
		this.vegId = vegId;
	}
	public String getVegName() {
		return vegName;
	}
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	public String getVegKind() {
		return vegKind;
	}
	public void setVegKind(String vegKind) {
		this.vegKind = vegKind;
	}
	public String getVegExp() {
		return vegExp;
	}
	public void setVegExp(String vegExp) {
		this.vegExp = vegExp;
	}
	public String getVegAdd() {
		return vegAdd;
	}
	public void setVegAdd(String vegAdd) {
		this.vegAdd = vegAdd;
	}
	public float getVegPrice() {
		return vegPrice;
	}
	public void setVegPrice(float vegPrice) {
		this.vegPrice = vegPrice;
	}
	public String getDispactTime1() {
		return dispactTime1;
	}
	public void setDispactTime1(String dispactTime1) {
		this.dispactTime1 = dispactTime1;
	}
	public String getDispactTime2() {
		return dispactTime2;
	}
	public void setDispactTime2(String dispactTime2) {
		this.dispactTime2 = dispactTime2;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
