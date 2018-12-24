package com.archib.hystrix.client.feign.config;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class HelloFeignConfiguration {

    @Value("${hystrix.command.hello.execution.isolation.thread.timeoutInMilliseconds:60000}")
    private int connectTimeout;

    @Value("${feign.readTimeOut:60000}")
    private int readTimeout;

    @Bean
    public Request.Options options() {
        Request.Options options = new Request.Options(connectTimeout, readTimeout);
        return options;
    }
}
