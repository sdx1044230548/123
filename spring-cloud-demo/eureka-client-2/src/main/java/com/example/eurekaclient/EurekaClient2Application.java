package com.example.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class, args);
    }

}
