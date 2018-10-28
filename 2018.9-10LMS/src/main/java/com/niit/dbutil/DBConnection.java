package com.niit.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*created by :-prateek kamdar
created date:-12/9/2018
updated by:-null
updated date:-null 
*/

public class DBConnection {

	public static Session buildConection() throws SQLException {
		/*String url="jdbc:mysql//localhost:3306/mvc";
		String username="root";
		String password="";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		return stmt;*/
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		return session;
	}

}
