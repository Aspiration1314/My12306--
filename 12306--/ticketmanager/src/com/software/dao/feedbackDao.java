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
	 * ���ҷ�����Ϣ
	 * @author ��Բ��
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
		 * �޸ķ�����Ϣ
		 * @author ��Բ��
		 * @param  
		 */
		
		public boolean updatefeedback( ) throws Exception {
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
		 * ɾ��������Ϣ
		 * @author ��Բ��
		 */
		public boolean delticket(int informationID) throws Exception {
			// ɾ��������Ϣ
			boolean flag = false;
			String sql = "delete from feedback where informationID = "+ informationID;
			int count = DBHelp.executeSql(sql);
			
			if (count >0) {
				flag =true;
			}
			return flag;
		}
		/**
		 * �������ҷ�����Ϣ
		 * @author ��Բ��
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
					//�����û�����
					feedback = new feedback();
					feedback.setInformationID(rs.getInt("informationID"));	
					feedback.setUserID(rs.getInt("userID"));
					feedback.setManagerID(rs.getInt("managerID"));
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
		 * ����informationIDɾ��������Ϣ
		 * @author ��Բ��
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
		/**
		 * ͨ��������Ϣ��Ų��ҷ�����ϢinformationID
		 * @author ��Բ��
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
						//�����û�����
					
						Feedback.setInformationID(rs.getInt("informationID"));		
						Feedback.setUserID(rs.getInt("userID"));
						Feedback.setManagerID(rs.getInt("managerID"));
						Feedback.setInformation(rs.getString("information"));
						Feedback.setOperation(rs.getString("operation"));
						Feedback.setOperationresult(rs.getString("operationresult"));
						
					
					}
					// 5.�ر����ݿ����Ӷ���
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBHelp.closeAll(rs, st, connection);
				}
				
				return Feedback;
				
			}
			/**
			 *  ʵ�ַ�����Ϣ�޸Ĳ���
			 * @param user :�޸ĵ��û�����
			 * @return true:�޸ĳɹ�   false:�޸�ʧ��
			 * ��Բ��
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
			/** * �������ķ�ҳ��ѯ
			 * @param operation
			 *��Բ��
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
						//�����û�����
						feedback = new feedback();
						feedback.setInformationID(rs.getInt("informationID"));	
						feedback.setUserID(rs.getInt("userID"));
						feedback.setManagerID(rs.getInt("managerID"));
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
			 *
			 * ��ȡ�������
			 * ��Բ��
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
					// 5.�ر����ݿ����Ӷ���
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
			 * ������ѯ��ȡ�������
			 * ��Բ��
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
					// 5.�ر����ݿ����Ӷ���
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBHelp.closeAll(rs, st, connection);
				}
				
				return count;
			}
			
			
			
}

	
		


