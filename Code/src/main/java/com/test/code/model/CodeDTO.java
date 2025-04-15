package com.test.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CodeDTO {
	private String seq;
	private String subject;
	private String code;
	private String regdate;
	private String language;
	
	//본인과 부모사이 관계 1:1 > object로 만들기
	private LanguageDTO category;
}
