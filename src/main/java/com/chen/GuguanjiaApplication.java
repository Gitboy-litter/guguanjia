package com.chen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chen.dao")
public class GuguanjiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuguanjiaApplication.class, args);
    }

}
