package com.test.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.aop.model.AddressDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AOPController {

	private final AddressDAO dao;
	
	//주업무 구현 > 주소록 관리
	@GetMapping(value="/list.do")
	public String list() {
		
		dao.list();
		System.out.println("Controller.list");
		return "list";
	}
	
	
	@GetMapping(value="/add.do")
	public String add() {
		dao.add();
		System.out.println("Controller.add");
		
		return "add";
	}
	
	
	
	@GetMapping(value="/view.do")
	public String view() {
		dao.view();
		System.out.println("Controller.view");
		
		return "view";
	}
	
	
}


















