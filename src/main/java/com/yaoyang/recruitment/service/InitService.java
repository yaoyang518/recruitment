package com.yaoyang.recruitment.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitService {

    @PostConstruct
    public void init() {
        initAdmin();
    }

    private void initAdmin() {
    }
}
