package com.test.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.model.AddressDTO;

@Controller
public class Ex08Controller {
	
	//요청 메서드의 반환값
	
	/*
	//1. String
	//- JSP 파일명
	//- ViewResolver 호출
	@GetMapping(value="/ex08.do")
	public String ex08() {
		return "ex08";
	}
	*/
	
	
	/*
	//2. void
	//- Spring 4.3이후 지원
	//- 요청 주소와 동일한 이름의 JSP 페이지를 호출한다.
	@GetMapping(value="/ex08.do")
	public void ex08() {
		// - /ex08.do > ex08.jsp
		
	}
	*/
	
	/*
	//3. String + 키워드
	//- redirect : URL
	//- forward : URL
	@GetMapping(value="/ex08.do")
	public String ex08() {
	
		//resp.sendRedirect("/ex07.do")
		//return "redirect:/ex07.do";
		
		//pageContext.forward() > req.gerRequestDispatcher().forward(req,resp)
		return "forward:/ex07.do";
	}
	*/
	
	/*
	//4. String
	//- RedirectAttributes
	@GetMapping(value="/ex08.do")
	public String ex08(RedirectAttributes rttr) {
		String seq = "5";
		String id = "hong";
		
		rttr.addAttribute("seq",seq);
		rttr.addAttribute("id",id);
		//return "redirect:/ex07.do?seq=5&id=hong";
		//return "redirect:/ex07.do?seq="+seq+"&id="+id;
		return "redirect:/ex07.do";
	}

	 */
	
	
	/*
	//5.JSON 반환
	//@Responsebody
	//- 요청 메서드의 반환값ㅇ ㄹ JSON으로 반환
	@GetMapping(value="/ex08.do")
	public @ResponseBody String ex08() {
		
		String name =  "gdxxxxgxx";
		
		return name;
	}
	*/
	
	/*
	@GetMapping(value="/ex08.do")
	public @ResponseBody AddressDTO ex08() {
		
		AddressDTO dto = new AddressDTO();
		dto.setName("홍길동");
		dto.setAge(22);
		dto.setAddress("서울");
		
		return dto;
	}
	*/
	
	
	@GetMapping(value="/ex08.do")
	public @ResponseBody ArrayList<AddressDTO> ex08() {
		
		AddressDTO dto = new AddressDTO();
		dto.setName("홍길동");
		dto.setAge(22);
		dto.setAddress("서울");
		
		
		AddressDTO dto2 = new AddressDTO();
		dto2.setName("아무개");
		dto2.setAge(22);
		dto2.setAddress("인천");
		
		ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
		list.add(dto);
		list.add(dto2);
		return list;
	}
	
	
}
















