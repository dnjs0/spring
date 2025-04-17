package com.test.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	//2. 반환값 > JSON 반환 > 단일값(객체) or 배열(컬렉션)
	
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
	
	//1. 단순 문자열 반환(encoding해야함) > 사용안함(무조건 JSON으로 반환 권장)
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
	
	//4. 혼합 - 고양이 한마리 + 메모들 가져오기
	@GetMapping("/m6.do")
	public AddressDTO m6(){
		return dao.m6();
	}
	
	
	//REST
	// -tblAddress > CRUD
	
	//추가하기
	//1. http://localhost:8090/rest/address
	//2. POST
	//3. return int (잘 돌려주면 1 실패하면 0)
	@PostMapping("/address")
	public int add(@RequestBody AddressDTO dto) {
		
		//x-www-form-urlencoded > @RequestParam AddressDTO dto
		//JSON > @RequestBody AddressDTO dto
		
		System.out.println(dto);
		int result = dao.add(dto);
		return result;
	}
	
	
	
	
		//목록보기
		//1. http://localhost:8090/rest/address
		//2. GET
		//3. return List<DTO> > (변환) > JSON
		@GetMapping(value="/address")
		public List<AddressDTO> list() {
			
			return dao.list();
		}
		
		
		//수정하기
		//1. http://localhost:8090/rest/address/1
		//2. PUT
		//3. return int
		//@RequestMapping(value="/a", method=RequestMethod.PUT)
		@PutMapping(value = "/address/{seq}") //경로 변수(Path Variable)
		public int edit(@PathVariable("seq") String seq, @RequestBody AddressDTO dto) {
			dto.setSeq(seq);
			return dao.edit(dto);
		}
		
		
		
		//삭제하기
		//1. http://localhost:8090/rest/address/1
		//2. DELETE
		//3. return int
		@DeleteMapping(value = "/address/{seq}") 
		public int del(@PathVariable("seq") String seq) {

			return dao.del(seq);
		}
		
		
		//검색하기
		//1. http://localhost:8090/rest/address/1
		//2. GET
		//3. return AddressDTO
		@GetMapping(value="/address/{seq}")
		public AddressDTO search(@PathVariable("seq") String seq) {
			return dao.search(seq);
		}
		
		
		
		
		
		

}



























