package com.niit.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.niit.constants.MessageConstant;
import com.niit.dao.BookDAO;
import com.niit.dao.TriggerDAO;
import com.niit.dao.UserDAO;
import com.niit.model.BookModel;
import com.niit.model.BorrowModel;
import com.niit.model.LostModel;
import com.niit.model.RequestModel;
import com.niit.model.ReserveModel;
import com.niit.model.ReturnModel;
import com.niit.model.UserModel;
import com.niit.supportclasses.EmailConfig;


public class BookService {
	public static Integer addBook(BookModel book) throws SQLException {
		if(book!=null) {
			Integer flag=BookDAO.addBook(book);
			return flag;
		}else {
			return MessageConstant.BOOK_ISNULL;
		}
	}
	
	public static void addBook2(BorrowModel book) throws SQLException {
		if(book!=null) {
			BookDAO.addBook2(book);
		}
	}
	
	public static void addBook3(ReserveModel book) throws SQLException {
		if(book!=null) {
			BookDAO.addBook3(book);
		}
	}
	public static void addBook4(RequestModel book) throws SQLException {
		if(book!=null) {
			BookDAO.addBook4(book);
		}
	}
	public static void addBook5(ReturnModel book) throws SQLException {
		if(book!=null) {
			BookDAO.addBook5(book);
		}
	}
	
	public static void addBook6(LostModel book) throws SQLException {
		if(book!=null) {
			BookDAO.addBook6(book);
		}
	}
	
	public static List<BookModel> getAllBook() throws SQLException{
		List<BookModel> bookList=BookDAO.getAllBook();
		return bookList;
	}
	public static List<BorrowModel> getAllBorrow() throws SQLException{
		List<BorrowModel> bookList=BookDAO.getAllBorrow();
		return bookList;
	}
	public static List<ReserveModel> getAllReserve() throws SQLException{
		List<ReserveModel> bookList=BookDAO.getAllReserve();
		return bookList;
	}
	public static List<RequestModel> getAllRequest() throws SQLException{
		List<RequestModel> bookList=BookDAO.getAllRequest();
		return bookList;
	}
	public static List<ReturnModel> getAllReturn() throws SQLException{
		List<ReturnModel> bookList=BookDAO.getAllReturn();
		return bookList;
	}
	public static List<LostModel> getAllLost() throws SQLException{
		List<LostModel> bookList=BookDAO.getAllLost();
		return bookList;
	}
	
	
	public static List<BorrowModel> getAllBook2(String user_name) throws SQLException{
		List<BorrowModel> bookList=BookDAO.getAllBook2(user_name);
		return bookList;
	}
	
	public static List<ReserveModel> getAllBook3(String user_name) throws SQLException{
		List<ReserveModel> bookList=BookDAO.getAllBook3(user_name);
		return bookList;
	}
	public static List<RequestModel> getAllBook4(String user_name) throws SQLException{
		List<RequestModel> bookList=BookDAO.getAllBook4(user_name);
		return bookList;
	}
	
	public static List<ReturnModel> getAllBook5(String user_name) throws SQLException{
		List<ReturnModel> bookList=BookDAO.getAllBook5(user_name);
		return bookList;
	}
	
	
	public static BookModel getBook(Integer id) throws SQLException{
		
		if(id!=null) {
			BookModel model=BookDAO.getBook(id);
			return model;
		}else {
			return null;
		}
	}
	
public static BorrowModel getBook2(Integer id) throws SQLException{
		
		if(id!=null) {
			BorrowModel model=BookDAO.getBook2(id);
			return model;
		}else {
			return null;
		}
	}

public static BookModel getBook3(Integer book_id) throws SQLException{
	
	if(book_id!=null) {
		BookModel model=BookDAO.getBook3(book_id);
		return model;
	}else {
		return null;
	}
}
	
	public static void remove(Integer id) throws SQLException {
		if(id!=null) {
			BookDAO.remove(id);
		}
	}
	public static void remove2(Integer book_id) throws SQLException {
		if(book_id!=null) {
			BookDAO.remove2(book_id);
		}
	}
	
	public static void remove3(Integer id) throws SQLException {
		if(id!=null) {
			BookDAO.remove3(id);
		}
	}
	
	public static void remove4(Integer id) throws SQLException {
		if(id!=null) {
			BookDAO.remove4(id);
		}
	}
	public static void update(BookModel model) throws SQLException {
		BookDAO.update(model);
		
	}
	
	public static List<BookModel> getSearchBook(String search) throws SQLException{
		List<BookModel> bookList=BookDAO.getSearchBook(search);
		return bookList;
	}
	
	
	public static void reduce(Integer id) throws SQLException {
		if(id!=null) {
			BookDAO.reduce(id);
		}
	}
	
	public static void reduce2(Integer id) throws SQLException {
		if(id!=null) {
			BookDAO.reduce2(id);
		}
	}
	
	public static void plus(Integer book_id) throws SQLException {
		if(book_id!=null) {
			BookDAO.plus(book_id);
		}
	}
	public static void plus2(Integer book_id) throws SQLException {
		if(book_id!=null) {
			BookDAO.plus2(book_id);
		}
	}
	
	public static void plus3(Integer book_id) throws SQLException {
		if(book_id!=null) {
			BookDAO.plus3(book_id);
		}
	}
	
	public static void BorrowemailTo(String username,String bookname) throws Exception {
		EmailConfig.BorrowEmailtoAdmin(username, bookname);
	}
	
	public static void ReserveemailTo(String username,String bookname) throws Exception {
		EmailConfig.ReserveEmailtoAdmin(username, bookname);
	}
	public static void ReturnemailTo(String username,String bookname) throws Exception {
		EmailConfig.ReturnEmailtoAdmin(username, bookname);
	}
	
	public static void ReturnBookEmail(Date startTime) throws Exception {
		TriggerDAO.ReturnBookEmail(startTime);
	}
	
	public static void BorrowSuccess(String username,String bookname) throws Exception {
		EmailConfig.BorrowSuccess(username, bookname);
	}
	
	public static void ReturnSuccess(String username,String bookname) throws Exception {
		EmailConfig.ReturnSuccess(username, bookname);
	}
	
	public static void ReserveSuccess(String username,String bookname) throws Exception {
		EmailConfig.ReserveSuccess(username, bookname);
	}
	
	public static void RefuseEmali(String username,String bookname,String op) throws Exception {
		EmailConfig.RefuseEmail(username, bookname, op);
	}
	
	public static List<BorrowModel> getborrow(String op_date) throws SQLException{
		List<BorrowModel> bookList=BookDAO.getborrow(op_date);
		return bookList;
	}
}
