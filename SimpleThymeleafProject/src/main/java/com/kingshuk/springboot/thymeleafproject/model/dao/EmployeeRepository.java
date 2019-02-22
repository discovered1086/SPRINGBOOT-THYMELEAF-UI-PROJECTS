package com.kingshuk.springboot.thymeleafproject.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.springboot.thymeleafproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findAllByOrderByFirstNameAsc();

}
