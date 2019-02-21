package com.kingshuk.springboot.thymeleafproject.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kingshuk.springboot.thymeleafproject.service.BasicServiceImpl;

@Controller
public class BasicThymeleafController {
	
	@Autowired
	private BasicServiceImpl basicService;
	
	@GetMapping("/")
	public String getBasicNameAndDate(Model theModel) {
		
		theModel.addAttribute("name","Kingshuk Mukherjee");
		theModel.addAttribute("timeOnTheServer", new Date());
		
		return "hello-world";
	}
	
	@GetMapping("/employees")
	public String getEmployeesList(Model theModel) {
		theModel.addAttribute("employees", basicService.getEmployees());
	
		return "employee-page";
	}

}
