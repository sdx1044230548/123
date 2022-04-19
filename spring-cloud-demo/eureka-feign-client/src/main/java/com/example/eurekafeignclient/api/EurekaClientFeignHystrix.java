package com.example.eurekafeignclient.api;

import org.springframework.stereotype.Component;

@Component
public class EurekaClientFeignHystrix implements EurekaClientFeign{
    @Override
    public String hi(String name) {
        return "hi,"+name+",is error";
    }
}
