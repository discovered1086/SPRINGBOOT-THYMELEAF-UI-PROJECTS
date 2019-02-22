package com.kingshuk.springboot.thymeleafproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.springboot.thymeleafproject.model.Employee;
import com.kingshuk.springboot.thymeleafproject.model.dao.EmployeeRepository;

@Service
public class BasicServiceImpl {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees(){
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}
	
	public Employee getSingleEmployee(long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}
	
	public Employee addOrUpdateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
