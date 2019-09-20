package com.trilogyed.glossaryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GlossaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlossaryServiceApplication.class, args);
	}

}
