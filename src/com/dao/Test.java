package com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.util.JDBCUtils;

public class Test {

	public static void main(String[] args) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "";
		for (int i = 1; i < 30; i++) {
			sql = "insert into emploree (name, sex, age, qq, phone, email) value('甜" + i + "','女',18,'123456789','13499998888','liuxinluo@qq.com')";
			try {
				qr.update(sql);
				System.out.println("插入成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
