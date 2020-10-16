package com.example.sportApp.controller;

import com.example.sportApp.properties.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywm
 */
@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private CustomProperties customProperties;
    @GetMapping
    public String getUsers() {
        return "Hello Spring Security";
    }

//    @Scheduled(cron="0/5 * * * * ?")
    public void test(){
        System.out.println("定时器");
    }

    @GetMapping("/show")
    public String show(){
        return customProperties.toString();
    }
}