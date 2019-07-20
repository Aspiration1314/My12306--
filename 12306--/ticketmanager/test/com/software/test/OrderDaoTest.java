package com.software.test;

import java.util.List;

import org.junit.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.software.dao.orderDao;
import com.software.dao.userDao;
import com.software.model.order;
import com.software.model.user;
import com.software.util.DBHelp;

/**
 * ��Ԫ������
 * @author ��Բ��
 *
 */

//**
/** * ɾ��������������
 * @author ��Բ��
 */
public class OrderDaoTest {

	private List<List> orders;
	@Test
	public void testMethod() throws Exception  {
		boolean flag =orderDao.delorder(2);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}


	/**
	 * ����ȫ��������������
	 * @author ��Բ��
	 */
	@Test
	public void testMethod1() throws Exception  {
		orderDao orderDao = new orderDao();
		orderDao.findAllorder();
	}
	
	/**
	 * ���֮������ϲ�ѯ������������
	 * @return
	 * @author ��Բ��
	 */
	
	@Test
	public void testMethod2() throws Exception  {
		orderDao orderDao = new orderDao();
		List<List> orders = orderDao.findAll();
		for(int i=0;i<orders.size();i++) {
			List data = orders.get(i);
			System.out.println(data.toString());
		}
	}
	/**
	 * ������ѯ������������
	 * @return
	 * @author ��Բ��
	 */
	
	@Test
	public void testMethod3() {
		orderDao orderDao = new orderDao();
		List<order> orders =orderDao.findAll(4,"δ֧��");
		for(int i=0;i<orders.size();i++) {
			order order = orders.get(i);
			System.out.println(order.toString());
		}
	}
	/**
	 * ��ҳ��ѯ������������
	 * @return
	 * @author ��Բ��
	 */
	@Test
	public void testMethod4() {
		orderDao orderDao = new orderDao();
		List<order> orders =orderDao.findAllOrder(1,3);
		for(int i=0;i<orders.size();i++) {
			order order = orders.get(i);
			System.out.println(order.toString());
		}
	}
	/**
	 * �������ķ�ҳ��ѯ��������
	 * @param orderstate userID
	 * @return
	 * @author ��Բ��
	 */
   @Test
	public void  testMethod5() {

		orderDao orderDao = new orderDao();
		List<order> orders =orderDao.findAllOrder(1,3,4);
		for(int i=0;i<orders.size();i++) {
			order order = orders.get(i);
			System.out.println(order.toString());
		}
	}
   /**������ʵ������ѯ������Ϣ
    * @param realname 
    * @return 
    * @author ��Բ��
    */
   @Test
   public void testMethod6() {

	   orderDao orderDao = new orderDao();
		List<List> orders =orderDao.findAllorder("����") ;
		for(int i=0;i<orders.size();i++) {
			List data = orders.get(i);
			System.out.println(data.toString());
		}
	}
   /**���ն���״̬��ѯ������Ϣ
    * @param orderstate 
    * @return 
    * @author ��Բ��
    */
   @Test
   public void testMethod7() {

	   orderDao orderDao = new orderDao();
		List<List> orders =orderDao.findAllorder1("δ֧��") ;
		for(int i=0;i<orders.size();i++) {
			List data = orders.get(i);
			System.out.println(data.toString());
		}
	}
   /**
	 * ����orderIDɾ����Ʊ��Ϣ
	 * @author ��Բ��
	 */
   @Test
	public void testMethod8()   {
		boolean flag =orderDao. deletordrByID(5);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	
}



