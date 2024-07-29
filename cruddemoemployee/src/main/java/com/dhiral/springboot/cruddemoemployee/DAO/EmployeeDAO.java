package com.dhiral.springboot.cruddemoemployee.DAO;

import java.util.List;

import com.dhiral.springboot.cruddemoemployee.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteEmp(int id);

}
