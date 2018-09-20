package com.bluehonour.test;

import java.util.Date;

import org.junit.Test;

import com.bluehonour.sscs.dao.AdminDao;
import com.bluehonour.sscs.dao.impl.AdminDaoImpl;
import com.bluehonour.sscs.entity.Admin;

public class TestAdminDao {
	
	AdminDao adminDao = new AdminDaoImpl();
	Admin admin = null;
	@Test
	public void testFind() {
		admin = adminDao.find("111", "12");
		System.out.println(admin);
		
	}
	@Test
	public void testSave() {
		Admin admin = new Admin("221452", "张三", "22", 22, 95.5, new Date(), "玩游戏");
		int n = adminDao.save(admin);
		System.out.println(n);
	}
}
