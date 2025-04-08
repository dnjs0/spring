package com.test.begin.di2;

public class Main {
	public static void main(String[] args) {
		
		//의존 관계
		
		
		// Main > (의존) > Service > (의존) > Hong
		// 사장	> 팀장	> 직원 
		
		//Service 객체는 Main의 의존 객체이다.
		//Hong 객체는 Service의 의존 객체이다.
		
		
		//******여태까지의 방식
		//- 필요로 하는 의존 객체를 직접 생성 + 사용했다.
		//Service service = new Service();
		
		//Hong hong = new Hong();
		//Lee lee = new Lee();
		
		//Employee employee = new Hong();
		Employee employee = new Lee();
		
		//Service service = new Service(hong); //의존 주입(DI패턴)
		
		Service service = new Service();
		service.setEmployee(employee);//의존 주입
		service.use();
		
		
	}

}
