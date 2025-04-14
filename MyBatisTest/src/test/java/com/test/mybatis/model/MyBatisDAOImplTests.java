package com.test.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //servlet-context를 읽기 위한 어노테이션
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml", //db작업을 위해 필요
								"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //package 스캔을 위해 필요

public class MyBatisDAOImplTests {
	
	//필드주입
	@Autowired
	private MyBatisDAOImpl dao;
	
	@Test
	public void testGetDAO() {
		assertNotNull(dao);
	}
	
	@Test
	public void testSelectOne() {
		int count = dao.m5();
		assertEquals(16, count); //16 : db의 select count(*) from tbladdress 의 값
	}
	
	@Test
	public void testSelectDTO() {
		AddressDTO dto = dao.m6("10");
		//assertNotNull(dto);
		assertEquals("독수리", dto.getName());
	}
	
	
	//없는 회원 번호를 넣었을때
	@Test
	public void testSelectDTO2() {
		AddressDTO dto = dao.m6("20");
		assertNull(dto);
	}
	
	
	@Test
	public void testSelectList() {
		List<String> names = dao.m7();
		System.out.println(names);
		assertEquals(16,names.size());
	}
	
	
	
	@Test
	public void testSelectList2() {
		List<AddressDTO> list = dao.m8();
		System.out.println(list);
		assertEquals(16,list.size());
	}
	
	
	@Test
	public void testTableName() {
		//m9?do?table=tblInsa
		String tableName = "tblInsa";
		
		int count = dao.m9(tableName);
		System.out.println(count);
		
		assertEquals(60,count);
	}
		
	@Test
	public void m10() {
		
		List<AddressDTO> list = dao.m10(15);
		System.out.println(list);
		assertEquals(9, list.size());
		
	}
	
	@Test
	public void m11() {
		String word="강남";
		List<AddressDTO> list = dao.m11(word);
		System.out.println(list);
		
	}
	
	
	@Test
	public void m12() {
		String gender="f";
		List<AddressDTO> list = dao.m12(gender);
		System.out.println(list);
		
	}
	
	
	@Test
	public void m13() {
		
		// 검색
		//1. 나이로 검색
		//2. 주소로 검색
		//3. 성별로 검색
		
		AddressDTO dto = new AddressDTO();
		dto.setAge("18");
		dto.setAddress("강남");
		dto.setGender("m");
		
		List<AddressDTO> list = dao.m13(dto);
		System.out.println(list);
		System.out.println(list.size());
	}
	
	
	@Test
	public void m14() {
		List<AddressDTO> list = dao.m14("m");
		System.out.println(list);
		System.out.println(list.size());
	}
	
	
	@Test
	public void m15() {
		
		List<String> search = new ArrayList<String>();
		search.add("영업부");
		search.add("총무부");
		search.add("개발부");
		
		List<InsaDTO> list = dao.m15(search);
		
		System.out.println(list);
		System.out.println(list.size());
		
	}
	
	
	
	@Test
	public void m16() {
		
		AddressDTO dto1 = new AddressDTO();
		dto1.setName("라라라");
		dto1.setAge("20");
		dto1.setAddress("서울시 서초구");
		dto1.setGender("m");
		
		
		AddressDTO dto2 = new AddressDTO();
		dto2.setName("바바바");
		dto2.setAge("22");
		dto2.setAddress("서울시 서초구");
		dto2.setGender("m");
		
		List<AddressDTO> list = new ArrayList<>();
		list.add(dto1);
		list.add(dto2);
		
		dao.m16(list);
	}
	
	
	@Test
	public void m17() {
		//고객  - 구매 이력 - 구매
		//1.	- 1,A		- A
		
		
		//1.insert
		//2. 방금 insert한 레코드의 pk 가져오기
		
		//일반적인 방법
		//1. insert
		//2. select max(PK)
		
		AddressDTO dto = new AddressDTO();
		dto.setName("바바바");
		dto.setAge("28");
		dto.setAddress("서울시 강남구");
		dto.setGender("m");
		
		//dao.m17add(dto);
		//int seq = dao.m17get();
		
		//System.out.println(seq);
		
		dao.m17add2(dto);
		System.out.println(dto);
		
	}

	
	@Test
	public void m18a() {
		
		//join의 결과 > DTO 새로 정의 해야함 = AddressDTO + InfoDTO
		// 장점 : 단순함(쉬움)
		// DTO가 많이 생김;;
		
		List<AddressInfoDTO> list = dao.m18a();
		
		System.out.println(list);
		System.out.println(list.size());
		
		
	}
	
	@Test
	public void m18b() {
		List<AddressDTO> list = dao.m18b();
		for(AddressDTO dto : list) {
			System.out.println(dto);
			System.out.println();
		}
	}

}



















