package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.web.model.AddressDTO;
import com.test.web.model.SpringDAO;

@Controller
public class Ex07Controller {
	
	/*
	@GetMapping("/ex07.do") //add.do역할
	public String ex07() {
		return "ex07";
	}
	
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String data = req.getParameter("data");
		req.setAttribute("data", data);
		
		return "ex07ok";
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/ex07.do") //add.do역할
	public String ex07() {
		return "ex07";
	}
	
	/*
	//parameter받기
	//기존 방식 : req.getParameter("key")
	//스프링 : @RequestParam("key") > 파라미터 자동수집
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(@RequestParam("data") String data, Model model) {
		//utf-8 > web.xml에서 필터쓰기
		
		//String data= req.getParameter("data");
		//@RequestParam("data") String data 와 같은 행동!!
		

		//ModelAndView > Model
		model.addAttribute("data",data); //req.setAttribute()
		
		
		return "ex07ok";
	}

	 */
	
	/*
	 * 숫자 로 바꾸기
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(@RequestParam("data") String data, Model model) {
		
		//String req.getParameter("key")
		int num=Integer.parseInt(data);
		model.addAttribute("data", num*2);
		
		return "ex07ok";
	}
	*/
	
	/*
	//숫자를 받기
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(@RequestParam("data") int data, Model model) {
		
		model.addAttribute("data", data*3);
		
		return "ex07ok";
	}
	*/
	
	
	/*
	//숫자를 받기
		@PostMapping("/ex07ok.do") //addok.do 역할
		public String ex07ok(@RequestParam("data") boolean data, Model model) {
			
			model.addAttribute("data", data ? "참":"거짓");
			
			return "ex07ok";
		}
		*/
	
	
	/*
	//숫자를 받기(Integer,  빈칸도 받을 수있다.)
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(@RequestParam("data") Integer data, Model model) {
		
		model.addAttribute("data", data);
		
		return "ex07ok";
	} 
	*/
	
	/*
	//숫자를 받기(Integer,  빈칸도 받을 수있다.)
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(@RequestParam(name = "data", defaultValue="100") Integer data, Model model) {
		
		model.addAttribute("data", data);
		
		return "ex07ok";
	}
	*/
	
	
	
	/*
	//@RequestParam 생략 가능
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(String data, Model model) {
		//***String data >> input태그의 name과 같은 이름 넣어야한다!!!!
		
		//@RequestParam 생략 가능 조건
		
		model.addAttribute("data", data);
		
		return "ex07ok";
	}
	*/
	
	
	/*
	//여러개 받기
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(Model model, 
							@RequestParam("name") String name, 
							@RequestParam("age") Integer age, 
							@RequestParam("address") String address) 
	{
		//DB insert
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		SpringDAO dao = new SpringDAO();
		dao.add(dto);
		
		return "ex07ok";
	}
	 */
	
	
	/*
	//여러개 받기(코드 줄이기)
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(Model model, String name, Integer age, String address) {
		//DB insert
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		SpringDAO dao = new SpringDAO();
		dao.add(dto);
		
		return "ex07ok";
	}
	*/
	
	
	/*
	//여러개 받기(코드 줄이기)
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(Model model, AddressDTO dto) {
		
		//AddresssDTO dto 제공받기 위한 조건
		//- 태그의 name과 DTO의 setter명이 동일
		
		//DB insert
		SpringDAO dao = new SpringDAO();
		dao.add(dto);
		
		return "ex07ok";
	}
	*/
	
	/*
	//여러개 받기(코드 줄이기)
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok( Model model, List<String> cb) {
		//@RequestParam("cb") String[] cb -> String[] cb 생략가능
		//@RequestParam("cb") List<String> cb  리스트로도 쓸 수있음(@RequestParam 생략 불가능)
		//req.getParameterValues("cb")
		
		
		
		
		//model.addAttribute("cb", Arrays.toString(cb));
		model.addAttribute("cb", cb);
		
		return "ex07ok";
	}
	*/
	
	
	/*
	//hidden 태그 name=seq인 상황
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(Model model, AddressDTO dto, String seq) {
		
		//AddresssDTO dto 제공받기 위한 조건
		//- 태그의 name과 DTO의 setter명이 동일
		
		//DB insert
		SpringDAO dao = new SpringDAO();
		dao.add(dto);
		System.out.println(seq);
		
		return "ex07ok";
	}
	*/
	
	
	@PostMapping("/ex07ok.do") //addok.do 역할
	public String ex07ok(Model model, @ModelAttribute("data") String data) {
		
		//@ModelAttribute = getParameter + addAttribute
		
		//model.addAttribute("data",data);
		
		return "ex07ok";
	}
	
		
}



















