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
 * 单元测试类
 * @author 张圆梦
 *
 */

//**
/** * 删除订单测试用例
 * @author 张圆梦
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
	 * 查找全部订单测试用例
	 * @author 张圆梦
	 */
	@Test
	public void testMethod1() throws Exception  {
		orderDao orderDao = new orderDao();
		orderDao.findAllorder();
	}
	
	/**
	 * 多表之间的联合查询订单测试用例
	 * @return
	 * @author 张圆梦
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
	 * 条件查询订单测试用例
	 * @return
	 * @author 张圆梦
	 */
	
	@Test
	public void testMethod3() {
		orderDao orderDao = new orderDao();
		List<order> orders =orderDao.findAll(4,"未支付");
		for(int i=0;i<orders.size();i++) {
			order order = orders.get(i);
			System.out.println(order.toString());
		}
	}
	/**
	 * 分页查询订单测试用例
	 * @return
	 * @author 张圆梦
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
	 * 按条件的分页查询测试用例
	 * @param orderstate userID
	 * @return
	 * @author 张圆梦
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
   /**按照真实姓名查询订单信息
    * @param realname 
    * @return 
    * @author 张圆梦
    */
   @Test
   public void testMethod6() {

	   orderDao orderDao = new orderDao();
		List<List> orders =orderDao.findAllorder("张三") ;
		for(int i=0;i<orders.size();i++) {
			List data = orders.get(i);
			System.out.println(data.toString());
		}
	}
   /**按照订单状态查询订单信息
    * @param orderstate 
    * @return 
    * @author 张圆梦
    */
   @Test
   public void testMethod7() {

	   orderDao orderDao = new orderDao();
		List<List> orders =orderDao.findAllorder1("未支付") ;
		for(int i=0;i<orders.size();i++) {
			List data = orders.get(i);
			System.out.println(data.toString());
		}
	}
   /**
	 * 按照orderID删除车票信息
	 * @author 张圆梦
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



