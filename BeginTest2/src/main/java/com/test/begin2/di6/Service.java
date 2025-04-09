package com.test.begin2.di6;

public class Service {
	public void use() {
		//Service <- (의존 관계) -> Hong
		// - Service 객체는 Hong 객체를 의존한다.
		// - Hong 객체를 Service 객체의 의존객체이다.
		Hong hong = new Hong();
		hong.work();
	}
}
