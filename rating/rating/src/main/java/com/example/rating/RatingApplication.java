package com.example.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

@SpringBootApplication
@EnableDiscoveryClient  // Annotation to enable a DiscoveryClient implementation.
@LoadBalancerClients
public class RatingApplication { 

	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}

}
