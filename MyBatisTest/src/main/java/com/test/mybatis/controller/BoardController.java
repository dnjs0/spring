package com.test.mybatis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		model.addAttribute("list1",list1);
		return "list1";
	}
	
}
