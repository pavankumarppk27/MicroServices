package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ms.feign.WelcomeFeignClients;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WelcomeService {

	@Autowired
	private WelcomeFeignClients feign;
	
	@HystrixCommand(fallbackMethod = "errorFallBackMethod")
	public String getMsg() {

		String url = "http://localhost:5599/getMsg";
		WebClient build = WebClient.builder().build();
		String msg = build.get().uri(url).retrieve().bodyToMono(String.class).block();

		String resp = feign.getResp();
		
		return msg+" Welcome to MicroServices "+resp;
	}
	
	public String errorFallBackMethod() {
		
		return "Something Problem is Occured.Try Later...!";
	}

}
