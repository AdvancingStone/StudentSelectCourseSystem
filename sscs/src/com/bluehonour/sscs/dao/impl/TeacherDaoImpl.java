package com.bluehonour.sscs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluehonour.sscs.dao.TeacherDao;
import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.util.DBUtils;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public int save(Teacher teacher) {
		String sql = "insert into t_teacher(tname,password,phone,hiredate,remark)  values(?,?,?,?,?) ";
		Object[] params = {teacher.getTname(),teacher.getPassword(),teacher.getPhone(),teacher.getHiredate(),teacher.getRemark()};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public List<Teacher> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select * from t_teacher order by tno";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			while (rs.next()) {
				// 取出结果集当前行各个字段的值
				int tno = rs.getInt("tno");
				String tname = rs.getString("tname");
				String password = rs.getString("password");
				long phone = rs.getLong("phone");
				Date hiredate = rs.getDate("hiredate");
				String remark = rs.getString("remark");
				// 封装成对象
				Teacher teacher = new Teacher(tno,tname, password, phone, hiredate, remark);
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return list;
	}

	@Override
	public int delete(int tno) {
		String sql = "delete  from t_teacher where tno = ?";
		Object[] params = {tno };
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public Teacher findById(int tno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Teacher teacher = null;
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select * from t_teacher where tno = " + tno;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			if (rs.next()) {
				// 取出结果集当前行各个字段的值
				String tname = rs.getString("tname");
				String password = rs.getString("password");
				long phone = rs.getLong("phone");
				Date hiredate = rs.getDate("hiredate");
				String remark = rs.getString("remark");
				// 封装成对象
				teacher = new Teacher(tno, tname, password, phone, hiredate, remark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return teacher;
	}

	@Override
	public int update(Teacher teacher) {
		String sql = "update t_teacher set tname=?,password=?,phone=?,hiredate=?,remark=? where tno=?";
		Object[] params = {teacher.getTname(),teacher.getPassword(),teacher.getPhone(),teacher.getHiredate(),teacher.getRemark(),teacher.getTno()};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public List<Course> getAssumeCourse(int tno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Course course = null;
		List<Course> list = new ArrayList<>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select c.* from t_tc tc " + 
					"LEFT JOIN t_teacher t on t.tno = tc.tno " + 
					"LEFT JOIN t_course c on c.cno = tc.cno " + 
					"where tc.tno = " + tno ;
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
				course = new Course(cno,name, credit, periodstart, periodend);
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
