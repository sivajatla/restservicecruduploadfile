package com.ddemott.blog.spring.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	
	@RequestMapping(value="/empForm")
	public String displayEmployeeForm(){
		return "EmployeeForm";
	}

}
