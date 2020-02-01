package com.ms.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ms.model.AddressModel;

@Service
public class AddressService {
	
	public  Map<Integer,AddressModel> map=null;
	
	@Autowired
	private Environment env;

	
	 public AddressService() {

		 map=new HashMap<Integer,AddressModel>();
		 map.put(1001, new AddressModel(9999988888L,"Hyderabad","HN77-8888"));
		 map.put(1002, new AddressModel(9999977777L,"Bangalore","HN77-7777"));
		 map.put(1003, new AddressModel(9999966666L,"Hyderabad","HN77-6666"));
		 map.put(1004, new AddressModel(9999955555L,"Hyderabad","HN77-5555"));

	}
	 
	 
	 public AddressModel getAddress(Integer id) {
		 
			Integer addressAppPortNo = Integer.parseInt(env.getProperty("local.server.port"));
			AddressModel addressModel = map.get(id);			
			addressModel.setAddressAppPortNo(addressAppPortNo);
		 
		 return addressModel;
	 }
	 
	 
}
