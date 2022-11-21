package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

}

//CMD: G:\Microservice2\keycloak-17.0.1\bin
//standalone.bat -Djboss.http.port=8180
//nIpHenhyZsJndynfw28fDvwCkGWBeDyV