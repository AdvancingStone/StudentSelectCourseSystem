package com.bluehonour.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bluehonour.sscs.dao.StudentDao;
import com.bluehonour.sscs.dao.impl.StudentDaoImpl;
import com.bluehonour.sscs.entity.Student;

public class TestStudentDao {
	
	StudentDao studentDao = new StudentDaoImpl();
	@Test
	public void testSave() {
		long phone = 15788888888L;
		for(int i=0;i<44;i++) {
			Student stu = new Student("123456","李四",phone,"男",new Date(),1531,"优秀");
			int n = studentDao.save(stu);
			System.out.println(n);
		}
	}
	
	@Test
	public void testFindAll() {
		List<Student> findAll = studentDao.findAll();
		System.out.println(findAll);
	}
}
