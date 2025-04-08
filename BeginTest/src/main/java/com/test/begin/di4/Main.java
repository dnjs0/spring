package com.test.begin.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//상대 경로
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin/di4/di4.xml");
		
		/*
		 
		 Hong hong = (Hong)context.getBean("hong"); Service service =
		 (Service)context.getBean("service");
		 
		 service.setEmployee(hong);//의존 주입(DI) 
		 service.use();
		 
		 */
	
		
		
		//Main > Service > Hong
		//Main > Service > Lee
		
		//di1에서 객체 생성 순서
		//Main > Service > Hong
		
		//의존 주입 구현 후 ( 순서 바뀜 > 역제어 > IoC 패턴)
		// Main > Hong > Service
		
		
		Service service = (Service)context.getBean("service");
		
		service.use();
		
		
	}

}


























