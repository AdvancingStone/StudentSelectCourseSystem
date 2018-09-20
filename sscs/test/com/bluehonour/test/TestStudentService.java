package com.bluehonour.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.service.StudentService;
import com.bluehonour.sscs.service.impl.StudentServiceImpl;

public class TestStudentService {
	
	StudentService studentService = new StudentServiceImpl();
	@Test
	public void testAdd() {
		Student stu = new Student("123456","我是谁",151515,"男",new Date(),1,"ddd");
		for(int i=0;i<100;i++) {
			int n = studentService.add(stu);
			System.out.println(n);
		}
	}
	
	@Test
	public void testFindAll() {
		List<Student> findAll = studentService.findAll();
		System.out.println(findAll);
	}
	
	@Test
	public void testDelete() {
		int sno = 4;
		int n = studentService.delete(sno);
		System.out.println(n);
	}
}
