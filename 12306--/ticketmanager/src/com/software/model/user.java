package com.software.model;

/*
 *实体层--用户类 
 */
public class user {
	private int userID;
	private String loginname;
	private String loginpwd;
	private String realname;
	private String gender;
	private String telnumber;
	private String cardtype;
	private String cardno;
	private int usertype;

	@Override
	public String toString() {
		return "user [userID=" + userID + ", loginname=" + loginname + ", loginpwd=" + loginpwd + ", realname="
				+ realname + ", gender=" + gender + ", telnumber=" + telnumber + ", cardtype=" + cardtype + ", cardno="
				+ cardno + ", usertype=" + usertype + "]";
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelnumber() {
		return telnumber;
	}
	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
}

