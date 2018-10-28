package com.niit.dao;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator  extends Authenticator{
	private String username = "Frank";  
	 
	private String password = "147258";  
 
	public MyAuthenticator() {  
		super();  
	}  
 
	public MyAuthenticator(String username, String password) {  
		super();  
		this.username = username;  
		this.password = password;  
	}  
 
	@Override  
	protected PasswordAuthentication getPasswordAuthentication() {  
 
		return new PasswordAuthentication(username, password);  
	}  



}
