package com.software.model;

public class order {
	
	private int orderID;          //订单编号
	private int userID;        //用户编号
	private int ticketID;      //车票编号
	private String orderstate;    //订单状态
	private String seattype;      //座位类型
	private String ordertime;     //下单时间
	private String remark1;     //票价
	
	@Override
	public String toString() {
		return "order [orderID=" + orderID + ", userID=" + userID + ", ticketID=" + ticketID + ", orderstate="
				+ orderstate + ", seattype=" + seattype + ", ordertime=" + ordertime + ", remark1=" + remark1 + "]";
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getSeattype() {
		return seattype;
	}
	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
}
