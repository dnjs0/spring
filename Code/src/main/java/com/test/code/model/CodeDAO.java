package com.test.code.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CodeDAO {

	private final SqlSessionTemplate template;
	
	
	//쓰기
	//1. 카테고리 선택 > select 
	//2. 쓰기 > insert
	
	public List<LanguageDTO> clist(){
		return template.selectList("code.clist");
	}
	
	
	public int add(CodeDTO dto) {
		return template.insert("code.add",dto);
	}
	
	public List<CodeDTO> list() {
		return template.selectList("code.list");
	}
	
	
	public CodeDTO view(String seq) {
		return template.selectOne("code.view",seq);
	}

}










