package com.test.alphatestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlphaTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaTestProjectApplication.class, args);
    }

}
