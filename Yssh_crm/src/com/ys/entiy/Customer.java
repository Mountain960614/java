package com.ys.entiy;

import java.util.HashSet;
import java.util.Set;

public class Customer {
   private Integer uid;
   private String  custName;
   private String  custLevel;
   private String  custSource;
   private String  custLinkman;
   private String  custPhone;
   private String  custMobile;
   private String  custAddress;
   private String  custZip;
   private String  custFax;
   private String  custWebsite;
   //表示所有的联系人
   private Set<LinkMan> setLinkMan=new HashSet<LinkMan>();
   //表示所有的拜访记录
   private Set<Visit> setVisit=new HashSet<Visit>();
public Set<Visit> getSetVisit() {
	return setVisit;
}
public void setSetVisit(Set<Visit> setVisit) {
	this.setVisit = setVisit;
}
public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getCustLevel() {
	return custLevel;
}
public void setCustLevel(String custLevel) {
	this.custLevel = custLevel;
}
public String getCustSource() {
	return custSource;
}
public void setCustSource(String custSource) {
	this.custSource = custSource;
}
public String getCustLinkman() {
	return custLinkman;
}
public void setCustLinkman(String custLinkman) {
	this.custLinkman = custLinkman;
}
public String getCustPhone() {
	return custPhone;
}
public void setCustPhone(String custPhone) {
	this.custPhone = custPhone;
}
public String getCustMobile() {
	return custMobile;
}
public void setCustMobile(String custMobile) {
	this.custMobile = custMobile;
}
public String getCustAddress() {
	return custAddress;
}
public void setCustAddress(String custAddress) {
	this.custAddress = custAddress;
}
public String getCustZip() {
	return custZip;
}
public void setCustZip(String custZip) {
	this.custZip = custZip;
}
public String getCustFax() {
	return custFax;
}
public void setCustFax(String custFax) {
	this.custFax = custFax;
}
public String getCustWebsite() {
	return custWebsite;
}
public void setCustWebsite(String custWebsite) {
	this.custWebsite = custWebsite;
}
   
}
