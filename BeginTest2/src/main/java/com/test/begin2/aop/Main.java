package com.test.begin2.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		/*
		 * //메모장 구현 Memo memo = new MemoImpl();
		 * 
		 * //글쓰기 memo.add("메모장입니다");
		 * 
		 * //글 읽기 try { String content = memo.read("1"); System.out.println(content); }
		 * catch (Exception e) { e.printStackTrace(); }
		 * 
		 * 
		 * //글 수정하기 System.out.println(memo.edit("2", "수정된 메모"));
		 * 
		 * //글 삭제 System.out.println(memo.del("3"));
		 */
		
		
		
		
		
		
		/*
		 * Logger logger = new Logger();
		 * 
		 * //메모장 구현 Memo memo = new MemoImpl();
		 * 
		 * //글쓰기 memo.add("메모장입니다"); logger.log();
		 * 
		 * //글 읽기 try { String content = memo.read("1"); System.out.println(content); }
		 * catch (Exception e) { e.printStackTrace(); } logger.log();
		 * 
		 * 
		 * 
		 * //글 수정하기 System.out.println(memo.edit("2", "수정된 메모")); logger.log();
		 * 
		 * 
		 * //글 삭제 System.out.println(memo.del("3")); logger.log();
		 */

		
		
		
		
		//메모장 구현 
		//Memo memo = new MemoImpl();
		 
		
		//내가 만들면 안되고 spring시켜서 bean 만들어야함
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin2/aop/memo.xml");
		Memo memo = (Memo)context.getBean("memo");
		
		 //글쓰기 
		//memo.add("메모장입니다");
		  
		 //글 읽기 
		try { 
			String content = memo.read("1"); 
			System.out.println(content); 
			System.out.println(memo.read("7"));
		}catch (Exception e) {
			//e.printStackTrace(); 
			System.out.println("예외처리");
		}
		  
		  
		  //글 수정하기 
		 //System.out.println(memo.edit("2", "수정된 메모"));
		 
		 //글 삭제 
		 //System.out.println(memo.del("3"));
		
		
		
	}
}




































