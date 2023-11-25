package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody List<User> user){
		
		repo.saveAll(user);
		
		return ResponseEntity.ok("Data saved");
	}
	
    @GetMapping("/getUser")
	public List<User> getUserAll() {
		
    	List<User> user=repo.findAll();
		return user;
	}
    
    @GetMapping("/getUser/{id}")
   	public User getUser(@PathVariable long id) {
   		
       	User user= repo.findById(id).get();
   		return user;
   	}
    
}