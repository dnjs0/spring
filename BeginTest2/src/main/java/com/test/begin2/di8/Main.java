package com.test.begin2.di8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//스프링 컨테이너로부터 객체를 생성하기
		//1. XML > bean 선선
		//2. Java > getBean() 호출(=생성)
		
		//이전 코드
		Hong hong1 = new Hong();
		hong1.work();
		
		//스프링 코드
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin2/di8/di8.xml");
		Hong hong2 = (Hong)context.getBean("hong"); //new Hong()실행
		hong2.work();
		
		//Main > Service > Hong
		Service service = (Service)context.getBean("service");
		service.use();
		
		
	}

}
