package com.edge.service.edgeservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edge.service.edgeservice.EmployeeWebService;
import com.edge.service.edgeservice.entity.Employee;


@RestController
public class EmployeeDetailController {

	@Autowired
	EmployeeWebService employeeWebService;
	
	@GetMapping("/employees-all")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmployees() {	
		return employeeWebService.getAllEmployees();
	}
	
	@GetMapping("/employees-by-designation/{designation}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmployeesByDesignation(@PathVariable String designation) {	
		ResponseEntity<List<Employee>> entity = employeeWebService.getAllEmployees();
		List<Employee> empList = entity.getBody();
		List<Employee> filterList = empList.stream()
				.filter(emp->emp.getDesignation().equalsIgnoreCase(designation))
				.sorted((a,b)->a.getEmpName().compareTo(b.getEmpName()))
				.collect(Collectors.toList());
		ResponseEntity<List<Employee>> filterEntity = new ResponseEntity<List<Employee>>(filterList,HttpStatus.OK);
		return filterEntity;
	}
	
	@GetMapping("/employees-by-department/{dept}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String dept) {	
		ResponseEntity<List<Employee>> entity = employeeWebService.getAllEmployees();
		List<Employee> empList = entity.getBody();
		List<Employee> filterList = empList.stream()
				.filter(emp->emp.getDepartment().equalsIgnoreCase(dept))
				.sorted((a,b)->a.getEmpName().compareTo(b.getEmpName()))
				.collect(Collectors.toList());
		ResponseEntity<List<Employee>> filterEntity = new ResponseEntity<List<Employee>>(filterList,HttpStatus.OK);
		return filterEntity;
	}
	
	@GetMapping("/employees-salary-greaterthan/{salary}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmployeesGTSalary(@PathVariable Long salary) {	
		ResponseEntity<List<Employee>> entity = employeeWebService.getAllEmployees();
		List<Employee> empList = entity.getBody();
		List<Employee> filterList = empList.stream()
				.filter(emp->emp.getSalary()>salary)
				.sorted((a,b)->a.getEmpName().compareTo(b.getEmpName()))
				.collect(Collectors.toList());
		ResponseEntity<List<Employee>> filterEntity = new ResponseEntity<List<Employee>>(filterList,HttpStatus.OK);
		return filterEntity;
	}
	
	@GetMapping("/employees-salary-lessthan/{salary}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmployeesTHSalary(@PathVariable Long salary) {	
		ResponseEntity<List<Employee>> entity = employeeWebService.getAllEmployees();
		List<Employee> empList = entity.getBody();
		List<Employee> filterList = empList.stream()
				.filter(emp->emp.getSalary()<salary)
				.sorted((a,b)->a.getEmpName().compareTo(b.getEmpName()))
				.collect(Collectors.toList());
		ResponseEntity<List<Employee>> filterEntity = new ResponseEntity<List<Employee>>(filterList,HttpStatus.OK);
		return filterEntity;
	}
	
}
