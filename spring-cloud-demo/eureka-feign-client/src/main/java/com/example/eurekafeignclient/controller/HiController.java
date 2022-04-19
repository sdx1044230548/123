package com.example.eurekafeignclient.controller;

import com.example.eurekafeignclient.api.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    EurekaClientFeign eurekaClientFeign;

    @RequestMapping("/hi")
    public String hi(String name){
        return eurekaClientFeign.hi(name);
    }
}
