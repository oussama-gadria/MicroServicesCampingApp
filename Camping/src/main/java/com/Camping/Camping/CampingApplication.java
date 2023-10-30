package com.Camping.Camping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CampingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampingApplication.class, args);
	}

}
