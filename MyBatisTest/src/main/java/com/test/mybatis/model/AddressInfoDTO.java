package com.test.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AddressInfoDTO {
	
	//tbladdress
	private String aseq;
	private String name;
	private String age;
	private String address;
	private String gender;
	
	//tblinfo
	private String iseq;
	private String school;
	private String country;

}
