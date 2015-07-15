package com.BS.domain;

public class Finance_BX {
	int bxId;
	String comName;
	float bxRate;
	String bxExp;
	int buyTimes;
	int price;
	
	public Finance_BX(){
		
	}
	public Finance_BX(String bxExp,String comName, float bxRate,
			int buyTimes, int price) {
		this.comName = comName;
		this.bxRate = bxRate;
		this.bxExp = bxExp;
		this.buyTimes = buyTimes;
		this.price = price;
	}
	public int getBxId() {
		return bxId;
	}
	public void setBxId(int bxId) {
		this.bxId = bxId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public float getBxRate() {
		return bxRate;
	}
	public void setBxRate(float bxRate) {
		this.bxRate = bxRate;
	}
	public String getBxExp() {
		return bxExp;
	}
	public void setBxExp(String bxExp) {
		this.bxExp = bxExp;
	}
	public int getBuyTimes() {
		return buyTimes;
	}
	public void setBuyTimes(int buyTimes) {
		this.buyTimes = buyTimes;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
