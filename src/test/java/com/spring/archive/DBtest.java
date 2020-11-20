package com.spring.archive;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBtest {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE",
						"archive_prj",
						"archive_prj")){
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
