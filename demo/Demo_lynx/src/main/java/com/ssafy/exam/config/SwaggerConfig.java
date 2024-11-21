package com.ssafy.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.exam.controller.SpecialtyRestController;
import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration 
public class SwaggerConfig {
	
	@Bean 
	public OpenAPI openAPI() {
		return new OpenAPI().components(new Components()) 
				.info(apiInfo()); 
	}

	private Info apiInfo() {
		return new Info().title("병원의사 정보 REST API 문서") 
				.description("<h3>의사 정보를 위한 REST API 문서입니다.</h3>") // API 설명을 설정합니다.
				.version("1.0.0"); 
	}
	
}
