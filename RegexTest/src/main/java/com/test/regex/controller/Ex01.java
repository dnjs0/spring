package com.test.regex.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
	public static void main(String[] args) {
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
		
		
		
	}

	
	
	private static void m7() {
		// 유효성 검사
		
		//회원 가입 중
		// - 아이디(영문자 + 숫자 + _) 4~12자, 숫자로 시작 불가능
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		
		String id = scan.nextLine();
		
		if(validate(id)) {
			System.out.println("올바른 아이디");
		}else {
			System.out.println("올바르지 않은 아이디");
		}
	 
	}



	private static boolean validate(String id) {

		String regex = "^[A-Za-z_]{1}[A-Za-z0-9_]{3,11}$"; 
				
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(id);
		
		return m1.find();
	}



	private static void m6() {
		String txt="\r\n"
				+ "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>카페 메뉴</h1>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div><img src=\"images/coffee/m01.png\"></div>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div><img id=\"m02\" src=\"images/coffee/m02.png\"></div>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div><img src=\"images/coffee/m03.png\" class=\"coffee\"></div>\r\n"
				+ "    <div></div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		
		
		// <img>태그 src속성 값??
		String regex = "<img[^>]*\\bsrc\\s*=\\s*[\"']([^\"']+)[\"']";
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println("src : "+m1.group(1));
		}
		
		
		
		
	}



	private static void m5() {

		String txt = "안녕하세요 홍길동입니다. 옆에는 제 친구 김길동입니다. 그리고 뒤에는 제 후배 최길동입니다. 그냥 편하게 저는 길동이라고 불러주세요. 아 그리고 남궁길동도 있습니다.";
		
		//요구사항] 모든 길동이 찾기!!!
		// - 홍길동
		// - 김길동
		// - 최길동
		// - 길동
		// - 남궁길동

		//String regex = "[홍김최]?길동";
		
		//String regex = "(홍|김|최|남궁|)(길동)";
		String regex = "(홍|김|최|남궁)?(길동)";
		
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println("찾은 이름 : "+m1.group());
			System.out.println("성 : "+m1.group(1));
			System.out.println("이름 : "+m1.group(2));
			System.out.println();
		}
		
	}



	private static void m4() {
		
		String txt="[OSEN=잠실, 한용섭 기자] 프로야구 LG 트윈스 투수 김주온(29)이 프로 입단 후 11년 만에 처음으로 선발 등판 기회를 받게 됐다. LG는 외국인 투수 엘리에이저 에르난데스가 16일 우측 대퇴부 대내전근 손상으로 1군 엔트리에서 제외됐다. 장기 이탈이다. 회복까지 6주가 걸릴 전망이다. LG는 부상 대체 외국인 선수를 알아볼 계획. 당장 에르난데스가 빠진 선발 로테이션 자리에 임시 선발로 김주온이 들어간다. 염경엽 감독은 16일 잠실구장에서 에르난데스의 부상을 설명하며 “김주온이 지금 2군에서 제일 좋다고 추천을 받았다. 일요일(SSG전)에 선발로 던진다”고 말했다. dnjs@naver.com김주온은 올해 2군에서 5경기 등판해 4승 1패 평균자책점 5.23을 기록하고 있다. 한 차례 7실점을 허용하면서 평균자책점이 높다. 김주온은 3월 14일 열린 2025 퓨처스리그 개막전 두산 베어와 경기에 선발투수로 등판, 6이닝 4피안타 1볼넷 6탈삼진 1실점으로 잘 던졌다. 직구 최고 구속 148km를 기록했다. 이후 고양 히어로즈 상대로 6이닝 3실점 승리를 기록했고, 지난 9일 SSG 랜더스전에서 4이닝 1실점이 가장 최근 기록이다. 김주온은 2015년 신인 드래트프에서 2차 7라운드 전체 72순위로 삼성 라이온즈의 지명을 받았다. 삼성 입단 후 줄곧 2군에서만 뛰었고, 2017년 11월 열린 2차 드래프트에서 SK와이번스로 팀을 옮겼다.김주온은 이적 후 군 복무를 마치고 2020년 1군 무대에 데뷔했다. 2020년 29경기(31이닝)에 등판해 3패 평균자책점 7.55를 기록했다. 1군에서 가장 많이 던진 시즌이었다. 이후 1군에서는 2021년 2경기(2이닝), 2022년 5경기(4이닝), 2023년 1경기(0⅓이닝) 등판했다. 2024년 2경기(4⅔이닝) 평균자책점 15.43을 기록하고, 6월 SSG에서 방출됐다. 1군 통산 성적은 fssedf@gmail.com39경기(42이닝) 승리 없이 3패 평균자책점 9.00을 기록했다. 모두 구원투수로 등판했다.LG는 웨이버 공시 시간에 김주온의 잔여 연봉 1500만원을 부담하면서 영입했다. 당시 염경엽 감독은 “좋은 선택이라고 생각한다. 연봉 1500만 원이면 2차 10번 정도 아닌가. 그 정도 경험하고 148km 이상 던지는 투수를 2차 10번에 못 뽑지 않나”라며 투자 대비 효율성을 언급했다. 가능성 있는 선수들 모아서 육성을 한다면 성공 가능성이 있다고 봤다. 김주온은 지난해 SSG에서 웨이버 방출되기 전에 퓨처스리그 10경기(선발 7경기, 35⅔이닝)에 등판해 1승 2패 1홀드 평균자책점 2.78을 기록했다. 또 염 감독은 “김주온은 엄청난 경험을 한 번 했다. 인생에서 아주 쓴 맛(방출)을 한 번 보지 않았나. 얼마나 절실하겠나. 절실함이 생기면 모든 게 바뀐다. 그런 플러스 요인도 생각한다”고 말했다. ";
		
		String regex="([\\w\\.=-]+)@([\\w\\.-]+\\.[\\w]{2,3})";
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println(m1.group());
			System.out.println("아이디 : "+ m1.group(1));
			System.out.println("도메인 : "+m1.group(2));
			System.out.println();
		}
		
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


























