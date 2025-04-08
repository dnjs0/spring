package com.test.begin.di1;

public class Service {
	private Hong hong;
	private Lee lee;
	
	
	//의존 객체를 주입받는다.
	//생성자
	//public Service(Hong hong) {
	//	this.hong=hong;
	//}

	//set
	public void setHong(Hong hong) {
		this.hong=hong;
	}
	
	public void setLee(Lee lee) {
		this.lee=lee;
	}
	
	public void use() {
		//본인 업무 구현
		
		
		//일부 업무 > 위임
		//******여태까지의 방식
		//- 필요로 하는 의존 객체를 직접 생성 + 사용했다.
		//Hong hong = new Hong();
		//hong.work(); //NullPointerException
		
		//Lee lee = new Lee();
		 lee.work();
		
		
		//본인 업무 구현
		
		
	}

}
