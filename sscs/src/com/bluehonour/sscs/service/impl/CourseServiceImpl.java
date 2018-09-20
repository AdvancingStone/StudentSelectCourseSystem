package com.bluehonour.sscs.service.impl;

import java.util.List;

import com.bluehonour.sscs.dao.CourseDao;
import com.bluehonour.sscs.dao.StudentCourseTeacherDao;
import com.bluehonour.sscs.dao.TeacherCourseDao;
import com.bluehonour.sscs.dao.impl.CourseDaoImpl;
import com.bluehonour.sscs.dao.impl.StudentCourseTeacherDaoImpl;
import com.bluehonour.sscs.dao.impl.TeacherCourseDaoImpl;
import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.service.CourseService;

public class CourseServiceImpl implements CourseService{

	private CourseDao courceDao = new CourseDaoImpl();
	private TeacherCourseDao teacherCourseDao = new TeacherCourseDaoImpl();
	private StudentCourseTeacherDao sctDao = new StudentCourseTeacherDaoImpl();
	@Override
	public int add(Course cource) {
		return this.courceDao.save(cource);
	}

	@Override
	public List<Course> findAll() {
		return this.courceDao.findAll();
	}

	@Override
	public int distributeCourse(int cno, int tno) {
		return teacherCourseDao.save(cno, tno);
	}

	@Override
	public List<Course> findDistributedCourse() {
		return this.teacherCourseDao.findAll();
	}

	@Override
	public int removeDistributedCourse(int cno, int tno) {
		return teacherCourseDao.delete(cno,tno);
	}

	@Override
	public void selectCourse(String[] ctnoArr, int sno) {
		for(int i=0; i<ctnoArr.length; i++) {
			String ctno = ctnoArr[i];
			String[] arr = ctno.split("#");
			int cno = Integer.parseInt(arr[0]);
			int tno = Integer.parseInt(arr[1]);
			
			this.sctDao.save(sno, cno, tno);
		}
	}

	@Override
	public List<Course> getSelectedCourse(int sno) {
		return this.sctDao.findSelectedCourse(sno);
	}

	@Override
	public List<Course> findSelectableCourse(int sno) {
		return this.sctDao.findSelectableCourse(sno);
	}

	@Override
	public int removeStudentDistributedCourse(int sno, int cno, int tno) {
		return sctDao.removeStudentDistributedCourse(sno,cno,tno);
	}

}
