package com.bluehonour.sscs.service;

import java.util.List;

import com.bluehonour.sscs.entity.Course;

public interface CourseService {

	/**
	 * 添加课程
	 * @param cource
	 * @return
	 */
	public int add(Course cource);
	/**
	 * 查询所有课程信息
	 * @return
	 */
	public List<Course> findAll();
	/**
	 * 给老师分配课程
	 * @param cno
	 * @param sno
	 * @return
	 */
	public int distributeCourse(int cno, int tno);
	/**
	 * 查询所有已经给老师分配的课程信息
	 * @return
	 */
	public List<Course> findDistributedCourse();
	/**
	 * 取消课程分配
	 * @param cno
	 * @param tno
	 * @return
	 */
	public int removeDistributedCourse(int cno, int tno);
	/**
	 * 选择一门或者多门课程
	 * @param ctnoArr
	 * @param sno
	 */
	public void selectCourse(String[] ctnoArr, int sno);
	/**
	 * 查看该学生已选择的课程
	 * @param sno
	 * @return
	 */
	public List<Course> getSelectedCourse(int sno);
	/**
	 * 获取当前学生可以选择的课程，不包括已经选择的课程
	 * @param sno
	 * @return
	 */
	public List<Course> findSelectableCourse(int sno);
	/**
	 * 取消某个学生的选课信息
	 * @param sno
	 * @param cno
	 * @param tno
	 * @return
	 */
	public int removeStudentDistributedCourse(int sno, int cno, int tno);
}
