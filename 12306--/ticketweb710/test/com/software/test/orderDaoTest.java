package com.software.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.software.dao.orderDao;

public class orderDaoTest {
	
	@Test
	public void testMethod() throws Exception  {
		orderDao orderDao = new orderDao();
		List data = new ArrayList();
		data =orderDao.findStation(1);
		
		System.out.println(data);	
	}
	
	@Test
	public void testMethod1() throws Exception  {
		orderDao orderDao = new orderDao();
		
		orderDao.gaiqian(4, 2, "»ÌŒ‘");
	}
	
}
