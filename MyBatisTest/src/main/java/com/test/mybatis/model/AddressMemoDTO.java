package com.test.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AddressMemoDTO {
	//addressDTO
	private String addrseq;
	private String name;
	private String age;
	private String address;
	private String gender;
	
	//memoDTO
	private String mseq;
	private String memo;
	private String regdate;
	private String aseq;
	
}
