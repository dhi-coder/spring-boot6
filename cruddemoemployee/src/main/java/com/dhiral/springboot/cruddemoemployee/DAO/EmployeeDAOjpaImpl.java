package com.dhiral.springboot.cruddemoemployee.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhiral.springboot.cruddemoemployee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOjpaImpl implements EmployeeDAO {

	// define fields for EntityMaager
	private EntityManager entityManager;
	
	// set up constructor injection
	
	@Autowired
	public EmployeeDAOjpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// create query 
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		// execute the query
		List<Employee> employees = theQuery.getResultList();
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get employees
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee savedEmp = entityManager.merge(theEmployee);
		return savedEmp;
	}

	@Override
	public void deleteEmp(int id) {
		// get id to be deleted
		Employee deleteEmp = entityManager.find(Employee.class, id);
		entityManager.remove(deleteEmp);
		
		
		
	}

}
