package com.software.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.software.dao.orderDao;
import com.software.dao.userDao;

public class userDaoTest {
	@Test
	public void testMethod() throws Exception  {
		List<List> buffer = new ArrayList<List>();
		
		buffer = userDao.findAll1("def","111111");
		
		System.out.println(buffer.toString());	
	}
}
