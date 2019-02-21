package com.kingshuk.springboot.thymeleafproject.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kingshuk.springboot.thymeleafproject.model.Employee;

@Service
public class BasicServiceImpl {
	
	private List<Employee> employees;
	
	@PostConstruct
	public void setEmployees() {
		employees = Arrays.asList(new Employee(1, "Kingshuk", "Mukherjee", "a@b.com"),
				new Employee(1, "Deeksha", "Banerjee", "c@b.com"));
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}

}
