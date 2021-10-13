package com.company.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JDBCTest001_jdbc {
	@Test
	public void testConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/portfolio001?useSSL=false", 
				   user = "root", pass = "1234";
			Connection conn = DriverManager.getConnection(url, user, pass);
			if(conn!=null) { System.out.println("............1 " + conn); }
		} catch(Exception e) { e.printStackTrace(); }
	}
}
