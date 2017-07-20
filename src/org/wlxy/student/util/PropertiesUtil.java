package org.wlxy.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertiesUtil {
	//�½�һ�������ļ�����
	private static Properties properties=new Properties();
	//�½��ļ���·��
	private static String CONFIG="/cfg/jdbc.properties";
	// ��ȡ��Դ�ļ�������������
	private static InputStream is = PropertiesUtil.class.getResourceAsStream(CONFIG);
	//���ݿ�����
	public static String JDBC_DRIVER ;
	//���ݿ�URL
	public static String JDBC_URL ;
	//�����û���
	public static String JDBC_USERNAME ;
	//���ݿ�����
	public static String JDBC_PASSWORD;
	
	 static{
	     //����������
		 try {
			properties.load(is);
			  //��ȡ�����ļ��еľ�̬����
			 JDBC_DRIVER =properties.getProperty("jdbc.driver");
			 JDBC_URL =properties.getProperty("jdbc.url");
			 JDBC_USERNAME =properties.getProperty("jdbc.username");
			 JDBC_PASSWORD =properties.getProperty("jdbc.password");

		} catch (IOException e) {
			e.printStackTrace();
		} 
	 }
}
