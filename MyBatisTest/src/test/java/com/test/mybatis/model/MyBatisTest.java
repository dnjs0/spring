package com.test.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Test
	public void testGetTemplate() {
		assertNotNull(template);
	}
	
	@Test
	public void testExecuteQuery() {
		int count = template.selectOne("test.insa");
		System.out.println(count);
		assertEquals(60,count);
	}
}
