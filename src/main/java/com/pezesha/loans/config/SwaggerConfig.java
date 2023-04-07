//package com.pezesha.loans.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Bean
//    public Docket accountControllerApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("AccountController Api")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.pezesha.loans.controller.AccountController"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    @Bean
//    public Docket transferControllerApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("TransferController Api")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.pezesha.loans.controller.TransferController"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("My API")
//                .description("API documentation for my Pezesha tech test")
//                .version("1.0")
//                .build();
//    }
//}
