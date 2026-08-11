package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;


@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		
		return new OpenAPI()
		        .info(new Info()
		                .title("Student API")
		                .version("1.0")
		                .description("Student Management REST API")
		                .contact(new Contact()
		                        .name("Dakshta Grover")
		                        .email("dakshta@example.com")))
		        .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
		        .components(new Components()
		                .addSecuritySchemes("basicAuth",
		                        new SecurityScheme()
		                                .type(Type.HTTP)
		                                .scheme("basic")));
	}
	
}
	

//	    return new OpenAPI()
//	            .info(new Info()
//	                    .title("Student API")
//	                    .version("1.0")
//	                    .description("Student Management REST API")
//	                    .contact(new Contact()
//	                            .name("Dakshta Grover")
//	                            .email("dakshta@example.com")));
//	}
//
//}
//
//
