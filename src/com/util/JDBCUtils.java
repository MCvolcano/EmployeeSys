package com.util;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static ComboPooledDataSource ds = null;
	
	static {
		//
		ds = new ComboPooledDataSource();
	}
	
	public static QueryRunner getQueryRunner() {
		QueryRunner queryRunner = new QueryRunner(ds);
		return queryRunner;
	}
	
	
}
