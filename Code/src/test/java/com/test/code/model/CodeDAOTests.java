package com.test.code.model;

import static org.junit.Assert.assertEquals;

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
public class CodeDAOTests {
	
	//dao 테스트하는거니까 의존주입
	@Autowired
	private CodeDAO dao;
	
	@Test
	public void testCategory() {
		List<LanguageDTO> clist = dao.clist();
		assertEquals(5,clist.size());
	}

	
	
	@Test
	public void testAdd() {
		CodeDTO dto = new CodeDTO();
		dto.setSubject("자바 변수 만들기");
		dto.setCode("int a=10;");
		dto.setLanguage("Java");
		
		int result = dao.add(dto);
		assertEquals(1, result);
	}
	
	
}



















