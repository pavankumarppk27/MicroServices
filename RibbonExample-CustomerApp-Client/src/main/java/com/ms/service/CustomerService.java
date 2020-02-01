package com.ms.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ms.constants.AppConstants;
import com.ms.feignclient.AddressFeignClient;
import com.ms.model.AddressModel;
import com.ms.model.CustomerRespModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerService {

	@Autowired
	private Environment env;

	@Autowired
	private AddressFeignClient addressFeignClient;

	public Map<Integer, CustomerRespModel> map = null;

	public CustomerService() {
		// TODO Auto-generated constructor stub

		map = new HashMap<Integer, CustomerRespModel>();

		map.put(1001, new CustomerRespModel("PAVAN KUMAR", "DEVELOPER", 40000d, null));
		map.put(1002, new CustomerRespModel("KUMAR", "TEAM LEAD", 80000d, null));
		map.put(1003, new CustomerRespModel("PRIYANKA", "TESTER", 30000d, null));
		map.put(1004, new CustomerRespModel("PAVAN", "PROJECT LEAD", 120000d, null));
	}

	@HystrixCommand(fallbackMethod = "errorFallbackMethod")
	public CustomerRespModel getCustomerDtls(Integer id) {

		String ADDRESS_URL = env.getProperty(AppConstants.ADDRESS_URL);
		CustomerRespModel customerRespModel = null;

		/**
		 * calling AddressApp by using feignclient
		 */

		AddressModel addressDtls = addressFeignClient.getAddressDtls(id);

		/**
		 * calling AddressApp by using webclient
		 */

		/*
		 * WebClient webclient = WebClient.builder().build(); AddressModel addressModel
		 * = webclient.get().uri(ADDRESS_URL,
		 * id).retrieve().bodyToMono(AddressModel.class).block();
		 */
			
		if (map.containsKey(id)) {
			customerRespModel = map.get(id);
			customerRespModel.setCustomerId(id);
			customerRespModel.setAddrModel(addressDtls);
		} else {
			return null;
		}
		return customerRespModel;
	}

	public CustomerRespModel errorFallbackMethod(Integer id) {

		return new CustomerRespModel();
	}

}
