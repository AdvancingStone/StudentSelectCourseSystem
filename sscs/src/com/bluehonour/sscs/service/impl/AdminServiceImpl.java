package com.bluehonour.sscs.service.impl;

import com.bluehonour.sscs.dao.AdminDao;
import com.bluehonour.sscs.dao.impl.AdminDaoImpl;
import com.bluehonour.sscs.entity.Admin;
import com.bluehonour.sscs.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin login(String userId, String password) {
		Admin admin = adminDao.find(userId, password);
		return admin;
	}

	@Override
	public int add(Admin admin) {
		return this.adminDao.save(admin);
	}

}
