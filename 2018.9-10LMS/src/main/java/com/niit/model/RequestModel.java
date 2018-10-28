package com.niit.model;

public class RequestModel {
	private int id,book_id;
	private String user_name,bookname,img,author,remain,date,op;
	
	
	
	public RequestModel() {
		
	}
	
	
	public RequestModel(String user_name2, String bookname2, String img2,String author2, String remain2, String date2,String op2,
			int book_id2) {
		this.user_name=user_name2;
		this.bookname=bookname2;
		this.img=img2;
		this.author=author2;
		this.remain=remain2;
		this.date=date2;
		this.op=op2;
		this.book_id=book_id2;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
	
}
