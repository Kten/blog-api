package com.theodore.blog.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	@Profile({ "local", "alpha" })
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.theodore.blog.api.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}

	@Bean
	@Profile("production")
	public Docket disable() {
		return new Docket(DocumentationType.SWAGGER_2)
			.enable(false);
	}

	private ApiInfo apiInfo() {

		return new ApiInfo(
			"Theodore Blog Api",
			"테디 블로그 API 명세서",
			"1.0",
			"",
			new Contact("Theodore.Park Email", "", "rhkdduf63@gmail.com"),
			"",
			"",
			Collections.emptyList()
		);
	}
}
