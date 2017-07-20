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
		
		/*��ȡ�û���¼ʱ���������*/
		String userName=(String)request.getParameter("userName");
		String password=(String)request.getParameter("password");
		System.out.println(userName+"==============="+password);
		
		
		/*����һ�����ڲ�ѯ��user���󣬼��û��ĵ�¼���������*/
		User reqUser=new User();
		reqUser.setUserName(userName);
		reqUser.setPassword(password);
		
		
		/*ȥ���ݿ��в�ѯ�û��Ƿ��Ѿ�����*/
		userDao=new UserDao();
		/*����UserDao���е�login()����------sql���Ĳ�ѯ������ȥ���ݿ��в�ѯ�û��Ƿ��Ѿ����ڣ�*/
		User qryUer=userDao.login(reqUser);
		if(qryUer!=null)  //��¼�ɹ�
			request.getRequestDispatcher("/WEB-INF/success.html").forward(request, response);
		else  //��¼ʧ��
			response.sendRedirect("/WEB-INF/login.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
