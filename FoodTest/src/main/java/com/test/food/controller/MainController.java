package com.test.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.food.model.FoodDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final FoodDAO dao;
	
	@GetMapping("/")
	public String main() {
		
		//http://localhost:8090/food
		
		
		return "main";
	}
	
}
