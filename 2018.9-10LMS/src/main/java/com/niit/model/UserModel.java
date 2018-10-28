package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* created by :-n
created date:-12/9/2018
updated by:-null
updated date:-null 
*/

/*@Entity
@Table(name="usermodel")*/
public class UserModel {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private int id;
	//@Column(name="flag")
	private int flag;
	//@Column(name="username")
	private String username;
	//@Column(name="password")
	private String password;
	//@Column(name="email")
	private String email;
	//@Column(name="phone")
	private String phone;
	//@Column(name="identity")
	private String identity;
	//@Column(name="date")
	private String date;
	
	
	public UserModel() {
		
	}
	
	public UserModel(String username2, String pass, String email2, String phone2,String ident2, int approve,
			String date2) {
		// TODO Auto-generated constructor stub
		this.username=username2;
		this.password=pass;
		this.email=email2;
		this.phone=phone2;
		this.identity=ident2;
		this.date=date2;
		this.flag=approve;
	}
	public UserModel(String username2, String pass) {
		this.username=username2;
		this.password=pass;
	}
	public UserModel(int id2, String username2, String pass, String email2, String phone2, String ident2) {
		this.id=id2;
		this.username=username2;
		this.password=pass;
		this.email=email2;
		this.identity=ident2;
		this.phone=phone2;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
