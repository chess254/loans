//package com.pezesha.loans.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebMvc
//@EnableWebSecurity
//public class WebMvcConfig  extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//
//}