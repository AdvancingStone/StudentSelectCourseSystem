package com.bluehonour.sscs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluehonour.sscs.dao.StudentCourseTeacherDao;
import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.StudentCourse;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.util.DBUtils;

public class StudentCourseTeacherDaoImpl implements StudentCourseTeacherDao {

	@Override
	public int save(int sno, int cno, int tno) {
		String sql = "insert into t_sc(sno,cno,tno) values(?,?,?)";
		Object[] params = {sno,cno,tno};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public List<Course> findSelectedCourse(int sno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<Course>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select * from t_course c"
					+ " join t_sc sc"
					+ " on (c.cno = sc.cno)"
					+ " join t_teacher t"
					+ " on (sc.tno = t.tno)"
					+ " where sno = " + sno;
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

	@Override
	public List<Course> findSelectableCourse(int sno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<Course>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "SELECT c.*, t.* FROM	t_tc a "
					+ "LEFT JOIN t_course c "
					+ "ON a.cno = c.cno "
					+ "LEFT JOIN t_teacher t "
					+ "ON a.tno = t.tno "
					+ "WHERE (a.cno, a.tno) NOT IN "
					+ "( SELECT	cno,tno "
					+ "FROM	t_sc "
					+ "WHERE sno = "
					+ sno
					+") ";
					
			
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

	@Override
	public int removeStudentDistributedCourse(int sno, int cno, int tno) {
		String sql = "delete from t_sc where sno = ? and cno = ? and tno = ?";
		Object[] params = {sno,cno,tno};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public List<StudentCourse> getSelectedStudentAndCourse(int tno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "SELECT" + 
					"	s.sno," + 
					"	s.sname," + 
					"	s.classno," + 
					"	clazz.cname," + 
					"	c.cno," + 
					"	c. NAME," + 
					"	c.credit," + 
					"	sc.score" + 
					" FROM" + 
					"	t_student s" + 
					" LEFT JOIN t_class clazz ON clazz.classno = s.classno" + 
					" LEFT JOIN t_sc sc ON sc.sno = s.sno" + 
					" LEFT JOIN t_course c ON c.cno = sc.cno" + 
					" WHERE" + 
					"	sc.tno = " + tno +
					" ORDER BY" + 
					"	c.cno," + 
					"	s.sno";
					
			
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String name = rs.getString("name");
				int credit = rs.getInt("credit");
				int sno = rs.getInt("sno");
				int classno = rs.getInt("classno");
				String sname = rs.getString("sname");
				String cname = rs.getString("cname");
				double score = rs.getDouble("score");
				//封装成教师对象
				StudentCourse sc = new StudentCourse(sno, sname, classno, cname, cno, name, credit, score);
				list.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return list;
	}

	@Override
	public int courseRemark(int sno, int cno, int tno, double score) {
		String sql = "update t_sc set score = ? where sno = ? and cno = ? and tno = ?";
		Object[] params = {score,sno,cno,tno};
		return DBUtils.executeUpdate(sql, params);
	}

}
