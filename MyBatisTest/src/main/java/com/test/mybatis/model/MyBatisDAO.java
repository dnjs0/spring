package com.test.mybatis.model;

import java.util.HashMap;
import java.util.List;

public interface MyBatisDAO {

	void m1();

	int m2(String seq);

	int m3(HashMap<String, String> map);

	int m4(AddressDTO dto);
	
	//select count(*) from tblAddress
	int m5();

	//select * from tblAddress where seq=10
	AddressDTO m6(String seq);
	
	//select name from tblAddress order by name asc
	List<String> m7();
	
	//select * from tblAddress order by name asc
	List<AddressDTO> m8();
	
	
	
	
	// 기본쿼리
	//------------------------------------------------------------------------------------------
	// 응용
	
	
	
	
	
	//컬럼명 or 테이블명 > 매개변수
	
	//m9.do?table=tblInsa
	//- select count(*) from tblInsa
	
	//m9.do?table=tblAddress
	//- select count(*) from tblAddress
	int m9(String tableName);
	
	
	//select * from tblAddress where age > 25
	List<AddressDTO>  m10(int age);
	
	
	//select * from tblAddress where address like '%강남%'
	List<AddressDTO> m11(String word);
	
	
	
	
	
	//정적 쿼리
	//매개변수 + 쿼리 > #{}
	//-------------------------------------------------------------
	//동적 쿼리 > 상황에 따른 SQL 구문이 변환됨
	List<AddressDTO> m12(String gender);
	
	
	
	List<AddressDTO> m13(AddressDTO dto);
	//test
	
	
	
	//- <choose>
	List <AddressDTO> m14(String type);
	
}























