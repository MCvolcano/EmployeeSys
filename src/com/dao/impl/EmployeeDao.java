package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.IEmployeeDao;
import com.entity.Employee;
import com.util.JDBCUtils;

public class EmployeeDao implements IEmployeeDao {

	public List<Employee> findAll() {
		String sql = "select * from emploree";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		List<Employee> list = null;
		//查询操作
		try {
			list = qr.query(sql, new BeanListHandler<>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
		
	}

	//查询姓名 对象
	public Employee findByName(String name) {
		String sql = "select * from emploree where name=?";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		Employee emp = null;
		//查询操作
		try {
			emp = qr.query(sql, new BeanHandler<Employee>(Employee.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	//增
	public void addEmployee(Employee e) throws SQLException {
		String sql = "insert into emploree(name,age,sex,qq,phone,email) value(?,?,?,?,?,?)";
		QueryRunner qr = JDBCUtils.getQueryRunner();
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
			qr.update(sql, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			throw e1;
		}
	}
	
	//查询id 对象
		public Employee findById(int id) {
			String sql = "select * from emploree where id=?";
			QueryRunner qr = JDBCUtils.getQueryRunner();
			Employee emp = null;
			//查询操作
			try {
				emp = qr.query(sql, new BeanHandler<Employee>(Employee.class), id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emp;
		}
	
	//删除
	public void deleteEmployeeById(int id) {
		String sql = "delete from emploree where id=?";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		
		//查询操作
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改
	public void update(Employee e) {
		String sql = "update emploree set name=?,age=?,sex=?,qq=?,phone=?,email=? where id=?";
		QueryRunner qr = JDBCUtils.getQueryRunner();
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
			qr.update(sql, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
