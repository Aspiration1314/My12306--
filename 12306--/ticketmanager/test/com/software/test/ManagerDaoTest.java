package com.software.test;

import org.junit.Test;

import com.software.model.manager;
import com.software.dao.managerDao;



/**
 * 单元测试类
 * @author 张圆梦
 * @param <managerDao>
 *
 */

public class ManagerDaoTest {
	/*
	 * 添加管理员试用例
	 * @author 张圆梦
	 */
	managerDao managerDao = new managerDao();
	@Test
	public void testMethod1() throws Exception{
		//1.创建manager对象的测试用例
		manager manager = new manager();
		manager.setLoginname("T88");
		manager.setLoginpwd("123123123");
		
		//2.调用数据库访问层中的添加方法
		
		boolean flag = managerDao.addManager(manager);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	/*
	 * 查找全部管理员测试用例
	 * @author 张圆梦
	 */
	@Test
	public void testMethod2() throws Exception  {
		managerDao.findAllmanager();
	}
}


