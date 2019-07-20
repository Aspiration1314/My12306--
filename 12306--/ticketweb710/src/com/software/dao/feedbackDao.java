package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.feedback;
import com.software.model.ticket;
import com.software.model.order;
import com.software.util.DBHelp;

/**
 * ���ݿ���ʲ�--ʵ�ַ�����Ϣ����
 * @author ��÷ 
 *
 */

public class feedbackDao {

	/*
	 * ��ӷ�����Ϣ
	 * @author ��÷
	 */

	public boolean addfeedback(feedback feed) throws Exception {
		boolean flag = false;
		String sql = "insert into feedback(userID,information,operation) "
				+ "values ('"+feed.getUserID()+"','"+feed.getInformation()+"','"+feed.getOperation()+"')";
		
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}	

	/*
	 * ���ҷ�����Ϣ
	 * @author ��÷
	 */
	
	public  List<feedback> findAll(String userID)  {
		List<feedback> feedbacks = new ArrayList<feedback>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select informationID,userID,information,operation,operationresult from feedback";
			rs =st.executeQuery(sql);
			feedback feedback =null;
			while(rs.next()) {
				//�����û�����
				feedback = new feedback();
				feedback.setInformationID(rs.getInt("informationID"));		
				feedback.setUserID(rs.getInt("userID"));
				feedback.setInformation(rs.getString("information"));
				feedback.setOperation(rs.getString("operation"));
				feedback.setOperationresult(rs.getString("operationresult"));
				
				feedbacks.add(feedback);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return feedbacks;
		
	}
	
	/**
	 * �������ҷ�����Ϣ
	 * @author ��÷
	 */
	public  List<feedback> findAll1(String operation)  {
		List<feedback> feedbacks = new ArrayList<feedback>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			
			String sql ="select informationID,userID,information,operation,operationresult from feedback where 1=1";
			
			if(operation !=null && operation.trim().length()>0) {
				sql = sql + " and operation='" + operation +"'";
			}
			
			
			rs =st.executeQuery(sql);
			feedback feedback =null;
			while(rs.next()) {
				//�����û�����
				feedback = new feedback();
				feedback.setInformationID(rs.getInt("informationID"));	
				feedback.setUserID(rs.getInt("userID"));
				feedback.setInformation(rs.getString("information"));
				feedback.setOperation(rs.getString("operation"));
				feedback.setOperationresult(rs.getString("operationresult"));
				feedbacks.add(feedback);
			}
			// �ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return feedbacks;
		
	}
	
	
	/**
	 * �����û���ź���Ϣ״̬��ѯ������Ϣ
	 * @author ������
	 */
	public  List findAt(Integer userID)  {
		List feedbacks = new ArrayList();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql ="select operationresult from feedback where operation='�Ѵ���' and userID="+userID;
			
			
			
			rs =st.executeQuery(sql);
			feedback feedback =null;
			while(rs.next()) {
				//�����û�����
				feedbacks.add(rs.getString("operationresult"));
			}
			// �ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return feedbacks;
		
	}
	
	
	public boolean updatefeedback() throws Exception {
		// �޸ķ�����Ϣ
		boolean flag = false;
		String sql = "update feedback set operation = '�Ѵ���', operationresult = '���ǻ���ƻ���' where informationID =1";
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	
	/**
	 * ����informationIDɾ��������Ϣ
	 * @author ��÷
	 */
	public boolean deletinformationByID(int informationID) {
		// ɾ��������Ϣ
		boolean flag = false;
		String sql = "delete from feedback where informationID = "+ informationID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
}


