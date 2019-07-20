package com.software.model;

public class feedback {
	
	private int informationID;         
	private int userID;        
	private int managerID;      
	private String information;  
	private String operation;      
	private String operationresult;
	
	@Override
	public String toString() {
		return "feedback [informationID=" + informationID + ", userID=" + userID + ", managerID=" + managerID
				+ ", information=" + information + ", operation=" + operation + ", operationresult=" + operationresult
				+ "]";
	}
	public int getInformationID() {
		return informationID;
	}
	public void setInformationID(int informationID) {
		this.informationID = informationID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperationresult() {
		return operationresult;
	}
	public void setOperationresult(String operationresult) {
		this.operationresult = operationresult;
	}    
	
}
