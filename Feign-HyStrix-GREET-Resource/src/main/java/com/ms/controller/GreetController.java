package com.ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@GetMapping("/getMsg")
	public String getMsg() {
		
		return "Hi Good Mornig:";
	}

}
