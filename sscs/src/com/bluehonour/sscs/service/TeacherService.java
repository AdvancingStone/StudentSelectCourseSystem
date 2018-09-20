package com.bluehonour.sscs.service;

import java.util.List;

import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.StudentCourse;
import com.bluehonour.sscs.entity.Teacher;

public interface TeacherService {
	/**
	 * 添加老师
	 * @param teacher
	 * @return
	 */
	public int add(Teacher teacher);

	/**
	 * 查询所有教师
	 * @return
	 */
	public List<Teacher> findAll();
	/**
	 * 根据教师编号删除教师
	 * @param no
	 * @return
	 */
	public int delete(int tno);
	/**
	 * 根据教师编号查询教师
	 * @param no
	 * @return
	 */
	public Teacher findById(int tno);
	/**
	 * 更新教师
	 * @param teacher
	 * @return
	 */
	public int update(Teacher teacher);
	/**
	 * 老师查询选择他的课的学生和课程信息
	 * @param tno
	 * @return
	 */
	public List<StudentCourse> getSelectedStudentAndCourse(int tno);
	/**
	 * 对学生的课程进行评分
	 * @param sno
	 * @param cno
	 * @param tno
	 * @param score
	 * @return
	 */
	public int courseRemark(int sno, int cno, int tno, double score);
	/**
	 * 查询该老师的任课课程信息
	 * @param tno
	 * @return
	 */
	public List<Course> getAssumeCourse(int tno);
}
