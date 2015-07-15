package com.BS.domain;

public class Finance_JJ {
	int proId;
	String proName;
	String proExp;
	String proIns;
	String proEva;
	String proCode;
	float proRate;
	String beginDate;
	int buyTimes;
	int price;

	public Finance_JJ() {
	}

	public Finance_JJ(String proName, String proExp, String proIns,
			String proEva, String proCode, float proRate, String beginDate,
			int buyTimes, int price) {
		this.proName = proName;
		this.proExp = proExp;
		this.proIns = proIns;
		this.proEva = proEva;
		this.proCode = proCode;
		this.proRate = proRate;
		this.beginDate = beginDate;
		this.buyTimes = buyTimes;
		this.price = price;
	}
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProExp() {
		return proExp;
	}
	public void setProExp(String proExp) {
		this.proExp = proExp;
	}
	public String getProIns() {
		return proIns;
	}
	public void setProIns(String proIns) {
		this.proIns = proIns;
	}
	public String getProEva() {
		return proEva;
	}
	public void setProEva(String proEva) {
		this.proEva = proEva;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public float getProRate() {
		return proRate;
	}
	public void setProRate(float proRate) {
		this.proRate = proRate;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
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
