package com.test.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.model.AddressDAO;
import com.test.rest.model.AddressDTO;

import lombok.RequiredArgsConstructor;

//@Controller
@RestController
@RequiredArgsConstructor
public class AddressController {
	
	private final AddressDAO dao;
	
	//REST API 구현
	//1. URL 생성
	//2. 반환값 > JSON 반환
	
	@GetMapping("/m1.do")
	public @ResponseBody AddressDTO m1() {	//@ResponseBody : 응답패킷 안에 넣어서 보내주셈
		AddressDTO dto = dao.get();
		
		//AddressDTO > (반환) > JSON
		//1. 직접 문자열로 만들기
		//2. JSONObject(simple-json.jar)
		//3. @ResponseBody + jack-databind(JSON)
		
		return dto;
	}
	
	
	
	//controller가 아닌 restcontroller해야함
	//restcontroller = controller + responseBody
	@GetMapping("/m2.do")
	public AddressDTO m2() {
		return dao.get();
	}
	
	
	
	//RestController  + jackson-databind = 반환값 형태
	
	//1. 단순 문자열 반환, encoding해야함 > 사용안함(무조건 JSON으로 반환 권장)
	@GetMapping(value="/m3.do", produces = "text/plain;charset=UTF-8")
	public String m3() {
		return dao.get().getName();
	}
	
	//2. 객체 반환
	@GetMapping(value="/m4.do")
	public AddressDTO m4() {
		return dao.get();
	}
	
	//3. 배열, 리스트 반환(JSON)
	@GetMapping("/m5.do")
	public List<AddressDTO> m5() {
		return dao.m5();
	}
	

}



























