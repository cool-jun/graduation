package com.hj.aftersaleservice.config;

import com.hj.aftersaleservice.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    private static final List<String> EXCLUDE_PATH = Arrays.asList("/", "/index.html", "/adminlogin.html",
            "/userlogin", "/adminlogin", "/css/**", "/fonts/**", "/images/**", "/js/**", "/localjs/**");

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/adminlogin.html").setViewName("adminlogin");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
//    }
}
