package com.example.sportApp.config;

import com.example.sportApp.properties.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    @Autowired
    private CustomProperties customProperties;
}
