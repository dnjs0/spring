package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/ex04_2.do", method=RequestMethod.POST)
public class Ex042Controller {
	
	@RequestMapping
	public String call() {
		return "ex042";
	}

}
