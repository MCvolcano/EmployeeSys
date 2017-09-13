package com.service;

import java.util.List;

import com.entity.Employee;

public interface IEmployeeService {
	public void addEmp(Employee e);
	
	public void deleteEmpById(int id);
	
	public void updateEmp(Employee emp);
	
	public List<Employee> findAllEmps();
	
	
	
	public Employee findEmyById(int id);

}
