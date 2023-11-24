package com.demo.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Repositories.EmployeeRepository;
import com.demo.entities.Emp;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	@PostMapping("/employees")
	public ResponseEntity<String> createEmp(@RequestBody List<Emp> emp){
		
		repo.saveAll(emp);
		
		return ResponseEntity.ok("Data saved on mysql database");
	}
	
    @GetMapping("/getEmployee")
	public List<Emp> getEmployeeAll() {
		
    	List<Emp> emp=repo.findAll();
		return emp;
	}
    
    @GetMapping("/getEmployee/{id}")
   	public Emp getUser(@PathVariable long id) {
   		
       	Emp emp1= repo.findById(id).get();
   		return emp1;
   	}
    
}