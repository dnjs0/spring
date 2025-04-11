package com.test.mybatis.model;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyBatisDAOImpl implements MyBatisDAO {
	//JDBC 설정 > MyBatis 설정
	private final SqlSessionTemplate template;

	//아래 코드는 @RequiredArgsConstructor와 100%같은 코드임
	//public MyBatisDAOImpl(SqlSessionTemplate template) {
	//	this.template = template;
	//}
	
	
	
	
	/*
	
		MyBatis > Mapper XML을 사용해서 SQL를 XML에 작성한다.
		
		int stat.executeUpdate()
		- 반환값이 없는 쿼리
		- int template.insert(XML 매퍼네임스페이스.아이디)
		- int template.update()
		- int template.delete()
		
		ResultSet stat.executeQuery()
		- 반환값이 있는 쿼리
		- template.selectOne() > 결과셋의 레코드 1개
		- template.selectList() > 결과셋의 레코드 N개
		
	 
	 */
	
	@Override
	public void m1() {
		
		//반환값(X), 인자값(X)
		template.insert("mybatis.m1");
		
	}


	@Override
	public int m2(String seq) {
		
		//반환값(X), 인자값(O)
		return template.delete("mybatis.m2",seq);
		
	}


	@Override
	public int m3(HashMap<String, String> map) {

		//반환값(X), 인자값(O)
		return template.update("mybatis.m3", map);
		
	}


	@Override
	public int m4(AddressDTO dto) {
		//반환값(X), 인자값(O)
		
		return template.insert("mybatis.m4",dto);
	}


	@Override
	public int m5() {
		//반환값(O), 인자값(X)
		// - 단일값 반환(1행 1열)
		
		//selectOne : 자동으로 ResultSet 만들어서 mapping해줌
		return template.selectOne("mybatis.m5");
	}
	
	
	
}























