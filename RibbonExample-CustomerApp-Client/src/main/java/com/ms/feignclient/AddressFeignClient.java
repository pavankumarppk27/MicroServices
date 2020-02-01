package com.ms.feignclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ms.model.AddressModel;



@Component
@FeignClient(name="ADDRESS-APP")
//@FeignClient(name="ZUUL-PROXY")
@RibbonClient(name="ADDRESS-APP")
public interface AddressFeignClient {
	
	@GetMapping("/getAddressDtls/id/{id}")
	public AddressModel getAddressDtls(@PathVariable("id") Integer id);


}
