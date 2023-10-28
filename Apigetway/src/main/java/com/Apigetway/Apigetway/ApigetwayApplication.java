package com.Apigetway.Apigetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApigetwayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApigetwayApplication.class, args);
	}
}
