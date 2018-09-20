package com.bluehonour.sscs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluehonour.sscs.dao.CourseDao;
import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.util.DBUtils;

public class CourseDaoImpl implements CourseDao{

	@Override
	public int save(Course course) {
		String sql = "insert into t_course (name,credit,periodstart,periodend)  values(?,?,?,?) ";
		Object[] params = {course.getName(), course.getCredit(), course.getPeriodstart(), course.getPeriodend()};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public List<Course> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<Course>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select * from t_course order by cno";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			while (rs.next()) {
				// 取出结果集当前行各个字段的值
				int cno = rs.getInt("cno");
				String name = rs.getString("name");
				int credit = rs.getInt("credit");
				Date periodstart = rs.getDate("periodstart");
				Date periodend = rs.getDate("periodend");
				// 封装成对象
				Course course = new Course(cno,name, credit, periodstart, periodend);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return list;
	}

}
