package com.test.begin2.di9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트 용 자바 클래스 > JUnit > 단위 테스트 도구
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DITest {

	//의존 주입 어노테이션
	@Autowired
	private Hong hong;
	
	@Test
	public void testExist() {
		//System.out.println("테스트 메서드");
		
		//System.out.println(hong == null);
		//hong.work();
		
		//테스트 검증용 메서드
		assertNotNull(hong);
		
	}
	
	@Test
	public void testOther() {
		int num=100;
		assertEquals(100,num);
	}
	
}
