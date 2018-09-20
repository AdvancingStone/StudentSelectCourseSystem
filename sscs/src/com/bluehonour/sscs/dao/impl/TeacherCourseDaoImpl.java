package com.bluehonour.sscs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluehonour.sscs.dao.TeacherCourseDao;
import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.util.DBUtils;

public class TeacherCourseDaoImpl implements TeacherCourseDao {

	@Override
	public int save(int cno, int tno) {
		String sql = "insert into t_tc values(?,?)";
		Object[] params = {cno,tno};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public int delete(int cno, int tno) {
		String sql = "delete from t_tc where cno = ? and tno = ?";
		Object[] params = {cno,tno};
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
			String sql = "select * from t_course c"
					+ " join t_tc tc"
					+ " on (c.cno = tc.cno)"
					+ " join t_teacher t"
					+ " on (tc.tno = t.tno)"
					+ " order by c.cno";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			while (rs.next()) {
				// 取出结果集当前行课程各个字段的值
				int cno = rs.getInt("cno");
				String name = rs.getString("name");
				int credit = rs.getInt("credit");
				Date periodstart = rs.getDate("periodstart");
				Date periodend = rs.getDate("periodend");
				// 封装成课程对象
				Course course = new Course(cno,name, credit, periodstart, periodend);
				//取出结果集中教师各个字段的值
				int tno = rs.getInt("tno");
				String tname = rs.getString("tname");
				String password = rs.getString("password");
				long phone = rs.getLong("phone");
				Date hiredate = rs.getDate("hiredate");
				String remark = rs.getString("remark");
				//封装成教师对象
				Teacher teacher = new Teacher(tno,tname, password, phone, hiredate, remark);
				
				//将教师加入课程
				course.setTeacher(teacher);
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
