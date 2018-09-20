package com.bluehonour.sscs.dao; 

import com.bluehonour.sscs.entity.Admin;

public interface AdminDao {
	/**
	 * 按照userId和password查询指定的管理员
	 * @param userId 
	 * @param password
	 * @return 一个管理员的信息或者null
	 */
	public Admin find(String userId, String password); 
	
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public int save(Admin admin);
}
