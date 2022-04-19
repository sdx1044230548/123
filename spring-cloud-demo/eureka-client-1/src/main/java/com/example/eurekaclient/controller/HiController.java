package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return "hi"+name+",我的端口号是"+port;
    }
}
