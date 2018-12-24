package com.archib.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ClientApp {

	public static void main(String[] args) {
		SpringApplication.run(ClientApp.class, args);
	}
}