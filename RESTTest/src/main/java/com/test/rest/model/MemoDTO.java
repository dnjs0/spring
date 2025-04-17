package com.test.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MemoDTO {
	private String seq;
	private String memo;
	private String regdate;
	private String aseq;
}
