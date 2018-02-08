package com.cos.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
public static Connection getConnection() {
	Connection conn =null;
	try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		System.out.println("DBCP 연결 정상");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
}

public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
	try {
		if(conn!=null) {conn.close();
		}
		if(pstmt!=null) {pstmt.close();
	    }
		if(rs!=null) {
			rs.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
