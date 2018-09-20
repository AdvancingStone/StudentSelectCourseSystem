package com.bluehonour.sscs.dao;

import java.util.List;

import com.bluehonour.sscs.entity.ClassInfo;
import com.bluehonour.sscs.entity.CriteriaStudent;
import com.bluehonour.sscs.entity.Student;

public interface StudentDao {
	
	/**
	 * 添加学生
	 */
	public int save(Student stu);
	/**
	 * 查询所有学生信息
	 */
	public List<Student> findAll();
	/**
	 * 删除学生
	 */
	public int del(int sno);
	/**
	 * 根据学号查询学生
	 */
	public Student findById(int sno);
	/**
	 * 修改学生信息
	 */
	public int update(Student stu);
	/**
	 * 根据sno 和 password 查询指定的学生
	 * @param sno
	 * @param password
	 * @return
	 */
	public Student find(String sno, String password);
	/**
	 * 得到学生的所有班级信息
	 * @return
	 */
	public List<ClassInfo> getClassInfo();
	/**
	 * 多条件模糊查询学生列表
	 * @param student
	 * @return
	 */
	public List<Student> getForListWithCriteriaStudent(CriteriaStudent student);
}
