package com.example.motoinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Enable as Discovery Client for the service registry
public class MotoInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoInventoryServiceApplication.class, args);
	}

}
