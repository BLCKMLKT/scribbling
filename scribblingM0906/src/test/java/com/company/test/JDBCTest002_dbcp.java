package com.company.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JDBCTest002_dbcp {
	@Autowired
	private DataSource ds;
	@Test
	public void testDataSource() throws Exception {
		try {
			Connection conn = ds.getConnection();
			if(conn!=null) { System.out.println(".............2 " + conn); }
		} catch(Exception e) { e.printStackTrace(); }
	}
}
