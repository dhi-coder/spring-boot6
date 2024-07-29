package com.dhiral.springboot.cruddemoemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiral.springboot.cruddemoemployee.DAO.EmployeeDAO;
import com.dhiral.springboot.cruddemoemployee.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theemployeeDAO) {
		employeeDAO = theemployeeDAO;
	}
	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}
	@Override
	public Employee FindByIdService(int id) {
		
		return employeeDAO.findById(id);
	}
	
	@Transactional
	@Override
	public Employee saveService(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(theEmployee);
	}
	@Transactional
	@Override
	public void deleteByIdService(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmp(id);
	}
	
	

}
