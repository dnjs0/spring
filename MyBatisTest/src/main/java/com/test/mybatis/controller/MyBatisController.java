package com.test.mybatis.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.mybatis.model.AddressDTO;
import com.test.mybatis.model.MyBatisDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyBatisController {
	
	private final MyBatisDAO dao;

	@GetMapping("/test.do")
	public String test(Model model) {
		
		System.out.println(dao != null); //true
		
		return "result";
	}
	
	//반환값(X), 인자값(X)
	@GetMapping(value="/m1.do")
	public String m1() {
		
		this.dao.m1();
		
		return "result";
	}
	
	//반환값(X), 인자값(O)
	//http://localhost:8090/mybatis/m2.do?seq=5
	@GetMapping(value="/m2.do") //m2.do?seq=5
	public String m2(Model model, String seq) {
		int result = this.dao.m2(seq);
		model.addAttribute("result", result);
		
		return "result";
	}
	
	
	//반환값(X), 인자값(O) (인자값 여러개)
	@GetMapping(value="/m3.do")
	public String m3(Model model) {
		
		//8	햄스터	1	서울시 강북구 우이동	m
		//dto 써도 됨, Hashmap  써보기
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("age", "2");
		map.put("address","서울시 강남구 역삼동");
		map.put("seq", "8");
		
		int result = dao.m3(map);
		
		model.addAttribute("result", result);
		
		return "result";
	}
	
	
	
	//반환값(X), 인자값(O) (insert)
	@GetMapping(value="/m4.do")
	public String m4(Model model) {
		
		//사용자가 입력했다고 가정
		AddressDTO dto = new AddressDTO();
		dto.setName("아무개");
		dto.setAge("20");
		dto.setAddress("서울시 강남구 역삼동");
		dto.setGender("m");
		
		int result = dao.m4(dto);
		model.addAttribute("result",result);
		
		return "result";
	}
	
	
	
	// 순서 : dao(interface) > daoImpl > xml(쿼리적기) > 단위테스트 > controller 
	@GetMapping(value="/m5.do")
	public String m5(Model model) {
		
		int result = dao.m5();
		model.addAttribute("result",result);
		
		return "result";
	}
	
	
	@GetMapping(value="/m6.do")
	public String m6(Model model) {
		
		AddressDTO dto = dao.m6("10");
		model.addAttribute("dto",dto);
		
		return "result";
	}
	
	
	@GetMapping(value="/m7.do")
	public String m7(Model model) {
		
		List<String> names = dao.m7();
		model.addAttribute("names",names);
		
		return "result";
	}
	
	@GetMapping(value="/m8.do")
	public String m8(Model model) {
		
		List<AddressDTO> list = dao.m8();
		model.addAttribute("list",list);
		
		return "result";
	}
	
	/*
	@GetMapping(value="/m1.do")
	public String m1(Model model) {
		
		return "result";
	}
	*/
	
}









