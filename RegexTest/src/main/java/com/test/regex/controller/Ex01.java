package com.test.regex.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
	public static void main(String[] args) {
		
		
		//m1();
		//m2();
		m3();
		
	}

	
	
	private static void m3() {

		// 자바의 정규식 지원 클래스
		String txt = "안녕하세요 홍길동입니다. 제 연락처는 010-1234-5678입니다. 혹시 연락이 안되면  010-5555-6666으로 연락주세요. 그래도 연락이 안되면 010-9988-6666으로 연락을 주십쇼.";
		
		
		//1. txt 내에 전화번호가 포함되어 있는지? 네,아니오 
		//String regex = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		String regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		
		//패턴 객체 = 검색 도구
		Pattern p1 = Pattern.compile(regex);
		
		//검색
		Matcher m1 = p1.matcher(txt);
		//System.out.println(m1); 항상 변환
		//System.out.println(m1.find());
		
		//if(m1.find()) {
		//	System.out.println("txt내에서 전화번호 발경!1");
		//}else {
		//	System.out.println("txt내 전화번호 업음!");
		//}
		
		
		//2. 전화번호 검색 > 각각구분?
		//내부에 커서강있음
		//System.out.println(m1.find());//010-1234-5678
		//System.out.println(m1.find());//010-5555-6666
		//System.out.println(m1.find());//010-9988-6666
		//System.out.println(m1.find());//false

		//int count = 0;
		//while(m1.find()) {
		//	count++;
		//}
		//System.out.printf("전화번호가 총 %d회 발견되었습니다.\r\n",count);
		
		
		
		//3. 전화번호 검색 > 찾은게 뭔데
		while(m1.find()) {
			
			System.out.println("전화번호 : "+ m1.group());
			System.out.println("통신사 : "+ m1.group(1));
			System.out.println("전화번호 앞자리: "+ m1.group(2));
			System.out.println("전화번호 뒷자리: "+ m1.group(3));
			System.out.println();
			
		}
		
		
		
		
		
	}



	private static void m2() {

		String txt = "홍길동;아무개,,강아지,고양이,거북이 타조";
		
		//분리!
		//String[] list = txt.split("\\.");
		String[] list = txt.split("[;,\\s]+"); //  \\s : 스페이스
		
		System.out.println(list.length);
		
		for(String item : list) {
			System.out.println(item);
		}
		
	}
	
	
	

	private static void m1() {
		//자바 > 기존의 여러 메서드에서 정규 표현식을 지원한다.
		
		//게시판 > 글쓰기 > 개인정보(전화번호) 마스킹
		String txt = "안녕하세요 홍길동입니다. 제 연락처는 010-1234-5678입니다. 혹시 연락이 안되면  010-5555-6666으로 연락주세요. 그래도 연락이 안되면 010-9988-6666으로 연락을 주십쇼.";
		
		//System.out.println(txt.replace("010-1234-5678", "xxx-xxxx-xxxx"));
		
		
		
		//정규 표현식으로 전화번호 찾기
		// - [0-9]{3}-[0-9]{4}-[0-9]{4}
		// - [0-9]{3}-[0-9]{3,4}-[0-9]{4}
		// - 010-[0-9]{3,4}-[0-9]{4}
		// - \d{3}-\d{4}-\d{4}
		
		//이메일
		//- hong@gmail.com
		//- [\w\.=-]+@[\w\.-]+\.[\w]{2,3}
		
		//http://regexlib.com
		
		System.out.println(txt.replaceAll("\\d{3}-\\d{4}-\\d{4}", "xxx-xxxx-xxxx"));
		System.out.println(txt.replaceAll("[0-9]{3}-[0-9]{4}-[0-9]{4}", "xxx-xxxx-xxxx"));
		System.out.println(txt.replaceFirst("[0-9]{3}-[0-9]{4}-[0-9]{4}", "xxx-xxxx-xxxx"));
		System.out.println(txt.replaceAll("010([-\\.]?)\\d{4}\\1\\d{4}", "xxx-xxxx-xxxx"));
		
	}

}


























