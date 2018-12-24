package com.archib.hystrix.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${mc-server.name}")
public interface HelloFeignClient {

    @RequestMapping(value = "/rest/hello/server", method = RequestMethod.GET)
    String hello();

}