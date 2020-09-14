package com.bank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class CloudConfigApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CloudConfigApplication.class, args);
	}

}