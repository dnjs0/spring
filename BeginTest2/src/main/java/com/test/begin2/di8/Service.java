package com.test.begin2.di8;

public class Service {
	//2. 멤버변수로 승격
	private Hong hong;
	
	//3. 의존 주입 도구 생성(생성자 or Setter)
	public Service(Hong hong) {
		this.hong = hong;
	}
	
	public void use() {
		//1. 직접 생성X
		//Hong hong = new Hong();
		

		hong.work();//여전히 hong을 의존하고있다
	}
}
