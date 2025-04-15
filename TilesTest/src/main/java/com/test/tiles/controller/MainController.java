package com.test.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value="/index.do")
	public String index() {
		
		//이전까지
		//- JSP 파일명 + ViewRolver
		//return "index";
		
		//지금부터
		//- <definition name="index"> + TilesViewRolver
		return "index";
	}

}









