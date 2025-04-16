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
	
}
