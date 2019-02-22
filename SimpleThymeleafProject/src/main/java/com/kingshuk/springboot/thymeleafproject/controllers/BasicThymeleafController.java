package com.kingshuk.springboot.thymeleafproject.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kingshuk.springboot.thymeleafproject.model.Employee;
import com.kingshuk.springboot.thymeleafproject.service.BasicServiceImpl;

@Controller
public class BasicThymeleafController {

	@Autowired
	private BasicServiceImpl basicService;

	@GetMapping("/hello")
	public String getBasicNameAndDate(Model theModel) {

		theModel.addAttribute("name", "Kingshuk Mukherjee");
		theModel.addAttribute("timeOnTheServer", new Date());

		return "hello-world";
	}

	@GetMapping("/employees")
	public String getEmployeesList(Model theModel) {
		theModel.addAttribute("employees", basicService.getEmployees());

		return "employee-page";
	}

	@GetMapping("/employees/addEmployee")
	public String showEmplotyeeAddForm(Model theModel) {
		theModel.addAttribute("employeeForm", new Employee());
		return "employee-form";
	}

	@PostMapping(path = { "/employee/add", "/employee/update" })
	public String addEmployee(@ModelAttribute("employeeForm") Employee employee) {

		basicService.addOrUpdateEmployee(employee);

		return "redirect:/employees";
	}

	@GetMapping("/employees/updateEmployeeForm")
	public String updateEmployeeForm(@RequestParam("employeeId") long theId, Model theModel) {

		theModel.addAttribute("employeeForm", basicService.getSingleEmployee(theId));

		return "update-employee";
	}
	
	@GetMapping("/employees/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") long theId, Model theModel) {
		
		basicService.deleteEmployee(theId);

		return "redirect:/employees";
	}

}
