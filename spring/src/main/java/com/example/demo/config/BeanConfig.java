package com.example.demo.config;

import com.example.demo.service.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "init",destroyMethod = "dispose")
    public BeanService beanService(){
        return new BeanService();
    }
}
