package com.niit.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.constants.MessageConstant;
import com.niit.dbutil.DBConnection;

/*created by :-prateek kamdar
created date:-12/9/2018
updated by:-null
updated date:-null 
*/

import com.niit.model.UserModel;
import com.sun.org.apache.regexp.internal.recompile;

public class UserDAO {

	public static int addUser(UserModel user) throws SQLException {
		/*Statement stmt=DBConnection.buildConection();
		String sql="insert into user(username,password,email,gender,phone,flag,date) values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getGender()+"','"+user.getPhone()+"','"+user.getFlag()+"','"+user.getDate()+"')";
		int flag=stmt.executeUpdate(sql);*/
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		UserModel userModel=(UserModel) session.createQuery("from UserModel where username='"+user.getUsername()+"'").uniqueResult();
		
		if(userModel!=null) {
			return MessageConstant.USER_CREATE_SAME;
		}
		else {
			session.saveOrUpdate(user);
			tx.commit();
			session.close();
			return MessageConstant.USER_CREATE_SUCCESS;
		}
		
	}

	public static Integer login(UserModel user) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		UserModel userModel=(UserModel) session.createQuery("from UserModel where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'").uniqueResult();
		if(userModel!=null) {
			if(user.getUsername().equals("Frank")&& user.getPassword().equals("147258")) 
			{
				
				return MessageConstant.LOGIN_ADMIN;
			}
			else if(user.getUsername().equals(userModel.getUsername())&& user.getPassword().equals(userModel.getPassword()))
			{
				return MessageConstant.LOGIN_SUCCESS;
			}
			else {
				return MessageConstant.LOGIN_FAIL;
			}
		}else {
			return MessageConstant.SOMETHING_WRONG;
		}
	}

	public static List<UserModel> getAllUser() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<UserModel> userList=session.createCriteria(UserModel.class).list();
		tx.commit();
		session.close();
		return userList;
	}

	public static void remove(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		UserModel userModel=session.get(UserModel.class, id);
		session.delete(userModel);
		tx.commit();
		session.close();
	}

	public static void block(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		UserModel userModel=session.get(UserModel.class	, id);
		userModel.setFlag(MessageConstant.BLOCK_FLAG);
		session.saveOrUpdate(userModel);
		tx.commit();
		session.close();
		
	}

	public static void active(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		UserModel userModel=session.get(UserModel.class	, id);
		userModel.setFlag(MessageConstant.ACTIVE_FLAG);
		session.saveOrUpdate(userModel);
		tx.commit();
		session.close();
	}

	public static UserModel getUser(Integer id) throws SQLException{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		UserModel model=session.get(UserModel.class, id);
		tx.commit();
		session.close();
		return model;
	}

	public static void update(UserModel model) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(model);
		tx.commit();
		session.close();
		
	}
		
	public static void reset(String username,String password) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("update UserModel set password='"+password+"' where username='"+username+"'").executeUpdate();
		tx.commit();
		session.close();
		
	}


}
