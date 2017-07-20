package org.wlxy.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExecutor {
	
	//��ȡJDBC�������
	private static String JDBC_DRIVER = PropertiesUtil.JDBC_DRIVER;//�������
	private static String JDBC_URL = PropertiesUtil.JDBC_URL;//���URL
	private static String JDBC_USERNAME = PropertiesUtil.JDBC_USERNAME;//����û���
	private static String JDBC_PASSWORD = PropertiesUtil.JDBC_PASSWORD;//�������
	
	//�½����ݿ����Ӷ���
	private Connection connection ;
	//ά��һ���������
	private static JDBCExecutor jDBCExecutor = new JDBCExecutor();
	//�½����ݿ���������
	private static Statement  stmt ;
	
	
	//˽�й�����
	private JDBCExecutor(){
		//��ʼ��JDBC �������������ص�JVM
		try {
			Class.forName(JDBC_DRIVER);
			//�������ݿ�����
			connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
			//����statement����
			stmt = connection.createStatement();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//�ṩһ����̬�������ر����ʵ��	
	public static  JDBCExecutor getJDBCExecutor(){
		if(jDBCExecutor == null){
			//���������ά��jdbcExecutor����Ϊ��,�����˽�еĹ��������ʵ��
			jDBCExecutor= new JDBCExecutor();
		}	
		return  jDBCExecutor;
	}
	
	//ִ�в�ѯ��SQL����ȡ���ݼ�¼
	public ResultSet  executeQuery (String sql) {
		ResultSet result = null  ;
		//ִ�в�ѯ���;
		try {
			result  =  stmt.executeQuery(sql);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result ;
	}
	
	
	//ִ���޸Ĳ����ķ������޸����ݼ�¼
	public int executeUpdate(String sql){
		int result = -1 ;
		 try {
			 result =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//ִ������ɾ���ķ�����ɾ�����ݼ�¼
		public int executeDelete(String sql){
			int result = -1 ;
			try {
				result =stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return result ;
		}
	
	
	public static void main(String[] args) {
	  
		JDBCExecutor jDBCExecutor = new JDBCExecutor();
		
      //��������һ---���ݵĲ�ѯ
		int id =1;		//ͨ��ָ����SQL��ѯ�������
		ResultSet result =jDBCExecutor.executeQuery("select id  from t_user");
		//ͨ��������ѭ����ȡ������е�����				
		try {
			while(result.next()){
			id =result.getInt(1);
			System.out.println("User���е�IDֵ��"+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	  
//�������Զ�---���ݵ��޸�
	//ͨ��ָ����SQL��ѯ�������
//	int result =jDBCExecutor.executeUpdate("update  t_user set  user_name='root' where 1=1 ");
//	 System.out.println(result);
	  

//����������---���ݵ�ɾ��
	//ͨ��ָ����SQL��ѯ�������
//		int result =jDBCExecutor.executeDelete("delete from  t_user where id <10 ");
//		 System.out.println(result); 
//	}
	}
}
