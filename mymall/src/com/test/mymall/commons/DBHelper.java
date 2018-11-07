package com.test.mymall.commons;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {
	public static SqlSession getSqlSession() {
		 InputStream inputStream = null;
		 try {
			  String resource = "mybatis-config.xml";
			  inputStream = Resources.getResourceAsStream(resource);
		 } catch (IOException e) {
			  e.printStackTrace();
		 }
		 
		 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		 SqlSession sqlSession = sqlSessionFactory.openSession();

		 return sqlSession;
	}
	
/*	public static Connection getConnection() throws Exception{
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
	}*/
}