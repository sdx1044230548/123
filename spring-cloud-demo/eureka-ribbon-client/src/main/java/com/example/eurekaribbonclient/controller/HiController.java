package com.example.eurekaribbonclient.controller;

import com.example.eurekaribbonclient.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @RequestMapping("/hi")
    public String hi(String name){
        return hiService.getHi(name);
    }

    @RequestMapping("/hiConfig")
    public String hiConfig(String name){
        return hiService.getHiConfig(name);
    }
}
