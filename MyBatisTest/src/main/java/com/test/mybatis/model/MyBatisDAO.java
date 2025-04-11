package com.test.mybatis.model;

import java.util.HashMap;

public interface MyBatisDAO {

	void m1();

	int m2(String seq);

	int m3(HashMap<String, String> map);

	int m4(AddressDTO dto);
	
	//select count(*) from tblAddress
	int m5();

}
