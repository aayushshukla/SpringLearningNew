package com.infosys.myeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Annotation to activate Eureka Server related configuration. EurekaServerAutoConfiguration
public class MyeurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyeurekaserverApplication.class, args);
	}

}
