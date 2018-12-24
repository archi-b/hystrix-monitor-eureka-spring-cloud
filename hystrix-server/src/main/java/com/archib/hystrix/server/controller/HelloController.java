package com.archib.hystrix.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/server")
public class HelloController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    boolean test = true;

    @GetMapping
    public String hello() {
        long timeout = 1000;

        if (test) {
            LOG.info("waiting {} ms", timeout);
            try {
                Thread.currentThread().sleep(timeout);
            }
            catch (InterruptedException ex) {}
        }
        test = !test;
        LOG.info("Server finish!");
        return "Hello World!";
    }
}
