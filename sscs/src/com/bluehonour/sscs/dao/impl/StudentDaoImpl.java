package com.bluehonour.sscs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bluehonour.sscs.dao.StudentDao;
import com.bluehonour.sscs.entity.ClassInfo;
import com.bluehonour.sscs.entity.CriteriaStudent;
import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.util.DBUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int save(Student stu) {
		String sql = "insert into t_student(password,sname,phone,sex,birthday,classno,remark) values(?,?,?,?,?,?,?)";
		Object[] params = { stu.getPassword(), stu.getSname(), stu.getPhone(), stu.getSex(), stu.getBirthday(),
				stu.getClassno(), stu.getRemark() };
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Student student = null;
		List<Student> stuList = new ArrayList<Student>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select * from t_student";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			while (rs.next()) {
				// 取出结果集当前行各个字段的值
				int sno = rs.getInt("sno");
				String password = rs.getString("password");
				String sname = rs.getString("sname");
				long phone = rs.getLong("phone");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				int classno = rs.getInt("classno");
				String remark = rs.getString("remark");
				// 封装成对象
				student = new Student(sno,password, sname, phone, sex, birthday, classno, remark);
				stuList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return stuList;
	}

	@Override
	public int del(int sno) {
		String sql = "delete  from t_student where sno = ?";
		Object[] params = {sno };
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public Student findById(int sno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Student student = null;
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			// 向数据库发送sql命令并得到结果
			String sql = "select * from t_student where sno = " + sno;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			if (rs.next()) {
				// 取出结果集当前行各个字段的值
				String password = rs.getString("password");
				String sname = rs.getString("sname");
				long phone = rs.getLong("phone");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				int classno = rs.getInt("classno");
				String remark = rs.getString("remark");
				// 封装成对象
				student = new Student(sno,password, sname, phone, sex, birthday, classno, remark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return student;
	}

	@Override
	public int update(Student stu) {
		String sql = "update t_student set sname=?,password=?,phone=?,birthday=?,sex=?,classno=?,remark=? where sno=?";
		Object[] params = { stu.getSname(),stu.getPassword(),stu.getPhone(),stu.getBirthday(),stu.getSex(),stu.getClassno(),
				 stu.getRemark(),stu.getSno() };
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public Student find(String sno, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Student student = null;
		try {
			//建立连接
			connection = DBUtils.getConnection();
			
			//向数据库发送sql命令并得到结果
			String sql = "select * from t_student where sno = ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sno);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			
			//处理返回结果
			if(rs.next()) {
				//取出结果集当前行各个字段的值
				String sname = rs.getString("sname");
				long phone = rs.getLong("phone");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				int classno = rs.getInt("classno");
				String remark = rs.getString("remark");
				
				//封装成对象
				student = new Student(Integer.parseInt(sno), password, sname, phone, sex, birthday, classno, remark);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//关闭数据库资源
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return student;
	}

	@Override
	public List<ClassInfo> getClassInfo() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ClassInfo clazz = null;
		List<ClassInfo> list = new ArrayList<ClassInfo>();
		try {
			//建立连接
			connection = DBUtils.getConnection();
			
			//向数据库发送sql命令并得到结果
			String sql = "select * from t_class";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			//处理返回结果
			while(rs.next()) {
				//取出结果集当前行各个字段的值
				int classno = rs.getInt("classno");
				String cname = rs.getString("cname");
				String cteacher = rs.getString("cteacher");
				String classroom = rs.getString("classroom");
				//封装成对象
				clazz = new ClassInfo(classno, cname, cteacher, classroom);
				list.add(clazz);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//关闭数据库资源
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return list;
	}

	@Override
	public List<Student> getForListWithCriteriaStudent(CriteriaStudent student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Student> stuList = new ArrayList<Student>();
		try {
			// 建立连接
			connection = DBUtils.getConnection();
			
			
			
			// 向数据库发送sql命令并得到结果
			StringBuffer sql = new StringBuffer();
			sql.append("select * from t_student");
			if(!student.getSno().equals("")) {
				sql.append(" and sno like '%"+ student.getSno()  +"%'");
			}
			if(!student.getSname().equals("")) {
				sql.append(" and sname like '%"+ student.getSname() +"%'");
			}
			if(!student.getSex().equals("")) {
				sql.append(" and sex ='"+ student.getSex() +"'");
			}
			if(!student.getClassno().equals("")) {
				sql.append(" and classno like '%"+ student.getClassno() +"%'");
			}
			if(!student.getRemark().equals("")) {
				sql.append(" and remark='"+ student.getRemark() +"'");
			}
			String SQL = sql.toString();
			SQL = SQL.replaceFirst("and", "where");
			System.out.println(SQL);
			preparedStatement = connection.prepareStatement(SQL);
			rs = preparedStatement.executeQuery();
			// 处理返回结果
			while (rs.next()) {
				// 取出结果集当前行各个字段的值
				int sno = rs.getInt("sno");
				String password = rs.getString("password");
				String sname = rs.getString("sname");
				long phone = rs.getLong("phone");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				int classno = rs.getInt("classno");
				String remark = rs.getString("remark");
				// 封装成对象
				Student stu = new Student(sno,password, sname, phone, sex, birthday, classno, remark);
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, preparedStatement, connection);
		}
		return stuList;
	}

}
