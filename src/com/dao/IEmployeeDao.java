package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.Employee;

public interface IEmployeeDao {
	public List<Employee> findAll();

	//查询姓名 对象
	public Employee findByName(String name);
	
	//增
	public void addEmployee(Employee e) throws SQLException;
	
	//查询id 对象
		public Employee findById(int id);
	
	//删除
	public void deleteEmployeeById(int id);
	
	//修改
	public void update(Employee e);
}
