package com.test.begin.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//스프링 설정 방식
		//1. XML
		//2. 어노테이션 방식
		//3. 자바 방식
		
		//Bean
		//- EJB > 객체를 빈이라고 표현
		//- 스프링 > 객체를 빈이라고 표현
		
		//객체 생성 > 스프링에게 부탁
		//1. XML > bean 정의(선언)
		//2. 스프링 컨테이너 생성
		
		//1.내가 객체를 만든것
		//Hong hong = new Hong();
		
		//절대경로
		//ApplicationContext context = new ClassPathXmlApplicationContext("/src/main/java/com/test/di3/di3.xml");
		
		//상대 경로
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin/di3/di3.xml");
		
		//빈을 얻어온다 > 객체를 생성해서 반환해주세요.
		//<bean id="hong" class="com.test.begin.di3.Hong"></bean>
		//id 적음
		//2. 스프링이 객체를 만든것
		Hong hong = (Hong)context.getBean("hong");
		hong.work();
		
		Lee lee = (Lee)context.getBean("lee");
		lee.work();
		
		Hong hong2 = (Hong)context.getBean("hong");
		hong.work();
		
		//같은 객체 > 나중에 설명
		System.out.println(hong.hashCode());
		System.out.println(hong2.hashCode());
		
		
	}

}


























