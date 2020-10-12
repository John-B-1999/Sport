package com.example.sportApp.controller;

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
    @GetMapping
    public String getUsers() {
        return "Hello Spring Security";
    }

//    @Scheduled(cron="0/5 * * * * ?")
    public void test(){
        System.out.println("定时器");
    }
}