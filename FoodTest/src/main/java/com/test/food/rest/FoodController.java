package com.test.food.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.food.model.CategoryDTO;
import com.test.food.model.FoodDAO;
import com.test.food.model.FoodDTO;
import com.test.food.model.MenuDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "맛집 API", tags = "맛집 API")
public class FoodController {
	
	private final FoodDAO dao;
	
	//GET + http://localhost:8090/food/category > listCategory
	//GET + http://localhost:8090/food/category/1 > getCategory
	@ApiOperation(value = "카테고리 목록 조회", notes = "모든 카테고리를 조회합니다.")
	@ApiResponses({
		@ApiResponse(
			code = 200,
			message = "성공",
			response = CategoryDTO.class,
			responseContainer = "List"
		),
		@ApiResponse(
			code = 404,
			message = "카테고리 없음"
		)
	})	
	@GetMapping("/category") 
	public List<CategoryDTO> listCategory() {
		
		List<CategoryDTO> list = dao.listCategory();
		
		return list;
	}
	
	@ApiOperation(value = "특정 카테고리 조회", notes = "카테고리 번호를 특정 카테고리를 조회합니다.")
	@ApiResponses({
		@ApiResponse(
			code = 200,
			message = "성공",
			response = CategoryDTO.class
		),
		@ApiResponse(
			code = 404,
			message = "카테고리 없음"
		)
	})
	@GetMapping("/category/{seq}")
	public CategoryDTO getCategory(@ApiParam(value = "카테고리 번호", required = true, example = "1") @PathVariable("seq") String seq) {
		
		return dao.getCategory(seq);
	}
	
	//POST + http://localhost:8090/food/food > addFood
	//GET + http://localhost:8090/food/food > listFood
	
	@ApiOperation(value = "맛집 등록", notes = "맛집의 정보를 등록합니다.")
	@ApiResponse(
		code = 200,
		message = "1: 성공, 0: 실패"
	)
	@PostMapping("/food")
	public int addFood(@ApiParam(value = "등록할 맛집 정보", required = true) @RequestBody FoodDTO dto) {
				
		//return dao.addFood(dto);
		
		int result = dao.addFood(dto);
		
		System.out.println(dto.getSeq());
		
		//dto.getSeq()
		/*
			짜장면: 5,000
			짬뽕: 6,000
		*/
		String[] list = dto.getMenu().split("\n");
		
		for (String item : list) {
			
			String[] slist = item.trim().split(":");
			
			MenuDTO mdto = new MenuDTO();
			mdto.setName(slist[0].trim()); //메뉴명
			mdto.setPrice(slist[1].trim().replace(",","")); //가격
			mdto.setFood(dto.getSeq()); //맛집 seq
			
			System.out.println("mdto: " + mdto);
			
			result *= dao.addMenu(mdto);		
			
		}
		
		return result;
	}
	
	@ApiOperation(value = "맛집 조회하기", notes = "모든 맛집을 조회합니다.")
	@GetMapping("/food")
	public List<FoodDTO> listFood() {
		
		return dao.listFood();
	}
	
	@GetMapping("/food/{seq}")
	public FoodDTO getFood(@PathVariable("seq") String seq) {
		
		return dao.getFood(seq);
	}
	
	//POST + http://localhost:8090/food/menu > addMenu
	//GET + http://localhost:8090/food/menu/1 > listMenu
	
	@ApiOperation(value = "메뉴 등록", notes = "특정 맛집의 메뉴를 등록합니다.")
	@PostMapping("/menu")
	public int addMenu(@RequestBody MenuDTO dto) {
		
		return dao.addMenu(dto);
	}
	
	@ApiOperation(value = "메뉴 조회", notes = "특정 맛집의 메뉴를 조회합니다.")
	@GetMapping("/menu/{food}")
	public List<MenuDTO> listMenu(@PathVariable("food") String food) {
		
		return dao.listMenu(food);
	}
	
	

}













