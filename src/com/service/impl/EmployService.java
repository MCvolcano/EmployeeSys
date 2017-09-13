package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.IEmployeeDao;
import com.dao.impl.EmployeeDao;
import com.entity.Employee;
import com.service.IEmployeeService;

public class EmployService implements IEmployeeService {
	private IEmployeeDao dao = new EmployeeDao();
	
	/**
	 * 添加
	 * @param emp 雇员
	 */
	@Override
	public void addEmp(Employee emp) {
		//判断是否存在相同名称的数据
		Employee employee = dao.findByName(emp.getName());
		if(employee == null) {
			try{
				dao.addEmployee(emp);//执行添加操作
			} catch(Exception e) {
				throw new RuntimeException("员工数据异常");
			}
		} else {
			throw new RuntimeException("存在相同姓名的员工，插入出错");
		}
	}
	
	@Override
	public void deleteEmpById(int id) {
		try {
			Employee employee = dao.findById(id);
			if (employee != null) {
				dao.deleteEmployeeById(id);
			} else {
				throw new RuntimeException("员工不存在，不能删除");
			} 
		} catch (Exception e) {
			throw new RuntimeException("员工不存在，不能删除");
		}
	}
	
	@Override
	public void updateEmp(Employee emp) {
		
		dao.update(emp);
	}
	
	@Override
	public List<Employee> findAllEmps() {
		List<Employee> list = null;
		try {
			//获取数据
			list = dao.findAll();
			if (list == null) {
				throw new RuntimeException("全体员工数据不存在");
			}
			
		} catch (Exception e) {
			throw new RuntimeException("获取员工数据异常");
		}
		return list;
	}
	
	
	@Override
	public Employee findEmyById(int id) {
		Employee emp = null;
		try {
			emp = dao.findById(id);
			if (emp == null) {
				throw new RuntimeException("员工数据不存在");
			}
		} catch (Exception e) {
			throw new RuntimeException("查询出现异常");
		}
		return emp;
		
	}
	
}

























