package com.test.begin2.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

//보조 업무 객체
public class Logger {

	//보조 업무 구현
	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\r\n", now,now);
		
		
	}
	
	public void before() {
		System.out.println("Before Advice 보조 업무 실행");
	}

	public void after() {
		System.out.println("After Advice 보조 업무 실행");
	}
	
	public void around(ProceedingJoinPoint jp) {
		System.out.println("Around Advice 보조 업무 실행");
		System.out.println("주업무 실행전 > 보조 업무 실행");
		
		//주업무 실행
		// - jp : 프록시 객체
		try {
			jp.proceed(); //현재 실행된 주업무 객체의 메서드
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		System.out.println("주업무 실행후 > 보조 업무 실행");
	}
	
	public void afterreturning(Object memo) {
		System.out.println("After-returning Advice 보조 업무 실행 : "+memo);
	}
	
	public void afterthrowing(Exception e) {
		System.out.println("After-throwing Advice 보조 업무 실행");
		System.out.println(e.getMessage());
		//에러 발생 기록
		// - DB insert
		// - send email
	}
	
	
}
