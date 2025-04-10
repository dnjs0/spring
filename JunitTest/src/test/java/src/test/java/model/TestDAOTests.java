package src.test.java.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.test.java.model.TestDAO;

public class TestDAOTests {
	
	private static TestDAO dao;
	
	//before : 각 테스트를 실행하기 전에 먼저 실행해라
	//@Before

	//beforeclass : static으로 바꿔야함, 모든 테스트를 실행하기 전에 딱한번 먼저 실행해라
	@BeforeClass
	public static void begin() {
		dao = new TestDAO();
		System.out.println("begin");
	}

	
	//각 ㅌ테스트를 실행하고 난 후에 실행해라
	//@After
	//public void end() {
	//	System.out.println("end");
	//}
	
	
	@AfterClass
	public static void end() {
		System.out.println("end");
	}
	
	//테스트용 메서드명 > test + 이름()
	//@Ignore //이 테스트 진행 안하고싶을때
	@Test
	public void testDAO() {
//		System.out.println(111); > 개발자 디버깅 용
//		assertArrayEquals(null,null,null); > 테스트 평가
		
		//TestDAO dao = new TestDAO();
		String name = dao.getInsa("1");
		
		System.out.println(name+"1");//펑가(X)
		assertEquals("홍길동", name); //앞이 기대값, 뒤에가 진자 값
	}
	
	
	
	@Test
	public void testDAO2() {
//		System.out.println(111); > 개발자 디버깅 용
//		assertArrayEquals(null,null,null); > 테스트 평가
		
		//TestDAO dao = new TestDAO();
		String name = dao.getInsa("2");
		
		System.out.println(name+"2");//펑가(X)
		assertNotEquals("이순신", name); //앞이 기대값, 뒤에가 진자 값
	}
	
	
	//assertEquals(기대값, 실제값) : 값이 같은지?
	//assertNotEquals(반기대값, 실제값) : 값이 다른지 ?
	//assertTrue(결과) : 참인지?
	//assertFalse(결과) : 거짓인지 ?
	//assertNull(객체) : null인지?
	//assertNotNull(객체) : not null인지?
	//assertSame(기대객체, 실제객체) : 같은 객체인지?
	//assertNotSame(반기대객체, 실제객체) : 다른 객체인지?

}
