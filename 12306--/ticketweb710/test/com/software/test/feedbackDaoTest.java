package com.software.test;

import java.util.List;

import org.junit.Test;

import com.software.dao.feedbackDao;
import com.software.model.feedback;
import com.software.model.user;

public class feedbackDaoTest {
	@Test
	public void testMethod() throws Exception  {
		feedbackDao feedbackDao = new feedbackDao();
		feedback feedback = new feedback();
		
		
				
				feedback.setUserID(1);
				feedback.setInformation("zl");
				feedback.setOperation("Œ¥¥¶¿Ì");
		boolean flag =feedbackDao.addfeedback(feedback);
		if(flag) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}
	
	@Test
	public void testMethod1() throws Exception  {
		feedbackDao feedbackDao = new feedbackDao();
		
		List data = feedbackDao.findAt(3);
		
		System.out.println(data.toString());
		
		
		
	}

}

