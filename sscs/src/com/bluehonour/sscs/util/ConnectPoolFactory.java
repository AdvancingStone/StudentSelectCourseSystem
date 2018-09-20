package com.bluehonour.sscs.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

public class ConnectPoolFactory {
	
	private static ConnectPoolFactory connectPoolFactory = null;
	
	private ConnectPoolFactory() {
		Init();
	}

	public void Init() {// 把properties文件加载到链接对象
		InputStream is = ConnectPoolFactory.class.getResourceAsStream("/proxool.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
			PropertyConfigurator.configure(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//单例
	public static ConnectPoolFactory getInstance() {
		if(null == connectPoolFactory) {
			connectPoolFactory = new ConnectPoolFactory();
		}
		return connectPoolFactory;
	}
	
	public Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn = DriverManager.getConnection("proxool.test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
