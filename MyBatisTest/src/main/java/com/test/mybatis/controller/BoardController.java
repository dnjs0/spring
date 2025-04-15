package com.test.mybatis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.mybatis.model.AddressDTO;
import com.test.mybatis.model.BoardDAO;
import com.test.mybatis.model.BoardDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardDAO dao;
	
	@GetMapping("/list1.do")
	public String list1(Model model) {
		
		List<BoardDTO> list1 = dao.list1();
		
		model.addAttribute("list1", list1);
		
		return "list1";
	}
	
	@GetMapping("/list2.do")
	public String list2(Model model) {
		
		List<BoardDTO> list2 = dao.list2();
		
		model.addAttribute("list2", list2);
		
		return "list2";
	}
	
	@GetMapping(value="/view.do")
	public String view(Model model, String seq) {
		
		//view.do?seq=5
		//- 5번의 상세 내용
		//- 5번에 달려있는 댓글 목록
		
		BoardDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
}









