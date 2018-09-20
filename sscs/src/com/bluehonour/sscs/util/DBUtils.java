package com.bluehonour.sscs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluehonour.sscs.entity.Student;


public class DBUtils {
	/**
	 * 获取数据库的连接
	 */
	public static Connection getConnection() {
		
		Connection conn = ConnectPoolFactory.getInstance().getConnect();
		
//		Connection conn = null;
//		try {
//			ClassInfo.forName("org.logicalcobwebs.proxool.ProxoolDriver");
//			conn = DriverManager.getConnection("proxool.test");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return conn;
	}
	
	/**
	 * 关闭所有连接
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 完成DML操作: insert,update,delete
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			//和数据库建立连接
			conn = getConnection();
			//向数据库 发送命令并得到结果
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回数据
		return n;
	}
	
}
