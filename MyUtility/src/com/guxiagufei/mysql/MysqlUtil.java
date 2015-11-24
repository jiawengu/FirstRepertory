package com.guxiagufei.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MysqlUtil {
	/**
	 * @param url, user, password 
	 * Get a database Connection.
	 * @return Connection
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnect(String url, String user, String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}
}
