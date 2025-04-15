package com.test.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.code.model.CodeDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CodeController {

	//DAO 필요
	//1. 구현 클래스를 직접 참조
	// -  단점 : 결합도가 높아짐 > 유지보수가 힘들다.
	//private OracleDAO dao;
	//private MySqlDAO dao;
	
	//2. 인터페이스 참조
	//- "어떻게 하느냐?" (X) > "무엇을 하느냐?"(O)
	//@Autowired
	//private CodeDAO dao;
	
	private final CodeDAO dao;
	
	@GetMapping(value="/list.do")
	public String list(Model model) {
		return "list";
	}
	
}



















