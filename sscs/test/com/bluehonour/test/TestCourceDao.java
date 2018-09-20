package com.bluehonour.test;

import java.util.Date;

import org.junit.Test;

import com.bluehonour.sscs.dao.CourseDao;
import com.bluehonour.sscs.dao.impl.CourseDaoImpl;
import com.bluehonour.sscs.entity.Course;

public class TestCourceDao {
	
	CourseDao courceDao = new CourseDaoImpl();
	Course course = null;
	
	@Test
	public void testSave() {
		course = new Course("java",4,new Date(),new Date());
		int n = courceDao.save(course);
		System.out.println(n);
	}
}
