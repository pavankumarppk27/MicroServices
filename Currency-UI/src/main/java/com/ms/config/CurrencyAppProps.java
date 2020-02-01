package com.ms.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "web-client")
@Data
@Component
public class CurrencyAppProps {
	
	private Map<String,String> messages=new HashMap<String,String>();

}
