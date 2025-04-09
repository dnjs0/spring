package com.test.begin2.aop;

public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {
		System.out.println("메모 쓰기 :" + memo);
		
		//Logger logger = new Logger();
		//logger.log();
		
	}

	@Override
	public String read(String seq) throws Exception {
		
		//Logger logger = new Logger();
		//logger.log();
		
		if(seq.equals("1")) {
			return "안녕하세요";
		}else if(seq.equals("2")) {
			return "홍길동입니다";
		}else if(seq.equals("3")) {
			return "메모 테스트";
		}else {
			throw new Exception("존재하지 않는 메모");
		}
	}

	@Override
	public boolean edit(String seq, String memo) {
		System.out.println("메모 수정 : "+memo);
		//Logger logger = new Logger();
		//logger.log();
		return true;
	}

	@Override
	public boolean del(String seq) {
		System.out.println("메모 삭제 : " + seq);
		//Logger logger = new Logger();
		//logger.log();
		return true;
	}
	
}
