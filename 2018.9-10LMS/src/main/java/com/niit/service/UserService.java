package com.niit.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.niit.constants.MessageConstant;
import com.niit.dao.JobDAO;
import com.niit.dao.TriggerDAO;
import com.niit.dao.UserDAO;
import com.niit.dbutil.DBConnection;

/*created by :-n
created date:-13/9/2018
updated by:-null
updated date:-null 
*/

import com.niit.model.UserModel;
import com.niit.supportclasses.EmailConfig;

public class UserService {

	public static Integer addUser(UserModel user) throws SQLException {
		if(user!=null) {
			Integer flag=UserDAO.addUser(user);
			return flag;
		}else {
			return MessageConstant.USER_ISNULL;
		}
	}

	public static Integer login(UserModel user) throws SQLException {
		if(user!=null) {
			Integer flag=UserDAO.login(user);
			return flag;
		}else {
			return MessageConstant.SOMETHING_WRONG;
		}
	}
	
	public static List<UserModel> getAllUser() throws SQLException{
		List<UserModel> userList=UserDAO.getAllUser();
		return userList;
	}

	public static void remove(Integer id) throws SQLException {
		if(id!=null) {
			UserDAO.remove(id);
		}
	}

	public static void block(Integer id) throws SQLException {
		if(id!=null) {
			UserDAO.block(id);
		}
	}

	public static void active(Integer id) throws SQLException {
		if(id!=null) {
			UserDAO.active(id);
		}
	}

	public static UserModel getUser(Integer id) throws SQLException{
		
	if(id!=null) {
		UserModel model=UserDAO.getUser(id);
		return model;
	}else {
		return null;
	}
	
}

	public static void update(UserModel model) throws SQLException {
		UserDAO.update(model);
		
	}
	
	public static void reset(String username,String password) throws SQLException {
		UserDAO.reset(username, password);
		
	}
	
	
	public static void emailToRegister(String username) {
		EmailConfig.RegisterEmailtoAdmin(username);
	}
	
	
	
	
	

	
	
	

}
