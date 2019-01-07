package com.insurancequote.bean;

public class AccountBean {
private String insuredName;
private String insuredStreet;
private String insuredCity;
private String insuredState;
private Long insuredZip;
private String businessSegment;
private Long accountNumber;
private String agentName;
private String userName;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getAgentName() {
	return agentName;
}
public void setAgentName(String agentName) {
	this.agentName = agentName;
}
public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getInsuredName() {
	return insuredName;
}
public void setInsuredName(String insuredName) {
	this.insuredName = insuredName;
}
public String getInsuredStreet() {
	return insuredStreet;
}
public void setInsuredStreet(String insuredStreet) {
	this.insuredStreet = insuredStreet;
}
public String getInsuredCity() {
	return insuredCity;
}
public void setInsuredCity(String insuredCity) {
	this.insuredCity = insuredCity;
}
public String getInsuredState() {
	return insuredState;
}
public void setInsuredState(String insuredState) {
	this.insuredState = insuredState;
}
public Long getInsuredZip() {
	return insuredZip;
}
public void setInsuredZip(Long insuredZip) {
	this.insuredZip = insuredZip;
}
public String getBusinessSegment() {
	return businessSegment;
}
public void setBusinessSegment(String businessSegment) {
	this.businessSegment = businessSegment;
}
@Override
public String toString() {
	return "InsuredBean [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
			+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", businessSegment="
			+ businessSegment + "]";
}


}
