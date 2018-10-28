package com.niit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.constants.FlagConstants;
import com.niit.constants.MessageConstant;
import com.niit.constants.RequestAttribute;
import com.niit.constants.UrlConstant;
import com.niit.constants.ViewConstant;
import com.niit.model.BookModel;
import com.niit.model.BorrowModel;
import com.niit.model.LostModel;
import com.niit.model.RequestModel;
import com.niit.model.ReserveModel;
import com.niit.model.ReturnModel;
import com.niit.service.BookService;
import com.niit.supportclasses.BetweenDays;
import com.niit.supportclasses.GeneralSupport;
import com.niit.supportclasses.StringToDate;


/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname=request.getParameter("bookname");
		String img=request.getParameter("img");
		String author=request.getParameter("author");
		String press=request.getParameter("press");
		String describe=request.getParameter("describe");
	    String remain=request.getParameter("remain");
	    String price=request.getParameter("price");
	    String cat=request.getParameter("category");
		String submt=request.getParameter("submit");
		String searchbook=request.getParameter("search");
		
		//����Ա����ͼ��
		if(submt.equalsIgnoreCase("ADD")) {
			BookModel book=new BookModel(bookname,img,author,press,describe,remain,price,cat,GeneralSupport.getDate(),FlagConstants.APPROVE);
			try {
				Integer flag=BookService.addBook(book);
				if(flag==MessageConstant.BOOK_ISNULL) {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.BOOK_CREATE_FAIL);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.INDEXPAGE);
					rd.forward(request, response);
				}else if(flag==MessageConstant.BOOK_CREATE_SUCCESS) {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.BOOK_CREATE);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
					rd.forward(request, response);
				}else {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.SOMETHING_WENT_WRONG);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.INDEXPAGE);
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//����Աɾ��ͼ��
		if(submt.equalsIgnoreCase(UrlConstant.DELETE_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				BookService.remove(id);
				response.sendRedirect(ViewConstant.WELCOMEPAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//����Ա�༭ͼ��
		if(submt.equalsIgnoreCase(UrlConstant.EDIT_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				BookModel model=BookService.getBook(id);
				request.setAttribute(RequestAttribute.BOOK_DATA, model);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.ADDPAGE);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		//����Ա����ͼ��
		if(submt.equalsIgnoreCase(UrlConstant.UPDATE_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			String date=request.getParameter("date");
			BookModel model=new BookModel(id,bookname,img,author,press,describe,remain,price,cat);
			model.setDate(date);
			
			try {
				BookService.update(model);
				response.sendRedirect(ViewConstant.WELCOMEPAGE);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}
		
		
		//�û�����ͼ��
		if(submt.equalsIgnoreCase("Search")) {
			try {
				BookService.getSearchBook(searchbook);
				request.setAttribute(RequestAttribute.SEARCH_SESSION, searchbook);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.SEARCHPAGE);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
		
		
		String user_name=(String)request.getSession().getAttribute(RequestAttribute.LOGIN_SESSION);
		//�û�����
		if(submt.equals("Borrow")) {
			if(user_name==null) {
				request.setAttribute(RequestAttribute.MSG, MessageConstant.LOGIN_NULL);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.LOGINPAGE);
				rd.forward(request, response);
			}
			else {
			int book_id=Integer.parseInt(request.getParameter("id"));
			String op="borrow";
			RequestModel requestmg=new RequestModel(user_name,bookname,img,author,remain,GeneralSupport.getDate(),op,book_id);
			
			try {
				    BookService.BorrowemailTo(user_name,bookname);
					BookService.addBook4(requestmg);
					request.setAttribute(RequestAttribute.MSG, MessageConstant.DEALWITH);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WAITFOR);
					rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}catch(Exception e) {
				
			}
			}
		}
		
		if(submt.equals("Book Lost")) {
			int id=Integer.parseInt(request.getParameter("id"));
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			LostModel lost=new LostModel(bookname,img,author, remain,GeneralSupport.getDate(),book_id,user_name);
			
			try {
					BookService.addBook6(lost);
					request.getSession().setAttribute(RequestAttribute.ID_SESSION, id);
					request.getSession().setAttribute(RequestAttribute.ID2_SESSION, book_id);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.LOSTPAYMENT);
					rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}catch(Exception e) {
				
			}
			
		}
		
		
		//�û�Ԥ����
		if(submt.equalsIgnoreCase("Reserve")) {
			if(user_name==null) {
				request.setAttribute(RequestAttribute.MSG, MessageConstant.LOGIN_NULL);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.LOGINPAGE);
				rd.forward(request, response);
			}else {
				
				int book_id=Integer.parseInt(request.getParameter("id"));
				String op="reserve";
				RequestModel requestmg=new RequestModel(user_name,bookname,img,author,remain,GeneralSupport.getDate(),op,book_id);
				try {
					BookService.ReserveemailTo(user_name,bookname);
					BookService.addBook4(requestmg);
					request.setAttribute(RequestAttribute.MSG, MessageConstant.DEALWITH);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WAITFOR);
					rd.forward(request, response);
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (Exception e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
			
		}
		
		//�û���Ԥ��������н���
		if(submt.equals("BORROW")) {
			
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			int id=Integer.parseInt(request.getParameter("id"));
			String op="borrow";
			RequestModel requestmg=new RequestModel(user_name,bookname,img,author,remain,GeneralSupport.getDate(),op,book_id);
			try {
				    BookService.BorrowemailTo(user_name,bookname);
					BookService.addBook4(requestmg);
					BookService.remove3(id);
					request.setAttribute(RequestAttribute.MSG, MessageConstant.DEALWITH);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WAITFOR);
					rd.forward(request, response);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}catch(Exception e) {
				
			}
			}
		
		
		//�û����飬�����⳥
		if(submt.equalsIgnoreCase("Return")) {
			int id=Integer.parseInt(request.getParameter("id"));
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			String op="return";
			RequestModel requestmg=new RequestModel(user_name,bookname,img,author,remain,GeneralSupport.getDate(),op,book_id);
			
			String borrow_date=request.getParameter("date");
			Date borrowdate=StringToDate.StringtoDate(borrow_date);
				
			    Date return_date=new Date();
				Calendar cal=Calendar.getInstance();
				cal.setTime(return_date);
				cal.add(Calendar.DAY_OF_MONTH, -7);
				Date before7=cal.getTime();
				if(before7.getTime() < borrowdate.getTime())
				{
					try {
						BookService.ReturnemailTo(user_name, bookname);
						BookService.addBook4(requestmg);
						request.setAttribute(RequestAttribute.MSG, MessageConstant.DEALWITH);
						RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WAITFOR);
						rd.forward(request, response);
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					} catch (Exception e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				else {
					int days=BetweenDays.days(borrowdate, before7);
					float pay=(float)BetweenDays.days(borrowdate, before7)/10;
					request.setAttribute(RequestAttribute.DAY_SESSION,days);
					request.setAttribute(RequestAttribute.PAY_SESSION,pay);
					request.getSession().setAttribute(RequestAttribute.ID_SESSION, id);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.PAYMENTPAGE);
					rd.forward(request, response);
				}
				
		}
		
		
		//�û��⳥֮����
		if(submt.equalsIgnoreCase("Payment Completion")) {
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			String op="late return";
			RequestModel requestmg=new RequestModel(user_name,bookname,img,author,remain,GeneralSupport.getDate(),op,book_id);
			try {
				BookService.ReturnemailTo(user_name, bookname);
				BookService.addBook4(requestmg);
				request.setAttribute(RequestAttribute.MSG, MessageConstant.DEALWITH);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WAITFOR);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		if(submt.equalsIgnoreCase("Completion")) {
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			String op="book lost";
			RequestModel requestmg=new RequestModel(user_name,bookname,img,author,remain,GeneralSupport.getDate(),op,book_id);
			try {
				BookService.ReturnemailTo(user_name, bookname);
				BookService.addBook4(requestmg);
				request.setAttribute(RequestAttribute.MSG, MessageConstant.DEALWITH);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WAITFOR);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		//����Աͬ��
		   if(submt.equalsIgnoreCase("Agree")) {
				String operation=request.getParameter("operation");
				//����ɹ�
				if(operation.equals("borrow")) {
					
					int book_id=Integer.parseInt(request.getParameter("book_id"));
					int id=Integer.parseInt(request.getParameter("id"));
					String username=request.getParameter("user_name");
					Date borrow_date=new Date();
					Calendar cal=Calendar.getInstance();
					cal.setTime(borrow_date);
					cal.add(Calendar.SECOND,60);
					Date latest_date=cal.getTime();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					String latest_time=df.format(latest_date).toString();
					String date=df.format(borrow_date).toString();
					BorrowModel borrow=new BorrowModel(bookname,img,author,remain,date,book_id,username,latest_time);
					try {
						    BookService.BorrowSuccess(username, bookname);
							BookService.addBook2(borrow);
							BookService.reduce(book_id);
							BookService.reduce2(book_id);
							BookService.remove4(id);
							BookService.ReturnBookEmail(latest_date);
							request.setAttribute(RequestAttribute.MSG, MessageConstant.OP_SUCCESS);
							RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
							rd.forward(request, response);
						
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}catch(Exception e) {
						
					}
				}
				
				//Ԥ����ɹ�
				if(operation.equals("reserve")) {
					int book_id=Integer.parseInt(request.getParameter("book_id"));
					int id=Integer.parseInt(request.getParameter("id"));
					String username=request.getParameter("user_name");
					ReserveModel reserve=new ReserveModel(bookname,img,author,remain,GeneralSupport.getDate(),book_id,username);
					try {
						    
							BookService.addBook3(reserve);
							BookService.remove4(id);
							BookService.ReserveSuccess(username, bookname);
							request.setAttribute(RequestAttribute.MSG, MessageConstant.OP_SUCCESS);
							RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
							rd.forward(request, response);
						
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}catch(Exception e) {
						
					}
				}
				
				//����ɹ�
				if(operation.equals("return")) {
					int book_id=Integer.parseInt(request.getParameter("book_id"));
					int id=Integer.parseInt(request.getParameter("id"));
					String username=request.getParameter("user_name");
					String op="return";
					ReturnModel rm=new ReturnModel(bookname,img,author,remain,GeneralSupport.getDate(),book_id,username,op);
					try {
						    
							BookService.addBook5(rm);
							BookService.plus(book_id);
							BookService.plus2(book_id);
							BookService.plus3(book_id);
							BookService.remove2(book_id);
							BookService.remove4(id);
							BookService.ReturnSuccess(username, bookname);
							request.setAttribute(RequestAttribute.MSG, MessageConstant.OP_SUCCESS);
							RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
							rd.forward(request, response);
						
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}catch(Exception e) {
						
					}
				}
				
				if(operation.equals("late return")) {
					int book_id=Integer.parseInt(request.getParameter("book_id"));
					int id=Integer.parseInt(request.getParameter("id"));
					String username=request.getParameter("user_name");
					String op="late return";
					ReturnModel rm=new ReturnModel(bookname,img,author,remain,GeneralSupport.getDate(),book_id,username,op);
					try {
						    
							BookService.addBook5(rm);
							BookService.plus(book_id);
							BookService.plus2(book_id);
							BookService.plus3(book_id);
							BookService.remove2(book_id);
							BookService.remove4(id);
							BookService.ReturnSuccess(username, bookname);
							request.setAttribute(RequestAttribute.MSG, MessageConstant.OP_SUCCESS);
							RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
							rd.forward(request, response);
						
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}catch(Exception e) {
						
					}
				}
				
				}
		   
		   
		   if(submt.equalsIgnoreCase("Refuse")) {
			   int id=Integer.parseInt(request.getParameter("id"));
			   String op=request.getParameter("operation");
			   String username=request.getParameter("user_name");
			   try {
				BookService.remove4(id);
				BookService.RefuseEmali(username, bookname, op);
				request.setAttribute(RequestAttribute.MSG, MessageConstant.OP_SUCCESS);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			   
		   }
		   
		   
		   
		   /*if(submt.equalsIgnoreCase("submit"))
		   {
			   HttpSession session=request.getSession();
			   String ident=request.getParameter("user_select");
			   String op_date=request.getParameter("op_date");
			   System.out.println(ident);
			   System.out.println(op_date);
			   
			   
			   
			   if(ident.equalsIgnoreCase("Admin")) {
				session.setAttribute(RequestAttribute.DATE_SESSION, op_date);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
				rd.forward(request, response);
					   
				   
			   }
			   else if(ident.equalsIgnoreCase("Student")) {
				   
				    session.setAttribute(RequestAttribute.DATE_SESSION, op_date);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
					rd.forward(request, response);
			   }
			  
		   }*/
		   
		   
		   if(submt.equalsIgnoreCase("ok")) {
			   HttpSession session=request.getSession();
			   String news=request.getParameter("news");
			   session.setAttribute(RequestAttribute.NEWS_SESSION, news);
			 RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
				rd.forward(request, response);
		   }
	}
	
	
	
	

}
