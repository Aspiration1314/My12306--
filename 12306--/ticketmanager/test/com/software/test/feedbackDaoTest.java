package com.software.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;


import com.software.dao.feedbackDao;
import com.software.dao.orderDao;
import com.software.model.feedback;
import com.software.model.order;

public class feedbackDaoTest  {
	
	feedbackDao feedbackDao = new feedbackDao();
	/**
	 * 查找反馈信息测试用例
	 * @author 张圆梦
	 */

@Test
public void testMethod1() {
	List<feedback> feedbacks =feedbackDao.findAll();
	for(int i=0;i<feedbacks.size();i++) {
		feedback feedback = feedbacks.get(i);
		System.out.println(feedback.toString());
}
}
/**
 * 修改反馈信息测试用例
 * @author 张圆梦
 */
@Test
public void testMethod2() throws Exception  {
	boolean flag =feedbackDao.updatefeedback();
	if(flag) {
		System.out.println("success");
	}else {
		System.out.println("failure");
	}
}
/**
 *删除反馈信息测试用例
 * @author 张圆梦
 */
@Test
public void testMethod3() throws Exception  {
	boolean flag =feedbackDao.delticket(1);
	if(flag) {
		System.out.println("success");
	}else {
		System.out.println("failure");
	}
}
/**
 * 条件查找反馈信息
 * @author 张圆梦
 */
@Test
public void testMethod4() {
	feedbackDao feedbackDao = new feedbackDao();
	List<feedback> feedbacks =feedbackDao.findAll1("未处理");
	for(int i=0;i<feedbacks.size();i++) {
		feedback feedback = feedbacks.get(i);
		System.out.println(feedback.toString());
	}
}
/**
 * 按照informationID删除反馈信息
 * @author 张圆梦
 */
@Test
public void testMethod5()   {
	boolean flag =feedbackDao.deletinformationByID(1);
	if(flag) {
		System.out.println("success");
	}else {
		System.out.println("failure");
	}
}

}
	

