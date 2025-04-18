package com.test.food.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodDTO {
	private String seq;
	private String name;
	private String description;
	private String category;
	private String lat;
	private String lng;
	
	private String markerImage; //서브쿼리
	
	private String menu;
	
	private List<MenuDTO> mlist;
	
}






