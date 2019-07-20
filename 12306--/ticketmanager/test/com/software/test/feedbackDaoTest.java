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
	 * ���ҷ�����Ϣ��������
	 * @author ��Բ��
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
 * �޸ķ�����Ϣ��������
 * @author ��Բ��
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
 *ɾ��������Ϣ��������
 * @author ��Բ��
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
 * �������ҷ�����Ϣ
 * @author ��Բ��
 */
@Test
public void testMethod4() {
	feedbackDao feedbackDao = new feedbackDao();
	List<feedback> feedbacks =feedbackDao.findAll1("δ����");
	for(int i=0;i<feedbacks.size();i++) {
		feedback feedback = feedbacks.get(i);
		System.out.println(feedback.toString());
	}
}
/**
 * ����informationIDɾ��������Ϣ
 * @author ��Բ��
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
	

