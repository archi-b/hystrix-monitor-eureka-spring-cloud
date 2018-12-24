package com.archib.hystrix.client.controller;

import com.archib.hystrix.client.feign.HelloFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/client")
@EnableFeignClients
public class HelloController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloFeignClient helloClient;

    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @RequestMapping
    public String hello() {

        LOG.info("Client hello()");
        return helloClient.hello();
    }

    public String fallback(Throwable hystrixCommand) {

        LOG.info("Client Falback()");
        return hystrixCommand.toString();
    }

}

