package com.test.web.model;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString

public class AddressDTO {
	private String name;
	private Integer age;
	private String address;
	
	//강제로 setter만들수도있음!(중첩 가능한듯)
	public void setAg(Integer age) {
		this.age=age;
	}

}
