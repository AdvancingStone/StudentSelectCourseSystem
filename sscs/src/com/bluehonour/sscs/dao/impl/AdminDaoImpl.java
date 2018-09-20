package com.bluehonour.sscs.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bluehonour.sscs.dao.AdminDao;
import com.bluehonour.sscs.entity.Admin;
import com.bluehonour.sscs.util.DBUtils;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin find(String userId, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			//建立连接
			connection = DBUtils.getConnection();
			
			//向数据库发送sql命令并得到结果
			String sql = "select * from t_admin where userid = ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			
			//处理返回结果
			if(rs.next()) {
				//取出结果集当前行各个字段的值
				String userName = rs.getString("username");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date enterDate = rs.getDate("enterdate");
				String introduction = rs.getString("introduction");
				
				//封装成对象
				admin = new Admin(userId, userName, password, age, score, enterDate, introduction);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//关闭数据库资源
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return admin;
	}

	@Override
	public int save(Admin admin) {
		String sql = "insert into t_admin values(?,?,?,?,?,?,?)";
		Object[] params = {admin.getUserId(),admin.getUserName(),admin.getPassword(),admin.getAge(),
				admin.getScore(),admin.getIntroduction(),admin.getEnterDate()};
		return DBUtils.executeUpdate(sql, params);
	}

}
