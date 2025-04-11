package com.test.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

}
