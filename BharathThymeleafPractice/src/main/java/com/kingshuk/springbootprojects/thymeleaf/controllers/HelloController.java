package com.kingshuk.springbootprojects.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/getData")
	public ModelAndView sendData() {
		ModelAndView mvAndView = new ModelAndView();
		mvAndView.addObject("myName", "Kingshuk Mukherjee");
		mvAndView.setViewName("data");
		
		return mvAndView;
	}

}
