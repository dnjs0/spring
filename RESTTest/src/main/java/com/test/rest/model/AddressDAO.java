package com.test.rest.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddressDAO {
	
	private final SqlSessionTemplate template;

	public AddressDTO get() {
		return template.selectOne("rest.get");
	}

	public List<AddressDTO> m5() {
		return template.selectList("rest.m5");
	}

	public AddressDTO m6() {
		//고양이 하나만 갖고오니까 selectone
		//메모들은 쿼리로 잘 짜기
		return template.selectOne("rest.m6");
	}

	public int add(AddressDTO dto) {
		

		return template.insert("rest.add",dto);
	}

	public List<AddressDTO> list() {
		return template.selectList("rest.list");
	}

	public int edit(AddressDTO dto) {
		return template.update("rest.edit",dto);
	}

	public int del(String seq) {
		return template.delete("rest.del",seq);
	}

	public AddressDTO search(String seq) {

		return template.selectOne("rest.search",seq);
	}
	
}
