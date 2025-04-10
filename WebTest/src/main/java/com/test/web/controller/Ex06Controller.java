package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//- http://localhost:8090/web/member/ex06.do
//- http://localhost:8090/web/member/ex06ok.do


@Controller
//@RequestMapping(value="/ex06.do", method=RequestMethod.GET)
@RequestMapping(value="/member")
public class Ex06Controller {

	@RequestMapping(value="/ex06.do", method=RequestMethod.GET)
	public String ex06() {
		return "ex06";
	}
	
	
	//@RequestMapping(value="/ex06ok.do", method=RequestMethod.GET)
	//public String ex06get() {
	//	return "ex06_get";
	//}
	
	
	//@RequestMapping(value="/ex06ok.do", method=RequestMethod.POST)
	//public String ex06post() {
	//	return "ex06_post";
	//}
	
	@GetMapping(value="/ex06ok.do")
	public String ex06get() {
		return "ex06_get";
	}
	
	@PostMapping(value="/ex06ok.do")
	public String ex06post() {
		return "ex06_post";
	}
	
}
