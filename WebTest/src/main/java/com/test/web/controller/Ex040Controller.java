package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/ex04.do")
public class Ex040Controller {
	
	@RequestMapping
	public String call() {
		
		
		
		return "ex04";
	}
	
	
}
