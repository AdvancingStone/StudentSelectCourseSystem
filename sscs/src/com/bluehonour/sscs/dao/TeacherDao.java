package com.bluehonour.sscs.dao;

import java.util.List;

import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.Teacher;

public interface TeacherDao {
	/**
	 * 添加老师
	 * @param teacher
	 * @return
	 */
	public int save(Teacher teacher);
	/**
	 * 查询所有老师
	 * @return
	 */
	public List<Teacher> findAll();
	/**
	 * 根据教师编号删除该教师
	 * @param tno
	 * @return
	 */
	public int delete(int tno);
	/**
	 * 根据教师编号查询该教师
	 * @param tno
	 * @return
	 */
	public Teacher findById(int tno);
	/**
	 * 更新某教师
	 * @param teacher
	 * @return
	 */
	public int update(Teacher teacher);
	/**
	 * 查询老师的任课课程信息
	 * @param tno
	 * @return
	 */
	public List<Course> getAssumeCourse(int tno);

}
