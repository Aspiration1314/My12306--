package com.software.test;

import org.junit.Test;

import com.software.model.manager;
import com.software.dao.managerDao;



/**
 * ��Ԫ������
 * @author ��Բ��
 * @param <managerDao>
 *
 */

public class ManagerDaoTest {
	/*
	 * ��ӹ���Ա������
	 * @author ��Բ��
	 */
	managerDao managerDao = new managerDao();
	@Test
	public void testMethod1() throws Exception{
		//1.����manager����Ĳ�������
		manager manager = new manager();
		manager.setLoginname("T88");
		manager.setLoginpwd("123123123");
		
		//2.�������ݿ���ʲ��е���ӷ���
		
		boolean flag = managerDao.addManager(manager);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	/*
	 * ����ȫ������Ա��������
	 * @author ��Բ��
	 */
	@Test
	public void testMethod2() throws Exception  {
		managerDao.findAllmanager();
	}
}


