package com.example.sportApp.config;

import com.example.sportApp.filter.MyFilter1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//public class WebConfig {
//
//    @Bean
//    public FilterRegistrationBean customFilter1{
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        MyFilter1 myFilter1 = new MyFilter1();
//        filterRegistrationBean.setFilter(myFilter1);
//        List<String> urls = new ArrayList<>();
//        urls.add("/login");
//        filterRegistrationBean.setUrlPatterns(urls);
//    }
//}
