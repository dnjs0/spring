package com.test.food.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FoodDAO {
	
	private final SqlSessionTemplate template;
	
	//CRUD > 60~80% 구현
	
	//tblCategory
	//-R
	public List<CategoryDTO> listCategory() {
		
		return template.selectList("food.listCategory");
	}
	
	public CategoryDTO getCategory(String seq) {
		
		return template.selectOne("food.getCategory", seq);
	}
	
	//tblFood
	//- CR
	public int addFood(FoodDTO dto) {
		
		return template.insert("food.addFood", dto);
	}
	
	public List<FoodDTO> listFood() {
		
		return template.selectList("food.listFood");
	}
	
	//tblMenu
	//- CR
	public int addMenu(MenuDTO dto) {
		
		return template.insert("food.addMenu", dto);
	}
	
	public List<MenuDTO> listMenu(String food) {
		
		return template.selectList("food.listMenu", food);
	}

	public FoodDTO getFood(String seq) {
		
		return template.selectOne("food.getFood", seq);
	}
	
}







































