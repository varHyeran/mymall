package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	public static Connection getConnection() throws Exception{
		System.out.println("DBHelper.getConnection()");
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF-8";
		String dbUser = "root";
		String dbPass = "java0000";
		Connection returnConnection = null;
		returnConnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(returnConnection + "<- returnConnection");
		return returnConnection;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(stmt != null) {
			try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(conn != null) {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
