package com.software.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import com.software.dao.orderDao;
import com.software.dao.userDao;
import com.software.model.user;

/**
 * 单元测试类
 * @author 张玲
 *
 */
public class UserDaoTest {

	/**
	 *  1.单元测试的方法名称通常是以test开头
	 *  2.单元测试的方法返回值通常是void类型
	 *   测试数据库访问层中的添加方法是否正确
	 */
	
	/*
	@Test
	public void testMethod1() {
		//1.创建User对象的测试用例
		user user = new user();
		user.setLoginname("zl");
		user.setLoginpwd("222");
		user.setRealname("gs");
		user.setGender("男");
		user.setTelnumber("11122223333");
		user.setCardtype("中国居民身份证");
		user.setCardno("610421199809292027");
		user.setUsertype(1);
		
		//2.调用数据库访问层中的添加方法
		userDao userDao = new userDao();
		boolean flag =userDao.addUser(user);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
    
	@Test
	public void testMethod2() throws Exception  {
		userDao userDao = new userDao();
		boolean flag =userDao.updateuser();
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	*/
	@Test
	public void testMethod3() throws Exception  {
		userDao userDao = new userDao();
		boolean flag =userDao.deluser(2);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	
	
	@Test
	public void testMethod4() throws Exception  {
		userDao userDao = new userDao();
		userDao.findAlluser();
	}
	
/*	@Test
	public void testMethod5() throws Exception  {
		userDao userDao = new userDao();
		List<List> users = userDao.findAll();
		for(int i=0;i<users.size();i++) {
			List data = users.get(i);
			System.out.println(data.toString());
		}
	}*/
	
	@Test
	public void testMethod6() {
		userDao userDao = new userDao();
		List<user> users =userDao.findAll1("zhangsan", "610421199809292027");
		for(int i=0;i<users.size();i++) {
			user user = users.get(i);
			System.out.println(user.toString());
		}
	}

	
	@Test
	public void testMethod7() {
		userDao userDao = new userDao();
		List<user> users =userDao.findAllUser(1,3);
		for(int i=0;i<users.size();i++) {
			user user = users.get(i);
			System.out.println(user.toString());
		}
	}
	
	
	@Test
	public void testMethod8() {
		userDao userDao = new userDao();
		List<user> users =userDao.findAllUser(null, "zhangsan", "610421199809292027",1,3);
		for(int i=0;i<users.size();i++) {
			user user = users.get(i);
			System.out.println(user.toString());
		}
	}


	
}

