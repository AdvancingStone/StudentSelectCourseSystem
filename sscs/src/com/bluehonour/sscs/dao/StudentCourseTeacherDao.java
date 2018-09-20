package com.bluehonour.sscs.dao;

import java.util.List;

import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.StudentCourse;
import com.bluehonour.sscs.entity.Teacher;

public interface StudentCourseTeacherDao {
	/**
	 * 增加一条学生选课记录
	 * @param sno
	 * @param cno
	 * @param tno
	 * @return
	 */
	public int save(int sno,int cno,int tno);
	/**
	 * 查看指定学生已经选择的课程
	 * @param sno
	 * @return
	 */
	public List<Course> findSelectedCourse(int sno);
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
	public int  courseRemark(int sno, int cno, int tno, double score);
}
