package com.spring.archive;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBtest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/archive_prj";
	private static final String USER = "archive_prj";
	private static final String PWD = "archive_prj";
	
    @Test
    public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try(Connection conn = DriverManager.getConnection(URL, USER, PWD)) {
			System.out.println(conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
