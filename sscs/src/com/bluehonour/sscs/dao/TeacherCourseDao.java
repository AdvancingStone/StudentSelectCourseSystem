package com.bluehonour.sscs.dao;

import java.util.List;

import com.bluehonour.sscs.entity.Course;

public interface TeacherCourseDao {
	/**
	 * 保存课程编号和教师编号到中间表t_tc
	 * @param cno
	 * @param tno
	 * @return
	 */
	public int save(int cno,int tno);
	/**
	 * 查询所有老师已经分配的课程信息
	 * @return
	 */
	public List<Course> findAll();
	/**
	 * 取消分配给老师的课程
	 * @param cno
	 * @param tno
	 * @return
	 */
	public int delete(int cno, int tno);
}
