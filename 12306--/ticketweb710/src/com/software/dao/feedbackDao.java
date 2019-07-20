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
 * 数据库访问层--实现反馈信息操作
 * @author 张梅 
 *
 */

public class feedbackDao {

	/*
	 * 添加反馈信息
	 * @author 张梅
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
	 * 查找反馈信息
	 * @author 张梅
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
				//创建用户对象
				feedback = new feedback();
				feedback.setInformationID(rs.getInt("informationID"));		
				feedback.setUserID(rs.getInt("userID"));
				feedback.setInformation(rs.getString("information"));
				feedback.setOperation(rs.getString("operation"));
				feedback.setOperationresult(rs.getString("operationresult"));
				
				feedbacks.add(feedback);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return feedbacks;
		
	}
	
	/**
	 * 条件查找反馈信息
	 * @author 张梅
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
				//创建用户对象
				feedback = new feedback();
				feedback.setInformationID(rs.getInt("informationID"));	
				feedback.setUserID(rs.getInt("userID"));
				feedback.setInformation(rs.getString("information"));
				feedback.setOperation(rs.getString("operation"));
				feedback.setOperationresult(rs.getString("operationresult"));
				feedbacks.add(feedback);
			}
			// 关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return feedbacks;
		
	}
	
	
	/**
	 * 按照用户编号和信息状态查询反馈信息
	 * @author 郭鹏科
	 */
	public  List findAt(Integer userID)  {
		List feedbacks = new ArrayList();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql ="select operationresult from feedback where operation='已处理' and userID="+userID;
			
			
			
			rs =st.executeQuery(sql);
			feedback feedback =null;
			while(rs.next()) {
				//创建用户对象
				feedbacks.add(rs.getString("operationresult"));
			}
			// 关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return feedbacks;
		
	}
	
	
	public boolean updatefeedback() throws Exception {
		// 修改反馈信息
		boolean flag = false;
		String sql = "update feedback set operation = '已处理', operationresult = '我们会改善环境' where informationID =1";
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	
	/**
	 * 按照informationID删除反馈信息
	 * @author 张梅
	 */
	public boolean deletinformationByID(int informationID) {
		// 删除反馈信息
		boolean flag = false;
		String sql = "delete from feedback where informationID = "+ informationID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
}


