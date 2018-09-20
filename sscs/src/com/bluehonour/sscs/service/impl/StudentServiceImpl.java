package com.bluehonour.sscs.service.impl;

import java.util.List;

import com.bluehonour.sscs.dao.StudentDao;
import com.bluehonour.sscs.dao.impl.StudentDaoImpl;
import com.bluehonour.sscs.entity.ClassInfo;
import com.bluehonour.sscs.entity.CriteriaStudent;
import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public int add(Student stu) {
		return this.studentDao.save(stu);
	}
	@Override
	public List<Student> findAll() {
		return this.studentDao.findAll();
	}
	@Override
	public int delete(int sno) {
		return this.studentDao.del(sno);
	}
	@Override
	public Student findById(int sno) {
		return this.studentDao.findById(sno);
	}
	@Override
	public int update(Student stu) {
		return this.studentDao.update(stu);
	}
	@Override
	public Student login(String sno, String password) {
		return this.studentDao.find(sno,password);
	}
	@Override
	public List<ClassInfo> getClassInfo() {
		return this.studentDao.getClassInfo();
	}
	@Override
	public List<Student> getForListWithCriteriaStudent(CriteriaStudent student) {
		return this.studentDao.getForListWithCriteriaStudent(student);
	}

}
