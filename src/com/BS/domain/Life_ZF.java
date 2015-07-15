package com.BS.domain;

public class Life_ZF {
	int houId;
	String houAdd;
	int houSize;
	String furExp;
	int fee;
	String hostName;
	String contact;
	String beginDate;
	boolean isRent;
	
	public Life_ZF(){
		
	}
	
	public Life_ZF(String houAdd, int houSize, String furExp, int fee,
			String hostName, String contact, String beginDate, boolean isRent) {
		this.houAdd = houAdd;
		this.houSize = houSize;
		this.furExp = furExp;
		this.fee = fee;
		this.hostName = hostName;
		this.contact = contact;
		this.beginDate = beginDate;
		this.isRent = isRent;
	}
	public int getHouId() {
		return houId;
	}
	public void setHouId(int houId) {
		this.houId = houId;
	}
	public String getHouAdd() {
		return houAdd;
	}
	public void setHouAdd(String houAdd) {
		this.houAdd = houAdd;
	}
	public int getHouSize() {
		return houSize;
	}
	public void setHouSize(int houSize) {
		this.houSize = houSize;
	}
	public String getFurExp() {
		return furExp;
	}
	public void setFurExp(String furExp) {
		this.furExp = furExp;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public boolean getIsRent() {
		return isRent;
	}
	public void setIsRent(boolean isRent) {
		this.isRent = isRent;
	}
	
}
