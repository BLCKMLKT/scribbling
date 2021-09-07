package com.company.dbmanager;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBManager {
	public static Connection conn;
	public DBManager() {}
	public Connection connection() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource db = (DataSource) envContext.lookup("jdbc/blckmlkt");
			conn = db.getConnection();
		} catch (Exception e) { e.printStackTrace(); }
		return conn;
	}
}
