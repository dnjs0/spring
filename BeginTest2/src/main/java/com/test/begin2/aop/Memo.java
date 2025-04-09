package com.test.begin2.aop;

public interface Memo {
	
	//메모 쓰기
	void add(String memo);
	
	//메모 읽기
	String read(String seq) throws Exception ;
	
	//메모 수정
	boolean edit(String seq, String memo);
	
	//메모 삭제
	boolean del(String seq);
}
