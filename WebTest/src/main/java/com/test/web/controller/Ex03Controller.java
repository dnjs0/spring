package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*public class Ex03Controller implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		return null;
	}*/

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용

@Controller
@RequestMapping(value="/ex03.do")
public class Ex03Controller {
	
	//요청 메서드 > 누가 호출 ? (톰캣, 스프링 컨테이너)
	//요청 메서드 > 맘대로 ~ 구현
	
	//doGet/doPost/handleRequest
	//다 가능, 여러 메서드를 만들수있기때문에 하나 지정
	@RequestMapping
	public String test(HttpServletRequest req) {
		System.out.println("컨트롤러 요청이 발생했습니다.");
		
		aaa();
		bbb();
		
		req.setAttribute("name", "홍길동");
		
		//ViewResolver 호출(servlet-context.xml)
		// - "/WEB-INF/views"+"ex03"+".jsp"
		return "ex03"; //JSP 호출
	}
	
	public void aaa() {
		
	}
	
	public void bbb() {
		
	}


}
