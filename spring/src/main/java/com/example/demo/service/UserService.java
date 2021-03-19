package com.example.demo.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService implements InitializingBean,DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService Bean init!!!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserService Bean Dispose!!!");
    }

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct called!!!");
    }

    @PreDestroy
    public void dispose(){
        System.out.println("@PreDestroy called!!!");
    }
}
