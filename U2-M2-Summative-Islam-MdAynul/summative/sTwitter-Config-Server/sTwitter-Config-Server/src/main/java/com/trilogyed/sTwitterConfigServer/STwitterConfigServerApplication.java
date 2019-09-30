package com.trilogyed.sTwitterConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class STwitterConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(STwitterConfigServerApplication.class, args);
	}

}
