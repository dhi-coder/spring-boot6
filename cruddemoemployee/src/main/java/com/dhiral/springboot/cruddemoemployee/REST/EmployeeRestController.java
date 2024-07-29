package com.dhiral.springboot.cruddemoemployee.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.dhiral.springboot.cruddemoemployee.DAO.EmployeeDAO;
import com.dhiral.springboot.cruddemoemployee.entity.Employee;
import com.dhiral.springboot.cruddemoemployee.service.EmployeeService;

@RestController
 @RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	public EmployeeRestController() {};
	
	// inject DAO 
	@Autowired
	public EmployeeRestController(EmployeeService theeemployeeService) {
		employeeService = theeemployeeService;
	}
	
	// expose / employees endpoint
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee result = employeeService.FindByIdService(employeeId);
		if(result == null) {
			throw new RuntimeException("Employee id not Found " +employeeId);
		}else {
			return result;
		}
			
		
	}
	
	// add employees method
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.saveService(theEmployee);
		return dbEmployee;
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.saveService(theEmployee);
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public int deleteEmployee(@PathVariable int employeeId) {
		Employee dbEmployee = employeeService.FindByIdService(employeeId);
		if(dbEmployee == null) {
			throw new RuntimeException ("Employye with given id not foung" +employeeId);
		}
		else {
			employeeService.deleteByIdService(employeeId);
			
			return employeeId;
		}
	}
}
