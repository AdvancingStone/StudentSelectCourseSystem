package com.bluehonour.sscs.service;

import java.util.List;

import com.bluehonour.sscs.entity.ClassInfo;
import com.bluehonour.sscs.entity.CriteriaStudent;
import com.bluehonour.sscs.entity.Student;

public interface StudentService {

	/**
	 * 添加学生
	 */
	public int add(Student stu);
	/**
	 * 查询所有学生
	 */
	public List<Student>findAll();
	/**
	 * 删除某学生
	 */
	public int delete(int sno);
	/**
	 * 根据ID查询某个学生
	 */
	public Student findById(int sno);
	/**
	 * 更新某学生
	 */
	public int update(Student stu);
	/**
	 * 学生登录
	 * @param userId
	 * @param password
	 * @return
	 */
	public Student login(String sno, String password);
	/**
	 * 得到所有班级信息
	 * @return
	 */
	public List<ClassInfo> getClassInfo();
	/**
	 * 多条件模糊查询学生
	 * @param student
	 * @return
	 */
	public List<Student> getForListWithCriteriaStudent(CriteriaStudent student);
}
