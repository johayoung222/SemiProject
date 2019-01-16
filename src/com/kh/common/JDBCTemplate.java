package com.kh.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *  Singletone패턴으로 다음 업무를 수행함.
 *  0. 드라이버 클래스 등록
 *  1. DB연결 : Connection객체 생성(url, user, password)
 *  2. 트랜잭션처리
 *  3. 연결 해제 : 자원반납
 *
 *	클래스에 대한 객체가 프로그램 구동내내 단 하나만 생성되어 작동되게함.
 *	- static자원 활용법
 */
public class JDBCTemplate {
	
	/*public static Connection getConnection() {
		Connection conn = null;
		//컨텍스트 객체 생성

		try {
			Context ctx = new InitialContext();
			DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");

			conn = pool.getConnection();
			conn.setAutoCommit(false);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}*/



	

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Properties prop = new Properties();
//			prop.load(new FileReader("resources/driver.properties"));
			String fileName = JDBCTemplate.class.getResource("/driver.properties").getPath();
			prop.load(new FileReader(fileName));
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			//0. driver등록
			Class.forName(driver);
			
			//1. Connection객체 생성
			conn = DriverManager.getConnection(url, user, password);
			//Java Application에서 트랜잭션을 제어하겠다.
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;

	}



	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed())
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset!=null && !rset.isClosed())
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
