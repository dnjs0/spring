package com.test.begin.di3;

public class Service {
	
	private Employee employee;
	
	
	//의존 객체를 주입받는다.
	//public Service(Hong hong) {
	//	this.hong=hong;
	//}
	
	public void setEmployee(Hong employee) {
		this.employee=employee;
	}
	
	public void setEmployee(Lee employee) {
		this.employee=employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	
	public void use() {
		//본인 업무 구현
		
		
		//일부 업무 > 위임
		//******여태까지의 방식
		//- 필요로 하는 의존 객체를 직접 생성 + 사용했다.
		//Hong hong = new Hong();
		employee.work(); //NullPointerException
		
		
		//본인 업무 구현
		
		
	}

}
