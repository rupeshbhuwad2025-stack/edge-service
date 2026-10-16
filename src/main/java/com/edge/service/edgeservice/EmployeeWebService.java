package com.edge.service.edgeservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edge.service.edgeservice.dto.UserDto;
import com.edge.service.edgeservice.entity.Employee;
import com.edge.service.edgeservice.entity.User;


@FeignClient("employee-service")
public interface EmployeeWebService {

	@GetMapping("/employees")
	ResponseEntity<List<Employee>> getAllEmployees();
	
	@GetMapping("/api/users")
	public ResponseEntity<List<UserDto>> getUserList();
	
	@GetMapping("/api/users/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable long id);
	
	@PostMapping("/api/users/register")
	public ResponseEntity<UserDto> registerUser(UserDto user);
	
	@DeleteMapping("/api/users/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable long id);
	
	@PutMapping("/api/users/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable long id,@RequestBody UserDto user);	
	
	
	@PostMapping("/api/users/authenticate")
	public User authenticateUser(@RequestBody User user);
}
