package com.test.food.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(description = "카테고리 DTO")
public class CategoryDTO {
	
	@ApiModelProperty(value="카테고리 번호", example="1")
	private String seq;
	
	@ApiModelProperty(value="카테고리명", example="한식")
	private String name;
	
	@ApiModelProperty(value="마커 이미지명", example="food.png")
	private String marker;
}
