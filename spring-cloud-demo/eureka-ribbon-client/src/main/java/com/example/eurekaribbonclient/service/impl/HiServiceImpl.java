package com.example.eurekaribbonclient.service.impl;

import com.example.eurekaribbonclient.service.HiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiServiceImpl implements HiService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getError")
    public String getHi(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }

    @Override
    public String getHiConfig(String name) {
        return restTemplate.getForObject("http://config-client/hi?name="+name,String.class);
    }

    public String getError(String name) {
        return "hi,"+name+",is error";
    }
}
