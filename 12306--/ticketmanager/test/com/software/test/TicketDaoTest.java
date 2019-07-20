package com.software.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;


import com.software.dao.ticketDao;
import com.software.model.ticket;


public class TicketDaoTest {
	
	ticketDao ticketDao = new ticketDao();
	/*
	 * ���ӵ�Ԫ������
	 * @author ����
	 *
	 */
	@Test
	public void testMethod1() {
		//1.����User����Ĳ�������
		ticket ticket = new ticket();
		ticket.setTrainnumber("T88");
		ticket.setStartstation("����");
		ticket.setEndstation("�Ϻ�");
		ticket.setStarttime("7:00");
		ticket.setEndtime("17:00");
		ticket.setDuration("10");
		ticket.setSoftsleepernumber(60);
		ticket.setSoftsleeperprice(80);
		ticket.setHardsleepernumber(50);
		ticket.setHardsleeperprice(60.5);
		ticket.setHardseatnumber(100);
		ticket.setHardseatprice(50);
		ticket.setNoseatnumber(120);
		ticket.setNoseatprice(40);
		
		//2.�������ݿ���ʲ��е���ӷ���
		
		boolean flag = ticketDao.addticket(ticket);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	/*
 * ��Ԫ������
 * @author ����
 *
 */
	/*
	 * @Test
	public void testMethod2() throws Exception  {
		boolean flag =ticketDao.updateticket();
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	*/
	/*
 * ��Ԫ������
 * @author ����
 *
 */
	@Test
	public void testMethod3() throws Exception  {
		boolean flag =ticketDao.delticket(7);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	/**
	 * ����ticketIDɾ����Ʊ��Ϣ
	 * @author ��Բ��
	 */
	@Test
	public void testMethod9()   {
		boolean flag =ticketDao.deletticketByID(5);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
		
	/**
	 * �����ѯ���г�Ʊ��Ϣ��һ��
	 * @author ��Բ��
	 */
	@Test
	public void testMethod12() {
		List<ticket> tickets =ticketDao.findAllticket1();
		for(int i=0;i<tickets.size();i++) {
			ticket ticket = tickets.get(i);
			System.out.println(ticket.toString());
		}
	}
	
	/*
 * ��Ԫ������
 * @author ����
 *
 */
	@Test
	public void testMethod4() throws Exception  {
		ticketDao.findAllticket();
	}
	
	@Test
	public void testMethod5() throws Exception  {
		List<List> tickets = ticketDao.findAll();
		for(int i=0;i<tickets.size();i++) {
			List data = tickets.get(i);
			System.out.println(data.toString());
		}
	}
	/*
 * ��Ԫ������
 * @author ����
 *
 */	
	@Test
	public void testMethod6() {
		List<ticket> tickets =ticketDao.findAll1("T44","����","����");
		for(int i=0;i<tickets.size();i++) {
			ticket ticket = tickets.get(i);
			System.out.println(ticket.toString());
		}
	}
	/*
 * ��Ԫ������
 * @author ����
 *
 */
	@Test
	public void testMethod7() {
		List<ticket> tickets =ticketDao.findAll2(1,3);
		for(int i=0;i<tickets.size();i++) {
			ticket ticket = tickets.get(i);
			System.out.println(ticket.toString());
		}
	}
	/*
 * ��Ԫ������
 * @author ����
 *
 */
	@Test
	public void testMethod8() {
		List<ticket> tickets =ticketDao.findAll3("����","����","2��00","14��00",1,3);
		for(int i=0;i<tickets.size();i++) {
			ticket ticket = tickets.get(i);
			System.out.println(ticket.toString());
		}
	}
	
	
}
