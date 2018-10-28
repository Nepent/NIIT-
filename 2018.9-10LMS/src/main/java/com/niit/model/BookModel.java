package com.niit.model;

public class BookModel {
	private int id,flag;
	private String bookname,img,author,press,describe,remain,date,price,category,borrow_date;
	
	public BookModel() {
		
	}
	public BookModel(int id2, String bookname2,String img2, String author2, String press2, String describe2, String remain2,String price2,String category2) {
		this.id=id2;
		this.bookname=bookname2;
		this.img=img2;
		this.author=author2;
		this.press=press2;
		this.describe=describe2;
		this.remain=remain2;
		this.price=price2;
		this.category=category2;
	}
	
	public BookModel(String bookname2,String img2, String author2, String press2, String describe2, String remain2,String price2,String category2, String date2,int approve) {
		this.bookname=bookname2;
		this.img=img2;
		this.author=author2;
		this.press=press2;
		this.describe=describe2;
		this.remain=remain2;
		this.price=price2;
		this.category=category2;
		this.flag=approve;
		this.date=date2;
	}
	
	
	public BookModel(int id2, String borrow_date2) {
		this.id=id2;
		this.borrow_date=borrow_date2;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
