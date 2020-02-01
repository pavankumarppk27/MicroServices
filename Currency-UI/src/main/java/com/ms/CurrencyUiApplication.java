package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
//@EnableCircuitBreaker
public class CurrencyUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyUiApplication.class, args);
	}

}
