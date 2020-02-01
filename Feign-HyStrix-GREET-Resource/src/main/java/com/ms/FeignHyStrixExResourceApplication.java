package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignHyStrixExResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignHyStrixExResourceApplication.class, args);
	}

}
