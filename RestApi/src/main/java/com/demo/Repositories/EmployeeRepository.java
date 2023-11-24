package com.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Emp;

public interface EmployeeRepository extends JpaRepository<Emp, Long>{

}