package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeSrvice;
	
	//api
	@GetMapping("/getMessage")
	public String getMessage() {
		return "Welcome to springboot";
	}
	@PostMapping("/saveEmployee")
	public Employee registerEmployee(@RequestBody Employee employee) {
		Employee employee1=employeeSrvice.registerEmployee(employee);
		return employee1;
	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees=employeeSrvice.getAllEmployee();
		return allEmployees;
	}
	@GetMapping("/getById/{id}")
	public Employee getByEmployeeId(@PathVariable long id) {
		Employee employee=employeeSrvice.getByEmployeeId(id);
		return employee;
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteEmployeeById(@PathVariable long id) {
		String result=employeeSrvice.deleteEmployeeById(id);
		return result;
	}
	@PutMapping("/updateEmployee")
	public Employee updateEmployeeById(@RequestBody Employee employee) {
		Employee employee1=employeeSrvice.updateEmployeeById(employee);
		return employee1;
	}
}
