package com.aldt.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zhf2015 on 2020-10-23.
 */
@SpringBootApplication
public class SpringMybatisApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringMybatisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisApplication.class, args);
        logger.info("=========> SpringBoot Start Success <=========");
    }
}
