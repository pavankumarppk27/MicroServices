package com.ms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name="GREET-SERVICE")
public interface WelcomeFeignClients {

	@GetMapping("/getMsg")
	public String getResp();

}
