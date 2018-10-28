package com.niit.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
import com.niit.dao.JobDAO;
import com.niit.model.UserModel;
import com.niit.service.UserService;
import com.niit.supportclasses.GeneralSupport;
import com.sun.net.httpserver.HttpServer;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		String username=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String ident=request.getParameter("ident");
		String submt=request.getParameter("submit");
		
		//用户注册
		if(submt.equalsIgnoreCase("Sign Up")) {
			UserModel user=new UserModel(username,pass,email,phone,ident,FlagConstants.APPROVE,GeneralSupport.getDate());
			try {
				Integer flag=UserService.addUser(user);
				if(flag==MessageConstant.USER_ISNULL) {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.USER_CREATE_FAIL);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.REGISTERPAGE);
					rd.forward(request, response);
				}else if(flag==MessageConstant.USER_CREATE_SUCCESS) {
					UserService.emailToRegister(username);
					request.setAttribute(RequestAttribute.MSG, MessageConstant.USER_CREATE);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.LOGINPAGE);
					rd.forward(request, response);
				}else if(flag==MessageConstant.USER_CREATE_SAME) {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.USER_HAVE);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.REGISTERPAGE);
					rd.forward(request, response);
				}
				else {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.SOMETHING_WENT_WRONG);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.INDEXPAGE);
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//用户登入
		if(submt.equalsIgnoreCase(UrlConstant.LOGIN_BUTTON)) {
			UserModel user=new UserModel(username,pass);
			HttpSession session=request.getSession();
			
			try {
				Integer flag=UserService.login(user);
				System.out.println(flag);
				if(flag==MessageConstant.LOGIN_ADMIN) {
					session.setAttribute(RequestAttribute.LOGIN_SESSION, username);
					session.setAttribute(RequestAttribute.USER_SESSION, user);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.WELCOMEPAGE);
					rd.forward(request, response);
				}else if(flag==MessageConstant.LOGIN_SUCCESS) {
					session.setAttribute(RequestAttribute.LOGIN_SESSION, username);
					session.setAttribute(RequestAttribute.USER_SESSION, user);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.CHECKOUT);
					rd.forward(request, response);
				}else if(flag==MessageConstant.LOGIN_FAIL){
					request.setAttribute(RequestAttribute.MSG, MessageConstant.LOGIN_USER_FAIL);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.LOGINPAGE);
					rd.forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//管理员删除用户
		if(submt.equalsIgnoreCase(UrlConstant.DELETE_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				UserService.remove(id);
				response.sendRedirect(ViewConstant.WELCOMEPAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submt.equalsIgnoreCase(UrlConstant.BLOCK_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				UserService.block(id);
				response.sendRedirect(ViewConstant.WELCOMEPAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submt.equalsIgnoreCase(UrlConstant.ACTIVE_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				UserService.active(id);
				response.sendRedirect(ViewConstant.WELCOMEPAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//管理员编辑用户
		if(submt.equalsIgnoreCase(UrlConstant.EDIT_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				UserModel model=UserService.getUser(id);
				request.setAttribute(RequestAttribute.USER_DATE, model);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.REGISTERPAGE);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		//管理员更新用户信息
		if(submt.equalsIgnoreCase(UrlConstant.UPDATE_BUTTON)) {
			int id=Integer.parseInt(request.getParameter("id"));
			String date=request.getParameter("date");
			int flag=Integer.parseInt(request.getParameter("flag"));
			UserModel model=new UserModel(id,username,pass,email,phone,ident);
			model.setDate(date);
			model.setFlag(flag);
			try {
				UserService.update(model);
				response.sendRedirect(ViewConstant.WELCOMEPAGE);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		
		//用户重新设置密码
		if(submt.equalsIgnoreCase("Reset"))
		{
			try {
				UserService.reset(username, pass);
				request.setAttribute(RequestAttribute.MSG, MessageConstant.RESET_SUCCESS);
				RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.LOGINPAGE);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}

}
