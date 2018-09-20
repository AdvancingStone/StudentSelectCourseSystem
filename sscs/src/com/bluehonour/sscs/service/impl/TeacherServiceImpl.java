package com.bluehonour.sscs.service.impl;

import java.util.List;

import com.bluehonour.sscs.dao.StudentCourseTeacherDao;
import com.bluehonour.sscs.dao.TeacherDao;
import com.bluehonour.sscs.dao.impl.StudentCourseTeacherDaoImpl;
import com.bluehonour.sscs.dao.impl.TeacherDaoImpl;
import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.StudentCourse;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao = new TeacherDaoImpl();
	private StudentCourseTeacherDao sctDao  = new StudentCourseTeacherDaoImpl();
	
	@Override
	public int add(Teacher teacher) {
		return this.teacherDao.save(teacher);
	}

	@Override
	public List<Teacher> findAll() {
		return this.teacherDao.findAll();
	}

	@Override
	public int delete(int tno) {
		return this.teacherDao.delete(tno);
	}

	@Override
	public Teacher findById(int tno) {
		return this.teacherDao.findById(tno);
	}

	@Override
	public int update(Teacher teacher) {
		return this.teacherDao.update(teacher);
	}

	@Override
	public List<StudentCourse> getSelectedStudentAndCourse(int tno) {
		return this.sctDao.getSelectedStudentAndCourse(tno);
	}

	@Override
	public int courseRemark(int sno, int cno, int tno, double score) {
		return this.sctDao.courseRemark(sno,cno,tno,score);
	}

	@Override
	public List<Course> getAssumeCourse(int tno) {
		return teacherDao.getAssumeCourse(tno);
	}

}
