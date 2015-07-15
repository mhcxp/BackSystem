package com.BS.domain;

public class Life_JJ {
	int teaId;
	String teaName;
	String teaExp;
	int feeStd;
	String time;
	String contact;
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaExp() {
		return teaExp;
	}
	public void setTeaExp(String teaExp) {
		this.teaExp = teaExp;
	}
	public int getFeeStd() {
		return feeStd;
	}
	public void setFeeStd(int feeStd) {
		this.feeStd = feeStd;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Life_JJ(String teaName, String teaExp, int feeStd, String time,
			String contact) {
		this.teaName = teaName;
		this.teaExp = teaExp;
		this.feeStd = feeStd;
		this.time = time;
		this.contact = contact;
	}
	
	public Life_JJ(){
		
	}
	
}
