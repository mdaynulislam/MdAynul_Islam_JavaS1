package com.trilogyed.TaskConfig_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TaskConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskConfigServerApplication.class, args);
	}

}
