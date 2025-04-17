package com.test.regex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01";
	}

}
