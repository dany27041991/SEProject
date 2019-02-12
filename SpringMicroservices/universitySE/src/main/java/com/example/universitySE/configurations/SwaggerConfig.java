/* package com.example.universitySE.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.universitySE"))
                .paths(regex("/user.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Microservice for Software Engineering Project",
                "Documentation Rest API with Swagger.",
                "API TOS",
                "https://github.com/dany27041991/SEProject",
                new Contact("Danilo Giovannico ed Ilaria Malinconico", "https://github.com/dany27041991/SEProject", "danilo.giovannico@studenti.unisalento.it ed ilaria.malinconico@studenti.unisalento.it"),
                "License of API", "API license URL", Collections.emptyList());
    }
} */