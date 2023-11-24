package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Employees;
import com.demo.repositories.EmployeeRepository;

@RestController
public class EmployeeController {
	

	@Autowired
	EmployeeRepository repo;
	
	@PostMapping("/employees/add")
	
       public List<Employees> createEmployees(@RequestBody List<Employees> emp) {
		
		List<Employees> employees1=repo.saveAll(emp);
		
		return (employees1);
	
	
	}
	
	@GetMapping("/employees/{id}")
	public Employees getEmployees(@PathVariable int id) {
		
		Employees emp=repo.findById(id).get();
		return emp;
	}
	
	@GetMapping("/employees")
	public List<Employees> getEmployees() {
		
		List<Employees> emp1=repo.findAll();
		return emp1;
	}
	
	@PutMapping("/employees/update/{id}")
	
	public Employees updateEmployees(@PathVariable int id,@RequestBody Employees emp) {
		
		Employees emps=repo.findById(id).get();
		Employees.setName(emp.getname());
		Employees.setMailage(emp.getsalary());
		Employees.setPrice(emp.getlocation());
		return repo.save(emp);
	}

}
