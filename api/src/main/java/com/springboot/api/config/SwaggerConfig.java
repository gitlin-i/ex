package com.springboot.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "API 명세서",
                description = "API 명세서 테스트 입니다.",
                version = "v1"))
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi defalutapi(){
        return GroupedOpenApi.builder()
                .group("-defalut")
                .pathsToMatch("/**")
                .build();
    }


}