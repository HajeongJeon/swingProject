package com.pknu.room.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url 	 = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbUid  = "myjava";
	private static String dbPwd  = "1234";
	
	private static Connection conn;
	
	private DBConn() {
	}
	public static Connection getInstance() {
		return getConnection();
	}
	
	public static Connection getConnection() {
		if(conn != null)
			return conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbUid, dbPwd);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 문제" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오라클 연결 문제" + e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}
	
}
