package com.test.begin2.di9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * @Component public class Service { private Hong hong;
 * 
 * //의존 주입 도구에 @Autowired를 선언 //- Spring 2.5부터 지원됨(오래됨)
 * 
 * @Autowired public Service(Hong hong) { this.hong = hong; }
 * 
 * public void use() { hong.work(); } }
 */





/*
 * @Component public class Service { private Hong hong;
 *
 *setter에 @Autowired 선언 
 * @Autowired public void setHong(Hong hong) { this.hong=hong; }
 * 
 * public void use() { hong.work(); } }
 */




/*
 * @Component public class Service { //멤버 변수에 직접 @Autowired 선언 //- 의존 주입 도구(생성자,
 * Setter)가 필요 ㅓㅇㅄ다. //- 가장 단순한 방법 //- 테스트와 유지보수가 어렵다.
 * 
 * @Autowired private Hong hong;
 * 
 * 
 * public void use() { hong.work(); } }
 */





@Component
public class Service {
	
	private Hong hong;
	
	//생성자가 1개라면 별도의 선언 없이 의존 주입이 발생
	public Service(Hong hong) {
		this.hong=hong;
	}
	
	public void use() {
		hong.work();
	}
}















