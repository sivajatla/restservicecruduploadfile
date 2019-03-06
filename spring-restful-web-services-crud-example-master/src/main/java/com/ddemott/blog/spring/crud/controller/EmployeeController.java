package com.ddemott.blog.spring.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@RequestMapping(value="/empForm",method=RequestMethod.POST)
	public String displayEmployeeForm(String fname,String age){
		System.out.println("inside displayEmployeeForm::"+fname);
		return "EmployeeForm";
	}
	
	

}
