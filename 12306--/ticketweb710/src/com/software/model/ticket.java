package com.software.model;

/*
 *实体层--车票类 
 */
public class ticket {
	private int ticketID;
	private int managerID;
	private String trainnumber;
	private String startstation;
	private String endstation;
	private String starttime;
	private String endtime;
	private String duration;
	private int softsleepernumber;
	private double softsleeperprice;
	private int hardsleepernumber;
	private double hardsleeperprice;
	private int hardseatnumber;
	private double hardseatprice;
	private int noseatnumber;
	private double noseatprice;
	
	
	@Override
	public String toString() {
		return "ticket [ticketID=" + ticketID + ", managerID=" + managerID + ", trainnumber=" + trainnumber
				+ ", startstation=" + startstation + ", endstation=" + endstation + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", duration=" + duration + ", softsleepernumber=" + softsleepernumber
				+ ", softsleeperprice=" + softsleeperprice + ", hardsleepernumber=" + hardsleepernumber
				+ ", hardsleeperprice=" + hardsleeperprice + ", hardseatnumber=" + hardseatnumber + ", hardseatprice="
				+ hardseatprice + ", noseatnumber=" + noseatnumber + ", noseatprice=" + noseatprice + "]";
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}
	public String getStartstation() {
		return startstation;
	}
	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}
	public String getEndstation() {
		return endstation;
	}
	public void setEndstation(String endstation) {
		this.endstation = endstation;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getSoftsleepernumber() {
		return softsleepernumber;
	}
	public void setSoftsleepernumber(int softsleepernumber) {
		this.softsleepernumber = softsleepernumber;
	}
	public double getSoftsleeperprice() {
		return softsleeperprice;
	}
	public void setSoftsleeperprice(double softsleeperprice) {
		this.softsleeperprice = softsleeperprice;
	}
	public int getHardsleepernumber() {
		return hardsleepernumber;
	}
	public void setHardsleepernumber(int hardsleepernumber) {
		this.hardsleepernumber = hardsleepernumber;
	}
	public double getHardsleeperprice() {
		return hardsleeperprice;
	}
	public void setHardsleeperprice(double hardsleeperprice) {
		this.hardsleeperprice = hardsleeperprice;
	}
	public int getHardseatnumber() {
		return hardseatnumber;
	}
	public void setHardseatnumber(int hardseatnumber) {
		this.hardseatnumber = hardseatnumber;
	}
	public double getHardseatprice() {
		return hardseatprice;
	}
	public void setHardseatprice(double hardseatprice) {
		this.hardseatprice = hardseatprice;
	}
	public int getNoseatnumber() {
		return noseatnumber;
	}
	public void setNoseatnumber(int noseatnumber) {
		this.noseatnumber = noseatnumber;
	}
	public double getNoseatprice() {
		return noseatprice;
	}
	public void setNoseatprice(double noseatprice) {
		this.noseatprice = noseatprice;
	}
	
	
	
	
	

	
	
}


