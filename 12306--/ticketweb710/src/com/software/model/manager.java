package com.software.model;


/*
 *实体层--管理员类 
 */
public class manager {
	private int managerID;
	private String loginname;
	private String loginpwd;
	
	@Override
	public String toString() {
		return "manager [managerID=" + managerID + ", loginname=" + loginname + ", loginpwd=" + loginpwd + "]";
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
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
	

	
	
	
}


