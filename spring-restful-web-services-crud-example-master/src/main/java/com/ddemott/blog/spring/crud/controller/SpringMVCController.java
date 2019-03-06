package com.ddemott.blog.spring.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class SpringMVCController {

	@RequestMapping(value="/showEmpForm",method=RequestMethod.GET)
	public String showEmpForm(){
		System.out.println("inside showEmpForm::");
		return "EmployeeForm";
	}
}
