package com.infosys.myapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyapigatewayApplication.class, args);
	}

}
