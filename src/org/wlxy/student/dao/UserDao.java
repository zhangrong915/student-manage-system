package org.wlxy.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wlxy.student.model.User;
import org.wlxy.student.util.JDBCExecutor;

public class UserDao {

	public User login(User user){
		User resultUser=null;
		String sql="select * from t_user where userName='"+user.getUserName()+"' and password='"+user.getPassword()+"'";
		ResultSet rs=JDBCExecutor.getJDBCExecutor().executeQuery(sql); // Ö´ÐÐsql
		try {
			if(rs.next()){
				resultUser=new User();
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return resultUser;
	}
}
