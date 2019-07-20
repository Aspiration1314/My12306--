package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.software.model.feedback;
import com.software.model.order;
import com.software.model.ticket;
import com.software.util.DBHelp;

public class feedbackDao {

	/**
	 * 查找反馈信息
	 * @author 张圆梦
	 */

		
		public  List<feedback> findAll()  {
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
		 * 修改反馈信息
		 * @author 张圆梦
		 * @param  
		 */
		
		public boolean updatefeedback( ) throws Exception {
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
		 * 删除反馈信息
		 * @author 张圆梦
		 */
		public boolean delticket(int informationID) throws Exception {
			// 删除反馈信息
			boolean flag = false;
			String sql = "delete from feedback where informationID = "+ informationID;
			int count = DBHelp.executeSql(sql);
			
			if (count >0) {
				flag =true;
			}
			return flag;
		}
		/**
		 * 条件查找反馈信息
		 * @author 张圆梦
		 * @param pagerows 
		 * @param currentpage 
		 */
		public  List<feedback> findAll1(String operation)  {
			List<feedback> feedbacks = new ArrayList<feedback>();
			
			Connection connection = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				connection = DBHelp.getConnect();		
				st = connection.createStatement();
				
				
				String sql ="select informationID,userID,managerID,information,operation,operationresult from feedback where 1=1";
				
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
					feedback.setManagerID(rs.getInt("managerID"));
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
		 * 按照informationID删除反馈信息
		 * @author 张圆梦
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
		/**
		 * 通过反馈信息编号查找反馈信息informationID
		 * @author 张圆梦
		 */

			
			public  feedback findfeedbackById(int informationID)  {
				
				feedback Feedback=new feedback();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					connection = DBHelp.getConnect();		
					st = connection.createStatement();
					
					String sql = "select informationID,userID,managerID,information,operation,operationresult from feedback"
							+ " where informationID="+ informationID;
					rs =st.executeQuery(sql);
				
					if(rs.next()) {
						//创建用户对象
					
						Feedback.setInformationID(rs.getInt("informationID"));		
						Feedback.setUserID(rs.getInt("userID"));
						Feedback.setManagerID(rs.getInt("managerID"));
						Feedback.setInformation(rs.getString("information"));
						Feedback.setOperation(rs.getString("operation"));
						Feedback.setOperationresult(rs.getString("operationresult"));
						
					
					}
					// 5.关闭数据库连接对象
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBHelp.closeAll(rs, st, connection);
				}
				
				return Feedback;
				
			}
			/**
			 *  实现反馈信息修改操作
			 * @param user :修改的用户对象
			 * @return true:修改成功   false:修改失败
			 * 张圆梦
			 */
			public boolean updateFeedback(feedback feedback) {
				boolean flag = false;
				String sql="update feedback set informationID='"+feedback.getInformationID()+
						"',userID='"+feedback.getUserID()+"',"
						+ "managerID='"+feedback.getManagerID()+"',information='"+feedback.getInformation()
						+"',operation='"+feedback.getOperation()+"',"
						+ "operationresult='"+feedback.getOperationresult()+"' where informationID=" + feedback.getInformationID();
				int count =DBHelp.executeSql(sql);
				if (count >0) {
					flag =true;
				}
					
				return flag;
			}
			/** * 按条件的分页查询
			 * @param operation
			 *张圆梦
			 * @return
			 */
			public  List<feedback> findAllFeedback1(String operation, int currentPage,int pageSize)  {
				List<feedback> feedbacks = new ArrayList<feedback>();
				
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					connection = DBHelp.getConnect();		
					st = connection.createStatement();
					
					String sql ="select informationID,userID,managerID,information,operation,operationresult from feedback where 1=1";
					
					if(operation !=null && operation.trim().length()>0) {
						sql = sql + " and operation='" + operation +"'";
					}
					sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
					rs =st.executeQuery(sql);
					feedback  feedback=null;
					while(rs.next()) {
						//创建用户对象
						feedback = new feedback();
						feedback.setInformationID(rs.getInt("informationID"));	
						feedback.setUserID(rs.getInt("userID"));
						feedback.setManagerID(rs.getInt("managerID"));
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
			 *
			 * 获取表的行数
			 * 张圆梦
			 * @return
			 */
			public  int getCountFeedbacks()  {
				int count = 0;	
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					connection = DBHelp.getConnect();		
					st = connection.createStatement();
					
					String sql = "select count(*) from feedback";	
					rs =st.executeQuery(sql);			
					if(rs.next()) {			
						count = rs.getInt(1);
					}
					// 5.关闭数据库连接对象
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBHelp.closeAll(rs, st, connection);
				}
				
				return count;
				
			}
			
			/** 
			 * 
			 * 条件查询获取表的行数
			 * 张圆梦
			 * @return
			 */
			public    int getCountFeedbacks1(String operation)  {
				int count = 0;	
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					connection = DBHelp.getConnect();		
					st = connection.createStatement();
					
					String sql = "select count(*) from feedback where 1=1 ";
					if(operation !=null && operation.trim().length()>0) {
						sql = sql + " and  operation like '%" + operation +"%'";
					}
					
					rs =st.executeQuery(sql);			
					if(rs.next()) {			
						count = rs.getInt(1);
					}
					// 5.关闭数据库连接对象
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBHelp.closeAll(rs, st, connection);
				}
				
				return count;
			}
			
			
			
}

	
		


