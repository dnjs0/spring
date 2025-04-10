package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/ex05ok.do")
public class Ex05OkController {

	
		@RequestMapping(method=RequestMethod.GET)
		public String call() {
			System.out.println("GET 요청됨");
			return "ex05_get";
		}
		
		
		@RequestMapping(method=RequestMethod.POST)
		public String call2() {
			System.out.println("POST 요청됨");
			return "ex05_post";
		}
	
}
