package com.dhiral.springboot.cruddemoemployee.service;

import java.util.List;

import com.dhiral.springboot.cruddemoemployee.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee FindByIdService(int id);
	public Employee saveService(Employee theEmployee);
	public void deleteByIdService(int id);
	
	
}
