package com.software.model;

public class order {
	
	private int orderID;          //�������
	private int userID;        //�û����
	private int ticketID;      //��Ʊ���
	private String orderstate;    //����״̬
	private String seattype;      //��λ����
	private String ordertime;     //�µ�ʱ��
	
	@Override
	public String toString() {
		return "order [orderID=" + orderID + ", userID=" + userID + ", ticketID=" + ticketID + ", orderstate="
				+ orderstate + ", seattype=" + seattype + ", ordertime=" + ordertime + "]";
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
}

