package com.demo.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Serializable> {

}