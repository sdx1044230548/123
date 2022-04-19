package com.example.eurekafeignclient.api;

import com.example.eurekafeignclient.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = EurekaClientFeignHystrix.class)
public interface EurekaClientFeign {
    @GetMapping(value = "/hi")
    public String hi(@RequestParam(value = "name") String name);
}
