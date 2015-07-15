package com.BS.domain;

public class Order {
	int ordId;
	int ordMenId;
	String ordName;
	String ordInf;
	float ordPrice;
	int ordState;
	int ordKind;
	int serId;
	
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public int getOrdMenId() {
		return ordMenId;
	}
	public void setOrdMenId(int ordMenId) {
		this.ordMenId = ordMenId;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	public String getOrdInf() {
		return ordInf;
	}
	public void setOrdInf(String ordInf) {
		this.ordInf = ordInf;
	}
	public float getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(float ordPrice) {
		this.ordPrice = ordPrice;
	}
	public int getOrdState() {
		return ordState;
	}
	public void setOrdState(int ordState) {
		this.ordState = ordState;
	}
	public int getOrdKind() {
		return ordKind;
	}
	public void setOrdKind(int ordKind) {
		this.ordKind = ordKind;
	}
	public int getSerId() {
		return serId;
	}
	public void setSerId(int serId) {
		this.serId = serId;
	}

}
