package org.wlxy.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.junit.Test;


public class DBTestConnect {

	@Test
	public void TestInsert(){
		String DB_DRIVER=PropertiesUtil.JDBC_DRIVER;
		String DB_USERNAME=PropertiesUtil.JDBC_USERNAME;
		String DB_URL=PropertiesUtil.JDBC_URL;
		String DB_PASSWORD=PropertiesUtil.JDBC_PASSWORD;	
		
		Connection conn=null;
	
	    PreparedStatement pstmt = null;
	    
		try{
			Class.forName(DB_DRIVER);
			conn=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			
	        System.out.println("\n\n========== Success ===========\n\n");
	       
		}catch (Exception e) {
			System.out.println("\n\n========== Error ===========\n\n");
		}finally{
			 try {
				
			    conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		}
	}
}
