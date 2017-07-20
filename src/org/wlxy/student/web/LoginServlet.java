package org.wlxy.student.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wlxy.student.dao.UserDao;
import org.wlxy.student.model.User;

 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao=null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*获取用户登录时输入的数据*/
		String userName=(String)request.getParameter("userName");
		String password=(String)request.getParameter("password");
		System.out.println(userName+"==============="+password);
		
		
		/*构建一个用于查询的user对象，即用户的登录输入的数据*/
		User reqUser=new User();
		reqUser.setUserName(userName);
		reqUser.setPassword(password);
		
		
		/*去数据库中查询用户是否已经存在*/
		userDao=new UserDao();
		/*调用UserDao类中的login()方法------sql语句的查询（即：去数据库中查询用户是否已经存在）*/
		User qryUer=userDao.login(reqUser);
		if(qryUer!=null)  //登录成功
			request.getRequestDispatcher("/WEB-INF/success.html").forward(request, response);
		else  //登录失败
			response.sendRedirect("/WEB-INF/login.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
