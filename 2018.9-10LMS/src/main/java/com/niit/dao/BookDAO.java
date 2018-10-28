package com.niit.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.constants.MessageConstant;
import com.niit.dbutil.DBConnection;
import com.niit.model.BookModel;
import com.niit.model.BorrowModel;
import com.niit.model.LostModel;
import com.niit.model.RequestModel;
import com.niit.model.ReserveModel;
import com.niit.model.ReturnModel;
import com.niit.model.UserModel;
import com.niit.supportclasses.GeneralSupport;

public class BookDAO {
	
	
	//���ͼ�鵽���ݿ�
	public static int addBook(BookModel book) throws SQLException {
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
		return MessageConstant.BOOK_CREATE_SUCCESS;
	}
	
	//��ӽ���鵽���ݿ�
	public static void addBook2(BorrowModel book) throws SQLException {
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
	}
	
	//���Ԥ�����鵽���ݿ�
	public static void addBook3(ReserveModel book) throws SQLException {
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
	}
	
	//���request

	public static void addBook4(RequestModel book) throws SQLException {
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
	}

	public static void addBook5(ReturnModel book) throws SQLException {
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	session.saveOrUpdate(book);
	tx.commit();
	session.close();
}
	
	public static void addBook6(LostModel book) throws SQLException {
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
	}


	//��ȡ����ͼ��
	public static List<BookModel> getAllBook() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<BookModel> bookList=session.createCriteria(BookModel.class).list();
		tx.commit();
		session.close();
		return bookList;
	}
	public static List<BorrowModel> getAllBorrow() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<BorrowModel> bookList=session.createCriteria(BorrowModel.class).list();
		tx.commit();
		session.close();
		return bookList;
	}
	public static List<ReserveModel> getAllReserve() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<ReserveModel> bookList=session.createCriteria(ReserveModel.class).list();
		tx.commit();
		session.close();
		return bookList;
	}
	public static List<RequestModel> getAllRequest() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<RequestModel> bookList=session.createCriteria(RequestModel.class).list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	public static List<ReturnModel> getAllReturn() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<ReturnModel> bookList=session.createCriteria(ReturnModel.class).list();
		tx.commit();
		session.close();
		return bookList;
	}
	public static List<LostModel> getAllLost() throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<LostModel> bookList=session.createCriteria(LostModel.class).list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	//��ȡ�û����н��ͼ��
	public static List<BorrowModel> getAllBook2(String user_name) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<BorrowModel> bookList=session.createQuery("from BorrowModel b where b.user_name = '"+user_name+"'").list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	//��ȡ�û�������
	public static List<RequestModel> getAllBook4(String user_name) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<RequestModel> bookList=session.createQuery("from RequestModel b where b.user_name = '"+user_name+"'").list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	//��ȡ�û�����Ԥ����ͼ��
	public static List<ReserveModel> getAllBook3(String user_name) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<ReserveModel> bookList=session.createQuery("from ReserveModel b where b.user_name = '"+user_name+"'").list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	//��ȡ�û�������
	public static List<ReturnModel> getAllBook5(String user_name) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<ReturnModel> bookList=session.createQuery("from ReturnModel b where b.user_name = '"+user_name+"'").list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	//����id��ȡ�ض���ͼ��
	public static BookModel getBook(Integer id) throws SQLException{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		BookModel model=session.get(BookModel.class, id);
		tx.commit();
		session.close();
		return model;
	}
	
	public static BookModel getBook3(Integer book_id) throws SQLException{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		BookModel model=(BookModel)session.createQuery("from BookModel b where b.id = '"+book_id+"'").uniqueResult();
		tx.commit();
		session.close();
		return model;
	}
	
	public static BorrowModel getBook2(Integer id) throws SQLException{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		BorrowModel model=session.get(BorrowModel.class, id);
		tx.commit();
		session.close();
		return model;
	}
	
	//����idɾ��ͼ����Ϣ
	public static void remove(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		BookModel bookModel=session.get(BookModel.class, id);
		session.delete(bookModel);
		tx.commit();
		session.close();
	}
	
	//����idɾ�����ͼ����Ϣ
	public static void remove2(Integer book_id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("delete from BorrowModel where book_id="+book_id+"").executeUpdate();
		tx.commit();
		session.close();
	}
	
	//����idɾ��Ԥ��ͼ����Ϣ
	public static void remove3(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		ReserveModel reserveModel=session.get(ReserveModel.class, id);
		session.delete(reserveModel);
		tx.commit();
		session.close();
	}
	
	//ɾ��request
	public static void remove4(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		RequestModel requestModel=session.get(RequestModel.class, id);
		session.delete(requestModel);
		tx.commit();
		session.close();
	}
	
	
	//�޸�ͼ������
	public static void update(BookModel model) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(model);
		tx.commit();
		session.close();
		
	}
	
	//��ȡ������ͼ�鼯��
	public static List<BookModel> getSearchBook(String search) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<BookModel> bookList=session.createQuery("from BookModel b where b. bookname like '%"+search+"%'").list();
		tx.commit();
		session.close();
		return bookList;
	}
	
	//���飬ͼ��������һ
	public static void reduce(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("update BookModel set remain=remain-1 where id="+id+"").executeUpdate();
		tx.commit();
		session.close();
		
	}
	public static void reduce2(Integer id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("update BorrowModel set remain=remain-1 where book_id="+id+"").executeUpdate();
		tx.commit();
		session.close();
		
	}
	
	//���飬ͼ��������һ
	public static void plus(Integer book_id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("update BookModel set remain=remain+1 where id= "+book_id+"").executeUpdate();	
		tx.commit();
		session.close();
	}
	public static void plus2(Integer book_id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("update ReserveModel set remain=remain+1 where book_id= "+book_id+"").executeUpdate();	
		tx.commit();
		session.close();
	}
	public static void plus3(Integer book_id) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.createQuery("update ReturnModel set remain=remain+1 where book_id= "+book_id+"").executeUpdate();	
		tx.commit();
		session.close();
	}
	
	public static List<BorrowModel> getborrow(String op_date) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<BorrowModel> List=session.createQuery("from BorrowModel b,where b.date >='"+op_date+"'").list();	
		tx.commit();
		session.close();
		return List;
	}

}
