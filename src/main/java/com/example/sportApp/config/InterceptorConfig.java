package com.example.sportApp.config;

import com.example.sportApp.Interceptor.MyInterceptor1;
import com.example.sportApp.Interceptor.MyInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor1 myInterceptorOne;
    @Autowired
    private MyInterceptor2 myInterceptorTwo;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 拦截路径 excludePathPatterns 不拦截路径
        registry.addInterceptor(myInterceptorOne).addPathPatterns("/login/**").excludePathPatterns();
        registry.addInterceptor(myInterceptorTwo).addPathPatterns("/user/**").excludePathPatterns();
    }
}