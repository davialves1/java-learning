package com.pricecalculation.employeemanagement.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class to set up swagger information.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build()
			.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		return new ApiInfo(
			"Employee Management",
			"Employee management application for the VW group",
			"1.0",
			"Terms of Service",
			new Contact(
				"Volkswagen",
				"www.vw.de/employees",
				"employees@vw.de"),
			"Volkswagen License Version 1.0",
			"https://www.vw.de/licenses/employee-management/",
			Collections.emptyList()
		);
	}

}
