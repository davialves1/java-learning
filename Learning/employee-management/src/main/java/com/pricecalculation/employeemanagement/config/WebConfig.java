package com.pricecalculation.employeemanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowCredentials(true)
			.allowedOrigins("http://localhost:3000")
			.allowedMethods("*")
			.allowedHeaders("*")
			.exposedHeaders("Access-Control-Allow-Origin",
				"Access-Control-Allow-Methods",
				"Access-Control-Allow-Headers",
				"Access-Control-Max-Age",
				"Access-Control-Request-Headers",
				"Access-Control-Request-Method");
	}
}
