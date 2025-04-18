package com.test.food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//스프링 설정
//1. XML
//2. 어노테이션
//3. 자바


@Configuration //이전에 사용하던 스프링 환경 설전 XML역할
@EnableSwagger2 //Swagger2 > API기반의 문서를 생성 설정
public class SwaggerConfig {
	
	//API 명세서
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)	//Swagger2
							.apiInfo(getApiInfo())	//API 기본 정보
							.select()	//Docket 객체의 빌더 시작
							.apis(RequestHandlerSelectors.basePackage("com.test.food"))
							.paths(PathSelectors.any()) //모든 UTI에 대해서 명세
							.build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
					.title("Food REST API")	//REST API 제목
					.version("0.0.1")	//API Version
					.description("맛집 데이터 조작을 위한 REST API 명세입니다.") //설명
					.build();
	}
	

}
