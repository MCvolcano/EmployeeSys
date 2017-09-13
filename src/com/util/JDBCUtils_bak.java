package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCUtils_bak {
	private static Properties pro = new Properties();
	private static Connection conn;
	private static String url = null;
	private static String name =  null;
	private static String pwd = null;
	
	
	static {
		//  /相对于classes文件
		String path = JDBCUtils_bak.class.getResource("/db.properties").getPath();
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(path);
			pro.load(in);
			url = pro.getProperty("mysql.url");
			name = pro.getProperty("mysql.name");
			pwd = pro.getProperty("mysql.password");
			
			Class.forName(pro.getProperty("mysql.driver"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, name, pwd);
			System.out.println("连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
