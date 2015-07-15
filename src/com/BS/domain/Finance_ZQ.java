package com.BS.domain;

public class Finance_ZQ {
	int zqId;
	String zqExp;
	String comName;
	float zqRate;
	int buyTimes;
	int price;
	
	public Finance_ZQ() {

	}
	public Finance_ZQ(String zqExp, String comName, float zqRate,
			int buyTimes, int price) {
		this.zqExp = zqExp;
		this.comName = comName;
		this.zqRate = zqRate;
		this.buyTimes = buyTimes;
		this.price = price;
	}
	public int getZqId() {
		return zqId;
	}
	public void setZqId(int zqId) {
		this.zqId = zqId;
	}
	public String getZqExp() {
		return zqExp;
	}
	public void setZqExp(String zqExp) {
		this.zqExp = zqExp;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public float getZqRate() {
		return zqRate;
	}
	public void setZqRate(float zqRate) {
		this.zqRate = zqRate;
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
