package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.Employee;
import com.util.JDBCUtils_bak;

public class EmployeeDao_bak {
	//name, sex, age, qq, phone, email
	private Connection conn;
	
	public List<Employee> findAll() {
		conn = JDBCUtils_bak.getConnection();
		String sql = "select * from emploree";
		QueryRunner qr = new QueryRunner();
		List<Employee> list = null;
		//查询操作
		try {
			list = qr.query(conn, sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
		
	}

	//查询姓名 对象
	public Employee findByName(String name) {
		conn = JDBCUtils_bak.getConnection();
		String sql = "select * from emploree where name=?";
		QueryRunner qr = new QueryRunner();
		Employee emp = null;
		//查询操作
		try {
			emp = qr.query(conn, sql, new BeanHandler<Employee>(Employee.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	//增
	public void addEmployee(Employee e) throws SQLException {
		conn = JDBCUtils_bak.getConnection();
		String sql = "insert into emploree(name,age,sex,qq,phone,email) value(?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		//查询操作
		try {
			Object[] params = new Object[]{
				e.getName(),
				e.getAge(),
				e.getSex(),
				e.getQq(),
				e.getPhone(),
				e.getEmail()
			};
			qr.update(conn, sql, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			throw e1;
		}
	}
	
	//查询id 对象
		public Employee findById(int id) {
			conn = JDBCUtils_bak.getConnection();
			String sql = "select * from emploree where id=?";
			QueryRunner qr = new QueryRunner();
			Employee emp = null;
			//查询操作
			try {
				emp = qr.query(conn, sql, new BeanHandler<Employee>(Employee.class), id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emp;
		}
	
	//删除
	public void deleteEmployeeById(int id) {
		conn = JDBCUtils_bak.getConnection();
		String sql = "delete from emploree where id=?";
		QueryRunner qr = new QueryRunner();
		
		//查询操作
		try {
			qr.update(conn, sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改
	public void update(Employee e) {
		conn = JDBCUtils_bak.getConnection();
		String sql = "update emploree set name=?,age=?,sex=?,qq=?,phone=?,email=? where id=?";
		QueryRunner qr = new QueryRunner();
		//查询操作
		try {
			Object[] params = new Object[]{
				e.getName(),
				e.getAge(),
				e.getSex(),
				e.getQq(),
				e.getPhone(),
				e.getEmail(),
				e.getId()
			};
			qr.update(conn, sql, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}










































