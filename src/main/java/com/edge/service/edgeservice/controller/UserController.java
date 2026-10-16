package com.edge.service.edgeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge.service.edgeservice.EmployeeWebService;
import com.edge.service.edgeservice.dto.UserDto;
import com.edge.service.edgeservice.entity.User;



@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {


	EmployeeWebService employeeWebService;
	
	UserController(EmployeeWebService employeeWebService){
		this.employeeWebService = employeeWebService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getUserList(){
		return employeeWebService.getUserList();
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "*")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto user){
		return employeeWebService.registerUser(user);
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Boolean> deleteUser(@PathVariable long id){
		return employeeWebService.deleteUser(id);
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<UserDto> getUserById(@PathVariable long id){
		return employeeWebService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto user){
		return employeeWebService.updateUser(id, user);
	}
	
	@PostMapping("/authenticate")
	@CrossOrigin(origins = "*")
	public User authenticateUser(@RequestBody User user){
		return employeeWebService.authenticateUser(user);
	}
	
}
