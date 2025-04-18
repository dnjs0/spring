package com.test.food.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FoodDAO {
	
	private final SqlSessionTemplate template;
	
	//CRUD > 60%~80% 구현
	
	
	//tblCategory
	// - R
	public List<CategoryDTO> listCategory(){
		return template.selectList("food.listCategory");
	}
	
	public List<CategoryDTO> getCategory(String seq){
		return template.selectList("food.getCategory",seq);
	}
	
	
	
	
	
	
	
	//tblFood
	//- CR (쓰기, 읽기)
	//쓰기
	public int addFood(FoodDTO dto) {
		
		return template.insert("food.addFood",dto);
	}
	
	//조건 없는 리스트
	public List<FoodDTO> listFood(){
		return template.selectList("food.listFood");
	}
	
	
	//조건 있는 리스트
	
	
	
	
	
	
	
	//tblMenu
	//- CR
	//파싱해서 insert
	//조건부 리슽트
	public int addMenu(MenuDTO dto) {
		return template.insert("food.addMenu",dto);
	}
	
	public List<MenuDTO> listMenu(String food){
		return template.selectList("food.listMenu",food);
	}
	
	
	
	
	
	
	
	
	
	
	
}




















