package com.test.food.model;

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
}
