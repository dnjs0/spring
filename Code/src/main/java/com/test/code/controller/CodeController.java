package com.test.code.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.code.model.CodeDAO;
import com.test.code.model.CodeDTO;
import com.test.code.model.LanguageDTO;

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
	
	//http://localhost:8090/code/list.do
	@GetMapping(value="/list.do")
	public String list(Model model) {
		
		List<CodeDTO> list = dao.list();
		model.addAttribute("list",list);
				
		return "list";
	}
	
	@GetMapping(value="/add.do")
	public String add(Model model) {
		List<LanguageDTO> clist= dao.clist();
		model.addAttribute("clist",clist);
		return "add";
	}
	
	
	
	@PostMapping(value="/addok.do")
	public String addok(Model model, CodeDTO dto) {
		int result = dao.add(dto);
		
		if(result ==1) {
			return "redirect:/list.do";
		}else {
			return "redirect:/add.do";
		}
	}
	
	@GetMapping(value="/view.do")
	public String view(Model model, String seq) {
		CodeDTO dto = dao.view(seq);
		model.addAttribute("dto",dto);
		
		return "view";
	}
	
	
	
	
	
}



















