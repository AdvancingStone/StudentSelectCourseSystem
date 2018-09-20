package com.bluehonour.sscs.service;

import com.bluehonour.sscs.entity.Admin;

public interface AdminService {
	/**
	 * 管理员登录
	 * @param userId
	 * @param password
	 * @return
	 */
	public Admin login(String userId, String password);
	
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public int add(Admin admin);
}
