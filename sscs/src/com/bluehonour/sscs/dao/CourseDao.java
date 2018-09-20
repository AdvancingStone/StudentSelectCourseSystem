package com.bluehonour.sscs.dao;

import java.util.List;

import com.bluehonour.sscs.entity.Course;

public interface CourseDao {
	/**
	 * 添加课程
	 * @param cource
	 * @return
	 */
	public int save(Course cource);
	/**
	 * 获取所有课程信息
	 * @return
	 */
	public List<Course> findAll();
}
