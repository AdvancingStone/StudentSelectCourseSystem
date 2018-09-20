package com.bluehonour.test;

import java.util.Date;

import org.junit.Test;

import com.bluehonour.sscs.entity.Admin;
import com.bluehonour.sscs.service.AdminService;
import com.bluehonour.sscs.service.impl.AdminServiceImpl;

public class TestAdminService {
	@Test
	public void testLogin() {
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.login("111", "12");
		System.out.println(admin);
	}
	
	@Test
	public void testAdd() {
		AdminService adminService = new AdminServiceImpl();
		Admin admin = new Admin("222", "张三", "22", 22, 95.5, new Date(), "玩游戏");
		int n = adminService.add(admin);
		System.out.println(n);
	}
}
